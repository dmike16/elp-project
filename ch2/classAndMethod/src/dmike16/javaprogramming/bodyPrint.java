/** Example of Metho and Class
 * @author dmike
 */

package dmike16.javaprogramming;

class celestialBody {
	private long idNum;
	private String name="<unanmed";
	private celestialBody orbits = null;
	
	private static long nextID = 0;
	
	{
		idNum = nextID++;
	}
	
	public celestialBody(String bodyName, celestialBody orbitsAround){
		name = bodyName;
		orbits = orbitsAround;
	}
	
	public String toString(){
		String desc= idNum+" ("+name+")";
		if(orbits !=null)
			desc +=" orbits "+orbits.toString();
		return desc;
	}
	
	public long getID(){return idNum;}
	public String getName(){ return name;}
	public void setName(String newName){
		name =newName;
	}
	public celestialBody getOrbits(){ return orbits;}
	public void setOrbits(celestialBody orbitsAround){
		orbits =orbitsAround;
	}
	public boolean orbitsAround(celestialBody other){
		return (orbits ==other);
	}
	public boolean orbitsAround(long id){
		return (orbits != null && orbits.idNum == id);
	}
	public native int helloBody();
	
	static{
		System.loadLibrary("helloBody");
	}
}

public class bodyPrint{
	public static void main(String[] args){
		celestialBody sun = new celestialBody("sun",null);
		celestialBody earth = new celestialBody("earth",sun);
		
		earth.setName("Terra");
		
		System.out.println("Body "+ sun);
		System.out.println("Body "+earth);
		earth.helloBody();
	}
}
