package classes;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Show {
	
	private Calendar dataShow;
	private String nome;
	private Long id;
	private String bandas;
	private String local;

	public Calendar getDataShow() {
		return dataShow;
	}

	public void setDataShow(Calendar dataShow) {
		this.dataShow = dataShow;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getBandas() {
		return bandas;
	}

	public void setBandas(String bandas) {
		this.bandas = bandas;
	}
	
	public String getDataFormatada() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = getDataShow().getTime();
		
		return formato.format(data);
	}


	

}
