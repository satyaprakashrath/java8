package java8codeclasses;

import java.util.concurrent.Executors;

public class TestRunnable {
	public static void main(String[] args) {

		Runnable r = new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("Inside a thread:" + Thread.currentThread());
					System.out.println("Sleeping for 30 secs");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Executors.newSingleThreadExecutor().execute(r);
		///add code with timer to stop execution after 5 minutes or certain time
	}

}
