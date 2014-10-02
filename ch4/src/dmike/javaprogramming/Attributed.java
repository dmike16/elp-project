package dmike.javaprogramming;

public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remve(String attrName);
	java.util.Iterator<Attr> attrs();
}
