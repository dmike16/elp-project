package org.dmike.concurrencies;

public class SerialNumberGenerator {
	private static volatile int serial = 0;
	public static int nextSerialNumber(){
		return serial++;
	}
}
