/** Example of Metho and Class
 * @author dmike
 */

package dmike16.javaprogramming;

class celestialBody {
	public long idNum;
	public String name="<unanmed";
	public celestialBody orbits = null;
	
	private static long nextID = 0;
	
	{
		idNum = ++nextID;
	}
	
	public celestialBody(String bodyName, celestialBody orbitsAround){
		name = bodyName;
		orbits = orbitsAround;
	}
	
	public String toString(){
		String desc= idNum+" ("+name+")";
		if(orbits!=null)
			desc +=" orbits "+orbits.toString();
		return desc;
	}
}

public class bodyPrint{
	public static void main(String[] args){
		celestialBody sun = new celestialBody("sun",null);
		celestialBody earth = new celestialBody("earth",sun);
		
		System.out.println("Body "+ sun);
		System.out.println("Body "+earth);
	}
}
