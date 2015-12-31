package dmike.GreenHouse;

import dmike.innerC.controller.*;

public class GreenHouse{
	public static void main(String[] args) {
		GreenHouseControls gc = new GreenHouseControls();
		Event[] eventList ={
			gc.new LigthOn(200)
		};
		gc.addEvent(gc.new Restart(2000,eventList));
		gc.addEvent(new GreenHouseControls.Terminate(2000));
		gc.run();
	}
}

class GreenHouseControls extends Controller{
	public static class Terminate extends Event{
		public Terminate(long delayTime){
			super(delayTime);
		}
		public void action(){
			System.exit(0);
		}
		public String toString(){
			return "Terminating...";
		}
	}
	public class Restart extends Event{
		public Restart(long delayTime, Event[] eventList){
			super(delayTime);
			this.eventList = eventList;
			for(Event e: eventList){
				addEvent(e);
			}
		}
		public void action(){
			for(Event e: eventList){
				e.start();
				addEvent(e);
			}
			start();
			addEvent(this);
		}
		public String toString(){
			return "Restarting Sistem";
		}
		private Event[] eventList;
	}
	public class LigthOn extends Event {
		public LigthOn(long delayTime){
			super(delayTime);
		}
		public void action(){
			ligth = true;
		}
		public String toString(){
			return "Light On";
		}
	}
   public class LigthOff extends Event{
      public LigthOff(long delayTime){
         super(delayTime);
      }
   }
	private boolean ligth = false;
}