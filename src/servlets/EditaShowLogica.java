package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Show;
import daos.ShowDao;

public class EditaShowLogica implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		String idString = String.valueOf(id);
		Show show = new Show();
		ShowDao showDao = new ShowDao();
		show = showDao.pesquisar(idString);
		
		req.setAttribute("nomeShow", show.getNome());
		req.setAttribute("idShow", show.getId());
		req.setAttribute("localShow", show.getLocal());
		req.setAttribute("bandasShow", show.getBandas());
		req.setAttribute("dataShow", show.getDataFormatada());
		
		
		return "editar-show.jsp";
	}
}
