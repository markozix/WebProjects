package thread_ovi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Profesor_Thread extends Glavni_Abs_Thread {

	
	private CountDownLatch prvaBarijera;
	private CyclicBarrier drugaBarijera;
	private int brStudenata;
	
	//treba reset za drugu barijeru nakon sto pukne
	
	public Profesor_Thread(CountDownLatch inicijalniThread, int pauza) {
		super(inicijalniThread, pauza, 2);
		
		this.brStudenata = 2;
		this.drugaBarijera = new CyclicBarrier(brStudenata);
		this.prvaBarijera = new CountDownLatch(brStudenata);
		
	}
	
	//reset druge barijere
	public void resetDrugeBrijere() {
		this.drugaBarijera = new CyclicBarrier(brStudenata);
	}
	

	public CountDownLatch getPrvaBarijera() {
		return prvaBarijera;
	}

	public void setPrvaBarijera(CountDownLatch prvaBarijera) {
		this.prvaBarijera = prvaBarijera;
	}

	public CyclicBarrier getDrugaBarijera() {
		return drugaBarijera;
	}

	public void setDrugaBarijera(CyclicBarrier drugaBarijera) {
		this.drugaBarijera = drugaBarijera;
	}

	public int getBrStudenata() {
		return brStudenata;
	}

	public void setBrStudenata(int brStudenata) {
		this.brStudenata = brStudenata;
	}

	
	
	
}
