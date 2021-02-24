package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Local;
import daos.LocalDao;

public class EditaLocalLogica implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		String idString = String.valueOf(id);
		Local local = new Local();
		LocalDao localDao = new LocalDao();
		local = localDao.pesquisar(idString);
		
		req.setAttribute("nomeLocal", local.getNome());
		req.setAttribute("idLocal", local.getId());
		req.setAttribute("enderecoLocal", local.getEndereco());
		req.setAttribute("capacidadeLocal", local.getCapacidade());
		
		//req.setAttribute("genero", banda.getGenero());
		
		return "editar-local.jsp";
	}
}
