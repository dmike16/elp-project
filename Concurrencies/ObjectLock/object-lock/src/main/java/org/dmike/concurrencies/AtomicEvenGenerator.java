package org.dmike.concurrencies;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {

	@Override
	public int next() {
		
		return current.addAndGet(2);
	}
	private AtomicInteger current = new AtomicInteger(0);

}
