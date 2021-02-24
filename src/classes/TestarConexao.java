package classes;

import daos.LocalDao;

public class TestarConexao {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Local local = new Local();
		
		local.setCapacidade(500);
		local.setEndereco("Rua Sabino Filho 1715");
		local.setNome("Casa da Gata");
		
		LocalDao localDao = new LocalDao();
		
		localDao.adcionar(local);
		
		System.out.println("Local Gravado!!!");
		
	}
}
