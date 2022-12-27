package threadsblocossincronizados.service;

public class Calculator {

	private int sum;

	public int arraySum(int[] array) {
		this.sum = 0;

		for (int i = 0; i < array.length; i++) {
			this.sum += array[i];

			System.out.println("Executing the sum " + Thread.currentThread().getName());

			try {
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return sum;
	}

}
