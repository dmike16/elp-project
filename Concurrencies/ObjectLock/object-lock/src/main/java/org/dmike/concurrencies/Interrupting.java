package org.dmike.concurrencies;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SleepBlocked implements Runnable{

	@Override
	public void run() {
		try{
			TimeUnit.SECONDS.sleep(100);
		}catch(InterruptedException e){
			System.out.println("[ERROR] Interrupted Exception");
		}
		System.out.println("[INFO] Exiting SleepBlocked");
	}
	
}

class IOBlocked implements Runnable{
	private InputStream in;
	public IOBlocked(InputStream in){
		this.in = in;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			System.out.println("[INFO] Waiting for IO");
			in.read();
		}catch(IOException e){
			if(Thread.currentThread().isInterrupted()){
				System.out.println("[ERROR] Interrupted from blocked IO");
			}else{
				throw new RuntimeException(e);
			}
		}
		System.out.println("[INFO] Exiting from blocked IO");
	}
	
}

class NIOBlocked implements Runnable{
	private final SocketChannel sc;
	public NIOBlocked(SocketChannel sc){
		this.sc = sc;
	}
	@Override
	public void run() {
		try{
			System.out.println("[INFO] Waiting for IO in " + this);
			sc.read(ByteBuffer.allocate(1));
		}catch(ClosedByInterruptException e){
			System.out.println("[ERROR] Closed By InterruptException");
		}catch(AsynchronousCloseException e){
			System.out.println("[ERROR] Close by AsynchronousException ");
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		System.out.println("[INFO] Exiting from blocked IO " + this);
	}
	
}

class SynchronizedBlocked implements Runnable{

	public synchronized void f(){
		while(true){
			Thread.yield();
		}
	}
	
	public SynchronizedBlocked(){
		new Thread(){
			@Override
			public void run(){
				f();
			}
		}.start();
	}
	@Override
	public void run() {
		System.out.println("[INFO] Try to call f()");
		f();
		System.out.println("[INFO] Exiting from SynchronizedBlocked");
	}
	
}
class BlockedMutex{
	private Lock lock = new ReentrantLock();
	public BlockedMutex(){
		lock.lock();
	}
	public void f(){
		try{
			lock.lockInterruptibly();
		}catch(InterruptedException e){
			System.out.println("[ERROR] Interrupted from lock acquiring");
		}
	}
}
class Blocked2 implements Runnable{
	BlockedMutex blocked = new BlockedMutex();
	@Override
	public void run(){
		System.out.println("[INFO] Try to call f()");
		blocked.f();
		System.out.println("[INFO] Exiting from SynchronizedBlocked");
	}
}
class NeedsCleanup{
	private final int id;
	public NeedsCleanup(int id){
		this.id = id;
		System.out.println("[INFO] Needs Clenaup " + id);
	}
	public void cleanup(){
		System.out.println("[INFO] Cleaning up " + id);
	}
}

class Blocked3 implements Runnable{

	private volatile double d = 0.0D;
	@Override
	public void run() {
		try{
			while(!Thread.interrupted()){
				NeedsCleanup n1 = new NeedsCleanup(1);
				try{
					System.out.println("[INFO] Sleeping");
					TimeUnit.SECONDS.sleep(1);
					NeedsCleanup n2 = new NeedsCleanup(2);
					try{
						System.out.println("[INFO] Calculating");
						for(int i = 1; i < 2500000; i++){
							d = d + (Math.PI + Math.E) / d;
						}
						System.out.println("[INFO] Finisch for cycle");
					}finally{
						n2.cleanup();
					}
				}finally{
					n1.cleanup();
				}
			}
			System.out.println("[ERROR] Exit via while test");
		}catch(InterruptedException e){
			System.out.println("[ERROR] Interrupted Exception");
		}
	}
	
}
public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	static void test(Runnable r)throws InterruptedException{
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("[INFO] Interrupting " + r.getClass().getName());
		f.cancel(true);
		System.out.println("[INFO] Interrupt sent to " + r.getClass());
	}
	public static void main(String[] args) throws Exception{
		/*test(new SleepBlocked());
		test(new IOBlocked(System.in));
		ServerSocket server = new ServerSocket(8080);
		InputStream socinput = new Socket("localhost",8080).getInputStream();
		test(new IOBlocked(socinput));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("[INFO] Closing " + socinput.getClass().getName());
		socinput.close();
		System.out.println("[INFO] Closing " + System.in.getClass().getName());
		System.in.close();
		System.out.println("[INFO] Aborting System.exit(0)");
		exec.shutdown();
		System.exit(0);
		ServerSocket server = new ServerSocket(8080);
		InetSocketAddress isa = new InetSocketAddress("localhost",8080);
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);
		Future<?> f = exec.submit(new NIOBlocked(sc1));
		exec.execute(new NIOBlocked(sc2));
		exec.shutdown();
		TimeUnit.SECONDS.sleep(1);
		f.cancel(true);
		TimeUnit.SECONDS.sleep(1);
		sc2.close();
		server.close();
		test(new Blocked2());
		TimeUnit.SECONDS.sleep(1);
		exec.shutdown();*/
		if(args.length != 1){
			System.out.println("[ERROR] Needs one command argument.");
			System.exit(1);
		}
		exec.execute(new Blocked3());
		TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
		exec.shutdownNow();
	}
}
