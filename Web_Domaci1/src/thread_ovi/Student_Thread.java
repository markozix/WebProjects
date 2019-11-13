package thread_ovi;

import java.nio.file.AtomicMoveNotSupportedException;
import java.util.concurrent.atomic.AtomicReference;

import main.Main;

public class Student_Thread implements Runnable {

	
	private Asistent_Thread asistent;
	// ne moze int...
	private long odbrana;
	private boolean gotov = false;
	private int ocjena;
	private String name;
	

	public Student_Thread(Asistent_Thread asistent, long odbrana, boolean gotov, int ocjena, String name) {
		super();
		this.asistent = asistent;
		this.odbrana = odbrana;
		this.gotov = gotov;
		this.ocjena = ocjena;
		this.name = name;
	}

	public Student_Thread(Asistent_Thread asistent, long odbrana) {
		super();
		this.asistent = asistent;
		this.odbrana = odbrana;
		this.ocjena = 0;
	}


	public Asistent_Thread getAsistent() {
		return asistent;
	}

	public void setAsistent(Asistent_Thread asistent) {
		this.asistent = asistent;
	}

	public long getOdbrana() {
		return odbrana;
	}

	public void setOdbrana(long odbrana) {
		this.odbrana = odbrana;
	}

	public boolean isGotov() {
		return gotov;
	}

	public void setGotov(boolean gotov) {
		this.gotov = gotov;
	}

	public int getOcjena() {
		return ocjena;
	}

	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	private void kraj(Glavni_Abs_Thread gl) throws InterruptedException{
		
		//asistent daje ocjenu studentu
		name = gl.getName();
		ocjena = gl.ocijeniStudenta();
		gotov = true;
		
		//kao prosao je jedan pa sad drugi u red
		gl.getSemafor().release();
	
			
		/*if(gl instanceof Profesor_Thread) {
			name = gl.getName();
			ocjena = gl.ocijeniStudenta();
			gotov = true;
			((Profesor_Thread)gl).getPrvaBarijera().countDown();
			((Profesor_Thread)gl).getPrvaBarijera().wait();
			((Profesor_Thread) gl).resetDrugeBrijere();
			
			//za barijeru treba smanjiti, sacekati oba i resetovati na krjau
			 
		}*/
		
		
	}
	
	
	@Override
	public void run() {
		
		AtomicReference<String> dolaznoVrijeme = new AtomicReference<String>(Main.getCurrentTimeStamp());
		AtomicReference<String> pomocni = new AtomicReference<String>();
		AtomicReference<String> pocetnoVrijeme = new AtomicReference<String>();
		
		while(!gotov && Main.pokrenuta.get()) {
			
			//if(profesor.getSemafor().tryAcquire() && !gotov)
			if(!gotov && this.asistent.getSemafor().tryAcquire()) {
				try {
					pocetnoVrijeme.set(Main.getCurrentTimeStamp());
					Thread.sleep(odbrana);
					//kraj(asistent);
					this.kraj(asistent);
					//ako baci gresku hvatam dole pa, ispisem
					//ako se prekine mozda da gresku
				} catch (Exception e) {
					try {
						//kraj(asistent);
						this.kraj(asistent);
					} catch (Exception e2) {
						e.printStackTrace();
					}
				}
			}
			

		}
		
		
		//ako je zavrsena radnja
		if(gotov) {
			
			//dodajemo ocjenu
			Main.prosjek.addAndGet(ocjena);
			
			System.out.println("Thread: "+ Thread.currentThread().getName() + " " + 
								"Vrijeme dolaska: " + dolaznoVrijeme.get() + " " +
								"Pregleda: " + name + " " +
								"Brani se: " + odbrana + " " + 
								"Dolazak na odbranu: " + pocetnoVrijeme.get() + " " +
								"Ocjena: " + ocjena);
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	

}
