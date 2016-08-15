package org.dmike.concurrencies;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

	@Override
	public int next() {
		lock.lock();
		try{
			++current;
			Thread.yield();
			++current;
			return current;
		}finally{
			lock.unlock();
		}
	}

	private int current = 0;
	private Lock lock = new ReentrantLock();
}
