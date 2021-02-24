package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Banda;
import daos.BandaDao;

@WebServlet("/adcionaBanda")
public class AdcionaBandaServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		
	
		
		Banda banda = new Banda();
		banda.setGenero(genero);
		banda.setNome(nome);
		
		BandaDao bandaDao;
		try {
			bandaDao = new BandaDao();
			bandaDao.adcionar(banda);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/bandas.jsp");
		rd.forward(request,response);
		
		
	}

}
