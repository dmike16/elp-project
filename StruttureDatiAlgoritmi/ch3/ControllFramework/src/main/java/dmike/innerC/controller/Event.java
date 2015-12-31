package dmike.innerC.controller;

public abstract class Event {
	public abstract void action();
	public boolean ready(){
		return System.nanoTime() >= eventTime;
	}
	public void start(){
		eventTime = System.nanoTime() + delayTime;
	}
	public Event(long delayTime){
		this.delayTime = delayTime;
		start();
	}
	protected final long delayTime;
    private long eventTime;
}
