package thread_ovi;

import java.util.concurrent.CountDownLatch;

public class Asistent_Thread extends Glavni_Abs_Thread {

	private CountDownLatch latchAsistent;
	private int cnt = 0;
	private boolean slobodan;
	
	/*
	public Asistent_Thread(CountDownLatch inicijalniThread, int pauza, int brStudenata, CountDownLatch latchAsistent,
			int cnt, Boolean slobodan) {
		super(inicijalniThread, pauza, brStudenata);
		this.latchAsistent = latchAsistent;
		this.cnt = cnt;
		this.slobodan = slobodan;
	}*/
	
	public Asistent_Thread(CountDownLatch inicijalniThread, int pauza) {
		super(inicijalniThread, pauza, 1);
	}

	
	
	
	
}
