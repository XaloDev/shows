package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Show;
import daos.ShowDao;

public class RemoveShowLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Show show = new Show();
		show.setId(id);
		
		ShowDao showDao = new ShowDao();
		showDao.deletar(show);
		
		
		return "index.jsp";
	}
}
