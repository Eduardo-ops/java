package threadsinterfacerunnable.program;

import threadsinterfacerunnable.threads.MyThreadRunnable;

public class Program {

	public static void main(String[] args) {

		MyThreadRunnable thread1 = new MyThreadRunnable("Thread#1", 1000);
		MyThreadRunnable thread2 = new MyThreadRunnable("Thread#1", 2000);
	}

}
