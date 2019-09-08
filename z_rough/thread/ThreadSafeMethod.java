package com.mrb.java.thread;

class Counter{
	private int count;
	
	// This will make the increment method Thread Safe
	public synchronized void inc() {
		count = count + 1;
	}
	
	public int getCount() {
		return count;
	}

}

public class ThreadSafeMethod  {
	
	public static void main(String[] args) throws Exception{
		
		Counter c = new Counter();
		
		Thread t2 = new Thread(
				new Runnable() {
					public void run() {
						for(int i=0; i<1000; i++) {
							c.inc();
						}
					}
				});
		
		Thread t1 = new Thread(
				new Runnable() {
					public void run() {
						for(int i=0; i<1000; i++) {
							c.inc();
						}
					}
				});

		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(c.getCount());
	}
}
