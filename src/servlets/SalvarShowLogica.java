package servlets;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Show;
import daos.ShowDao;

public class SalvarShowLogica implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PrintWriter out = res.getWriter(); 
		String nome = req.getParameter("nome");
		String local = req.getParameter("local");
		String bandas = req.getParameter("bandas");
		String dataEmTexto = req.getParameter("data");
		long id = Long.parseLong(req.getParameter("id"));
		Calendar dataShow = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataShow = Calendar.getInstance();
			dataShow.setTime(date);
		}catch (ParseException e) {
			out.println("Erro de conversão de data!!");
			return null;
		}
		
		String idString = String.valueOf(id);
		
		
		
		Show show = new Show();
		
		ShowDao showDao = new ShowDao();
		show = showDao.pesquisar(idString);
		
		show.setLocal(local);
		show.setNome(nome);
		show.setBandas(bandas);
		show.setDataShow(dataShow);
		showDao.alterar(show);
		
		return "index.jsp";
	}
}
