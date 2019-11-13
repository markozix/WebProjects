package thread_ovi;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Glavni_Abs_Thread implements Runnable {
	
	private Semaphore semafor;
	private CountDownLatch inicijalniThread;
	private AtomicBoolean pokrenut;
	private String name;
	private int pauza;
	private Random random;
	
	

	public Glavni_Abs_Thread(CountDownLatch inicijalniThread, int pauza, int brStudenata) {
		super();
		this.inicijalniThread = inicijalniThread;
		this.pauza = pauza;
		
		//pomozi boze da radi ovaj semafor
		this.semafor = new Semaphore(brStudenata, true);
		
		this.random = new Random();
		this.name = Thread.currentThread().getName();
		this.pokrenut = new AtomicBoolean();
		
	}

	//ocjenjivanje studenta
	public int ocijeniStudenta() {
		//random do 10
		return random.nextInt(10) + 1;
	}

	public Semaphore getSemafor() {
		return semafor;
	}



	public void setSemafor(Semaphore semafor) {
		this.semafor = semafor;
	}



	public CountDownLatch getInicijalniThread() {
		return inicijalniThread;
	}



	public void setInicijalniThread(CountDownLatch inicijalniThread) {
		this.inicijalniThread = inicijalniThread;
	}



	public AtomicBoolean getPokrenut() {
		return pokrenut;
	}



	public void setPokrenut(AtomicBoolean pokrenut) {
		this.pokrenut = pokrenut;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPauza() {
		return pauza;
	}



	public void setPauza(int pauza) {
		this.pauza = pauza;
	}



	public Random getRandom() {
		return random;
	}



	public void setRandom(Random random) {
		this.random = random;
	}



	@Override
	public void run() {
		
		//priprema za stampanje imena
		Thread.currentThread().setName(this.getClass().getSimpleName() + " thread");
		
		this.name = Thread.currentThread().getName();
		//asistent nit
		try {
			Thread.sleep(this.pauza);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//setujem na true, nit je pokrenuta
		this.pokrenut.set(true);
		
		//spustim barijeru za 1
		this.inicijalniThread.countDown();
		/* ne radi nesto bas
		try {
			this.inicijalniThread.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		/*for(i=0;i<Integer.MAX_VALUE;i++) {
			
			//dohvatim nit i ona radi
			this.pokrenut.get();
			
		}*/
		
		while(this.pokrenut.get()) {
			
			
			
			
			
			
		}
		
		
		
		
		

	}
	
	
	
	public synchronized void stop() {
		this.pokrenut.set(false);
	}

}
