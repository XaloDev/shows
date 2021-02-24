package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Banda;
import daos.BandaDao;

public class SalvarBandaLogica implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		long id = Long.parseLong(req.getParameter("id"));
		
		String idString = String.valueOf(id);
		
		
		
		Banda banda = new Banda();
		
		BandaDao bandaDao = new BandaDao();
		banda = bandaDao.pesquisar(idString);
		banda.setGenero(genero);
		banda.setNome(nome);
		bandaDao.alterar(banda);
		
		return "bandas.jsp";
	}
}
