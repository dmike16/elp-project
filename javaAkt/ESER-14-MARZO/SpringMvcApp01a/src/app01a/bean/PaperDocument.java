package app01a.bean;

public class PaperDocument implements Document {

	private String name;
	
	
	public PaperDocument(String name) {
		super();
		this.name = name;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
