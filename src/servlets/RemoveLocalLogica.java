package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Local;
import daos.LocalDao;

public class RemoveLocalLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Local local = new Local();
		local.setId(id);
		
		LocalDao localDao= new LocalDao();
		localDao.deletar(local);
		
		
		return "locais.jsp";
	}
}
