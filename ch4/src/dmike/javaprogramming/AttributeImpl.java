package dmike.javaprogramming;

import java.util.*;

class AttributeImpl implements Attributed {
	protected Map<String,Attr> attrTable = new HashMap<String,Attr>();
	

	@Override
	public void add(Attr newAttr) {
		// TODO Auto-generated method stub
		attrTable.put(newAttr.getName(), newAttr);
	}

	@Override
	public Attr find(String attrName) {
		// TODO Auto-generated method stub
		return attrTable.get(attrName);
	}

	@Override
	public Attr remve(String attrName) {
		// TODO Auto-generated method stub
		return attrTable.remove(attrName);
	}

	@Override
	public Iterator<Attr> attrs() {
		// TODO Auto-generated method stub
		return attrTable.values().iterator();
	}
	
	public Iterator<Attr> iterator(){
		return attrs();
	}

}
