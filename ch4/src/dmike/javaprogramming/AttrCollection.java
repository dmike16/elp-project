package dmike.javaprogramming;


class Attr {
	private final String name;
	private Object value = null;
	
	public Attr(String name){
		this.name =name;
	}
	 public Attr(String name, Object obj){
		 this.name =name;
		 value =obj;
	 }
	 
	 public String getName(){
		 return name;
	 }
	 
	 public Object getValue(){
		 return value;
	 }
	 
	 public Object setValue(Object obj){
		 Object oldVal =value;
		 value =obj;
		 return oldVal;
	 }
	 
	 public String toString(){
		 return name+ "='"+ value +"'";
	 }
}


public class AttrCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AttributedBody sun = new AttributedBody("sun",null);
		sun.add(new Attr("Hot",1000));
		
		System.out.println(sun.attrs());
		System.out.println(sun.find("Hot"));
		System.out.println(sun.remve("Hot"));
	}

}
