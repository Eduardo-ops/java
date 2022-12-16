package threadsprioridadesexecucao.program;

import tthreadsprioridadesexecucao.threads.MyThreadRunnable;

public class Program1 {

	public static void main(String[] args) {

		MyThreadRunnable thread1 = new MyThreadRunnable("Thread#1", 1000);
		MyThreadRunnable thread2 = new MyThreadRunnable("Thread#2", 1000);
		MyThreadRunnable thread3 = new MyThreadRunnable("Thread#3", 1000);

		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);

		/*
		 * Passando um número inteiro
		 */
		t1.setPriority(5);
		t2.setPriority(1);
		t3.setPriority(3);

		/*
		 * Passando um número inteiro
		 */
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
