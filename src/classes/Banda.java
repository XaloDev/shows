package classes;

public class Banda {
	
	private String nome;
	private Genero genero;
	private Long id;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		if (genero == Genero.AXE) {
			return "Ax�";
		} else if (genero == Genero.FORRO){
			return "Forr�";
		} else {
			
			return "Rock";
		}
		
	}
	
	
	public void setGenero(String genero) {
		if (genero.trim().equalsIgnoreCase("axe") || genero.trim().equalsIgnoreCase("ax�")) {
			this.genero = Genero.AXE;
		} else if(genero.trim().equalsIgnoreCase("forro") || genero.trim().equalsIgnoreCase("forr�")) {
			this.genero = Genero.FORRO;
		} else {
			this.genero = Genero.ROCK;
		}
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	 

}
