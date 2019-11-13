package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import thread_ovi.Asistent_Thread;
import thread_ovi.Profesor_Thread;
import thread_ovi.Student_Thread;

public class Main {
	
	//isto kao i za ostale
	public static final AtomicInteger prosjek = new AtomicInteger(0);
	//nako nkoliko pocinju niti da rade
	//za thread mora static i final da se doda
	private static final int kasniAsistent = 0;
	private int kasniProf = 3000;
	//da li radi
	//mora statici final da bi se pristupilo iz Main-a
	public static final AtomicBoolean pokrenuta = new AtomicBoolean(true);
	public static final int kasniProfesor = 2000;
	
	 //konverzija za vrijeme sa neta
	public static long convertToMills(double seconds) {
        return (long)(seconds*1000);
    }
	//trenutno vrijeme sa neta
	public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
    }
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		int brStudenata = sc.nextInt();
		//samo asistent ne radi prof
		//da radi u zagradu bi isla 2
		CountDownLatch niti = new CountDownLatch(1);
		//Profesor_Thread prof = new Profesor_Thread(niti, kasniProfesor);
		Asistent_Thread asistent = new Asistent_Thread(niti, kasniAsistent);
		//opet 1 jer ne radi za dva
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(asistent);
		
		
		ScheduledExecutorService sce = Executors.newScheduledThreadPool(3);
		
		//cekamo obojicu prof i asistenta
		niti.await();
		
		for(int i = 0; i < brStudenata; i++) {
			//vrijeme koje student trosi da brani svoj rad
			long odbranaStudenta = Main.convertToMills(0.5 + Math.random() * 0.5);
			//vrijeme izmedju 0 i 1, tj vrijeme dolaska studenta
			//radimo konverziju vremena i ovde i iznad
			long pocetakOdbraneStudenta = Main.convertToMills(Math.random() + Double.MIN_VALUE);
			
		
			Student_Thread student = new Student_Thread(asistent, odbranaStudenta);
			//prosljedjujemo pocetak i milisekunde u skedzuler
			sce.schedule(student, pocetakOdbraneStudenta, TimeUnit.MILLISECONDS);
			
			
		}
		
		//pr. cekanje od 9 sekundi, ako se stavi 13 studenata svi stignu
		//ako smanjimo ne stizu svi, jer je kratko vrijeme i mogu samo jedan po jedan
		//vrijeme da se saceka tj trajanje termina
		//moze se izvrsiti onoliko studenata kolika je realna sansa da oni brane manje od 5 sekundi
		Thread.sleep(5000);
		//setujemo da vise ne radi
		Main.pokrenuta.set(false);
		sce.shutdownNow();
		
		asistent.stop();
		es.shutdown();
		
		//za zvono, da se saceka i ipak upise ocjena
		//stavimo pauzu mzd sad radi
		Thread.sleep(1000);
		//ispisi se zivota ti.........................
		System.out.println("Prosjek ocjena" + " " + prosjek.get() / (double)brStudenata);
		
		
		
		
		

	}
	
	
	
	
	

}
