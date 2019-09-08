package com.mrb.java.thread;


class See implements Runnable{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("See***");
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}

class Saw implements Runnable{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Saw");
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}


public class UsingRunnableInterface {
	
	public static void main(String[] args) {
		Thread see = new Thread(new See());
		Thread saw = new Thread(new Saw());
		
		see.start();
		saw.start();
	}
}
