package app02a.catalogo;

public class Disco {

	private String id;
	private String titolo;
	private String artista;
	
	public Disco(String id, String titolo, String artista) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.artista = artista;
	}

	public Disco() {
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

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", titolo=" + titolo + ", artista="
				+ artista + "]";
	}
	
}
