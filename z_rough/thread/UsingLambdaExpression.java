package com.mrb.java.thread;

public class UsingLambdaExpression {
	
	public static void main(String[] args) {
		Thread see = new Thread( 
				() -> {
					for(int i=0; i<5; i++) {
						System.out.println("See***");
						try {Thread.sleep(1000);}catch(Exception e) {}
					}
				}
			
		);
		Thread saw = new Thread( 
				() -> {
						for(int i=0; i<5; i++) {
							System.out.println("Saw");
							try {Thread.sleep(1000);}catch(Exception e) {}
						}
					}
		);
		
		see.start();
		saw.start();
	}
}
