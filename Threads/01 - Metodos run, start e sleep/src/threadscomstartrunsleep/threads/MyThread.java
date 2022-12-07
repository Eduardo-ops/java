package threadscomstartrunsleep.threads;

public class MyThread extends Thread {

	private String name;
	private int time;

	public MyThread(String name, int time) {
		this.name = name;
		this.time = time;
		start();
	}

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
