package threadsmetodosisaliveejoin.program;

import threadsmetodosisaliveejoin.threads.MyThreadRunnable;

public class Program2 {

	public static void main(String[] args) {

		MyThreadRunnable thread1 = new MyThreadRunnable("Thread#1", 1000);
		MyThreadRunnable thread2 = new MyThreadRunnable("Thread#1", 1000);
		MyThreadRunnable thread3 = new MyThreadRunnable("Thread#1", 1000);

		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);

		t1.start();
		t2.start();
		t3.start();

		/*
		 * Utilizar o método Join é a forma mais adequada para fazer com que espere uma
		 * determinada execução de uma thread ser finalizada;
		 */
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.getMessage();
			e.printStackTrace();
		}

		System.out.println("Program finished");
	}

}
