package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import classes.Show;

import daos.ShowDao;

@WebServlet("/adcionaShow")
public class AdcionaShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		
		String nome = request.getParameter("nome");
		String dataEmTexto = request.getParameter("data");
		String bandas = request.getParameter("bandas");
		String local = request.getParameter("local");
		Calendar dataShow = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataShow = Calendar.getInstance();
			dataShow.setTime(date);
		}catch (ParseException e) {
			out.println("Erro de conversão de data!!");
			return;
		}
		
	
		Show show = new Show();
		
		show.setNome(nome);
		show.setBandas(bandas);
		show.setLocal(local);
		show.setDataShow(dataShow);
		
		
		ShowDao showDao;
		try {
			showDao = new ShowDao();
			showDao.adcionar(show);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request,response);
		
	}

}
