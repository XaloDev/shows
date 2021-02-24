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
import classes.Local;
import daos.BandaDao;
import daos.LocalDao;

@WebServlet("/adcionaLocal")
public class AdcionaLocalServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String capacidade = request.getParameter("capacidade");
		
		Local local = new Local();
		local.setEndereco(endereco);
		local.setNome(nome);
		local.setCapacidade(capacidade);
		
		LocalDao localDao;
		try {
			localDao = new LocalDao();
			localDao.adcionar(local);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/locais.jsp");
		rd.forward(request,response);
		
		
	}

}
