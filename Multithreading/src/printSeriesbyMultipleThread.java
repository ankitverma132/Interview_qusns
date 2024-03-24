
public class printSeriesbyMultipleThread extends Thread {

	static int m = 0;

	public void run() {
		m += 1;
		for (int i = 0; i < 10; i++) {
			System.out.println(m * i);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		// ExecutorService ex =

		printSeriesbyMultipleThread t1 = new printSeriesbyMultipleThread();
		printSeriesbyMultipleThread t2 = new printSeriesbyMultipleThread();
		t1.start();
		t1.join();

		t2.start();

	}

}