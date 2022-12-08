package threadsinterfacerunnable.threads;

public class MyThreadRunnable implements Runnable {

	private String name;
	private int time;

	public MyThreadRunnable(String name, int time) {
		this.name = name;
		this.time = time;
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 11; i++) {
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
