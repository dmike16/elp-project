package dmike.javaprogramming;


class Body {
	private long idNum;
	private String name="<unanmed";
	private Body orbits = null;
	
	private static long nextID = 0;
	
	{
		idNum = nextID++;
	}
	
	public Body(String bodyName, Body orbitsAround){
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
	public Body getOrbits(){ return orbits;}
	public void setOrbits(Body orbitsAround){
		orbits =orbitsAround;
	}
	public boolean orbitsAround(Body other){
		return (orbits ==other);
	}
	public boolean orbitsAround(long id){
		return (orbits != null && orbits.idNum == id);
	}

}