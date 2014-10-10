package dmike.javaprogramming;

class Attr {
	private final String name;
	private Object value = null;
	
	public static interface Attributed {
		void add(Attr newAttr);
		Attr find(String attrName);
		Attr remve(String attrName);
		java.util.Iterator<Attr> attrs();
	}
	
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
