package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Local;
import daos.LocalDao;

public class SalvarLocalLogica implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String capacidade = req.getParameter("capacidade");
		long id = Long.parseLong(req.getParameter("id"));
		
		String idString = String.valueOf(id);
		
		
		
		Local local = new Local();
		
		LocalDao localDao = new LocalDao();
		local = localDao.pesquisar(idString);
		
		local.setEndereco(endereco);
		local.setNome(nome);
		local.setCapacidade(capacidade);
		localDao.alterar(local);
		
		return "locais.jsp";
	}
}
