package dmike.innerC.controller;

import java.util.*;

public class Controller {
	public void run(){
		while(eventList.size() > 0){
			for(Event e : new ArrayList<Event>(eventList)){
				if (e.ready()){
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
	public void addEvent(Event c){
		eventList.add(c);
	}
  	private List<Event> eventList = new ArrayList<>();  
}
