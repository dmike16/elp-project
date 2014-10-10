package dmike.javaprogramming;


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
