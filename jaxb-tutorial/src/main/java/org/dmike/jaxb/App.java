package org.dmike.jaxb;

public class App {
	public static void main(String[] args){
		Hello h = new Hello();
		h.make("Bella,Vajo", "it");
		h.make("hello,boy", "en");
		h.marshall();
	}
}
