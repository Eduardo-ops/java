package threadsmetodosisaliveejoin.threads;

public class MyThreadRunnable implements Runnable {

	private String name;
	private int time;

	public MyThreadRunnable(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(name + " counter " + i);
				Thread.sleep(this.time);
			}
		} 
		catch (InterruptedException e) {
			e.getMessage();
			e.printStackTrace();
		}

		System.out.println(name + " finished the executing");
	}

}
