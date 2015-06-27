package org.profesorfalken.examples.base.volatiledemo;

public class TestVolatile {
	volatile Counter counter = new Counter();

	public void test() {
		new Thread(new Runnable() {
			public void run() {
				while (counter.getCounterValue() < 5) {
					counter.increment();
					System.out.println("Thread " + this.toString()
							+ ". Counter: " + counter.getCounterValue());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while (counter.getCounterValue() < 5) {
					counter.increment();
					System.out.println("Thread " + this.toString()
							+ ". Counter: " + counter.getCounterValue());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public static void main(String[] args) throws Exception {
		new TestVolatile().test();
	}
}
