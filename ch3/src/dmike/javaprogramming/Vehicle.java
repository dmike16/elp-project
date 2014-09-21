package dmike.javaprogramming;

abstract class EnergySource{
	abstract String startSource();
}

class Battery extends EnergySource{
	public String startSource(){
		return startType;
	}
	private final static String startType="Battery";
}

class GasTank extends EnergySource{
	public String startSource(){
		return startType;
	}
	private final static String startType="Gas";
}

class VehicleBox {	
	VehicleBox(){
		ID=nextID++;
	}
	VehicleBox(String name){
		this();
		owner = name;
	}
	VehicleBox(EnergySource source){
		this();
		type =source;
	}
	public  String getOwner(){
		return owner;
	}
	public float getSpeed(){
		return currentSpeed;
	}

	public int getID(){
		return ID;
	}
	public static int getNextID(){
		return nextID;
	}
	
	public void setOwner(String name){
		owner = name;
	}
	
	public void setSpeed(float speed){
		currentSpeed  =speed;
	}
	
	public void Start(EnergySource source){
		type = source;
		System.out.println(ID +": Energy Start Type: "+ type.startSource());
	}
		
	private float currentSpeed=0;
	private String owner="<unnamed>";
	private final int ID;
	private static int nextID=0;
	private EnergySource type =null;


}

class PassengerVehicle extends VehicleBox {	
	public PassengerVehicle(){
		
	}
	public PassengerVehicle(long seats){
		numbSeats = seats;
	}
	public PassengerVehicle(String name){
		super(name);
	}
	public PassengerVehicle(String name, long seats){
		super(name);
		numbSeats = seats; 
	}
	
	public long getSeats(){
		return numbSeats;
	}
	private long numbSeats=0;
}

public class Vehicle {
	public static void main(String[] args ){
		VehicleBox  Volvo = new VehicleBox();
		VehicleBox BMW = new VehicleBox("Roccia");
		PassengerVehicle pass = new PassengerVehicle("Socio",5);
		Volvo.setOwner("Ciccio");
		Volvo.setSpeed(146);
		BMW.setSpeed(230);
		pass.setSpeed(130);
		BMW.Start(new Battery());
		
		System.out.println("ID: "+ Volvo.getID()+" Owner: "+ 
		Volvo.getOwner()+ " Speed: "+Volvo.getSpeed());
		System.out.println("ID: "+ BMW.getID()+" Owner: "+ 
		BMW.getOwner()+ " Speed: "+BMW.getSpeed());
		System.out.println("ID: "+ pass.getID()+" Owner: "+ 
				pass.getOwner()+ " Speed: "+pass.getSpeed()+
				" N.Seats: "+ pass.getSeats());
		System.out.println("NextID: "+ VehicleBox.getNextID());
	}
}
