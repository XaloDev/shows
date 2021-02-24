package classes;

public class Local {

	private Long id;
	private String nome;
	private String endereco;
	private int capacidade;
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = Integer.parseInt(capacidade);
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
