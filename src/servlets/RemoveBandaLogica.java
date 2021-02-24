package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Banda;
import daos.BandaDao;

public class RemoveBandaLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Banda banda = new Banda();
		banda.setId(id);
		
		BandaDao bandaDao = new BandaDao();
		bandaDao.deletar(banda);
		
		
		return "bandas.jsp";
	}
}
