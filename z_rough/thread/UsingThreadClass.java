package com.mrb.java.thread;


class Ping extends Thread{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Ping");
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}

class Pong extends Thread{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Pong");
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}


public class UsingThreadClass {
	
	public static void main(String[] args) {
		Thread ping = new Ping();
		Thread pong = new Pong();
		
		ping.start();
		pong.start();
	}
}
