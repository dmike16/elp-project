package app02a.catalogo;

public class Libro {

	private String id;
	private String titolo;
	private String autore;
	
	public Libro(String id, String titolo, String autore) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
	}

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", autore=" + autore
				+ "]";
	}
	
}
