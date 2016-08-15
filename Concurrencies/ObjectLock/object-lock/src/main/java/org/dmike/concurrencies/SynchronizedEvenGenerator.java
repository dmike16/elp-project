package org.dmike.concurrencies;

public class SynchronizedEvenGenerator extends IntGenerator {

	@Override
	public synchronized int next() {
		++current;
		Thread.yield();
		++current;
		return current;
	}

	public int current = 0;
}
