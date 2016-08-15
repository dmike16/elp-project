package org.dmike.concurrencies;

public abstract class IntGenerator {
	private volatile boolean cancelled = false;
	public abstract int next();
	public void concel(){cancelled = true;}
	public boolean isConcelled(){return cancelled;}
}
