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
			return "Axé";
		} else if (genero == Genero.FORRO){
			return "Forró";
		} else {
			
			return "Rock";
		}
		
	}
	
	
	public void setGenero(String genero) {
		if (genero.trim().equalsIgnoreCase("axe") || genero.trim().equalsIgnoreCase("axé")) {
			this.genero = Genero.AXE;
		} else if(genero.trim().equalsIgnoreCase("forro") || genero.trim().equalsIgnoreCase("forró")) {
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
