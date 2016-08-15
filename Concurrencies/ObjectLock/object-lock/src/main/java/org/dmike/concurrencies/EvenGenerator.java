package org.dmike.concurrencies;

public class EvenGenerator extends IntGenerator{

	@Override
	public int next() {
		++current;
		Thread.yield();
		++current;
		return current;
	}
	private int current = 0;
}
