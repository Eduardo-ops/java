package threadscomstartrunsleep.program;

import threadscomstartrunsleep.threads.MyThread;

public class Program {

	public static void main(String[] args) {

		MyThread mThread1 = new MyThread("Thread #1", 1000);
		MyThread mThread2 = new MyThread("Thread #2", 2000);
	}

}
