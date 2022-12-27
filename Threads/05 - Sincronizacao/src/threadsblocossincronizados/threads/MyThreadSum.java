package threadsblocossincronizados.threads;

import threadsblocossincronizados.service.Calculator;

public class MyThreadSum implements Runnable {

	private String name;
	private int[] nums;
	private static Calculator calculator = new Calculator();

	public MyThreadSum(String name, int[] nums) {
		this.name = name;
		this.nums = nums;
		new Thread(this, name).start();
	}

	@Override
	public void run() {

		System.out.println(this.name + " started");

		int sum = calculator.arraySum(this.nums);

		System.out.println("Thread sum result " + this.name + " is " + sum);
		System.out.println(this.name + "finished");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}

	public static Calculator getCalculator() {
		return calculator;
	}

	public static void setCalculator(Calculator calculator) {
		MyThreadSum.calculator = calculator;
	}

}
