package dmike.javaprogramming;

import java.util.Iterator;

class AttributedBody extends Body implements Attr.Attributed {

	private AttributeImpl attrImp =new AttributeImpl();
	
	public AttributedBody (String Name, Body orbitsAround){
		super(Name,orbitsAround);
	}
	
	@Override
	public void add(Attr newAttr) {
		// TODO Auto-generated method stub
		attrImp.add(newAttr);
	}

	@Override
	public Attr find(String attrName) {
		// TODO Auto-generated method stub
		return attrImp.find(attrName);
	}

	@Override
	public Attr remve(String attrName) {
		// TODO Auto-generated method stub
		return attrImp.remve(attrName);
	}

	@Override
	public Iterator<Attr> attrs() {
		// TODO Auto-generated method stub
		return attrImp.attrs();
	}

}
