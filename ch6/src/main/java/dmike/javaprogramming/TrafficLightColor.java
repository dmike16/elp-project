package dmike.javaprogramming;

enum TrafficLightColor {
	RED(new Color("RED")){
		public Color getColor(){return lightColor;}
	},
	YELLOW(new Color("Yellow")){
		public Color getColor(){return lightColor;}
	},
	GREEN(new Color("Green")){
		public Color getColor(){return lightColor;}
	};
	
	Color lightColor;
	TrafficLightColor(Color color){
		lightColor =color;
	}
	
	public abstract Color getColor();
	
}

class Color {
	private String name;
	private String type="RGB";
	
	public Color(){
		name = "no name";
	}
	public Color(String name){
		this.name = name;
	}
	public Color(String name, String type){
		this(name);
		this.type = type;
	}
	public void setName(String color){
		name = color;
	}
	public void setType(String tipo){
		type =tipo;
	}
	public String getName(){ return name;}
	public String getType(){ return type;}
	
	public String toString(){
		return "[Name: "+name + ", Type: "+type+"]";
	}

}
