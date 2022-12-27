package threadsblocossincronizados.program;

import threadsblocossincronizados.threads.MyThreadSum;

public class Program {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5 };

		MyThreadSum thread1 = new MyThreadSum("Thread1", array);
		MyThreadSum thread2 = new MyThreadSum("Thread2", array);
	}

}
