package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Banda;
import daos.BandaDao;

public class EditaBandaLogica implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		String idString = String.valueOf(id);
		Banda banda = new Banda();
		BandaDao bandaDao= new BandaDao();
		banda = bandaDao.pesquisar(idString);
		
		req.setAttribute("nomeBanda", banda.getNome());
		req.setAttribute("idBanda", banda.getId());
		
		//req.setAttribute("genero", banda.getGenero());
		
		return "editar-banda.jsp";
	}
}
