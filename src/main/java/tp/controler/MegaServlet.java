package tp.controler;

import java.io.IOException;
import java.util.ArrayList;

import tp.model.bo.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MegaServlet extends HttpServlet {
	Library library;
	Library card;
	
	@Override
	public void init() throws ServletException {
		card = new Library();
		library=new Library();
		library.addBook(new Book("AA3344","Livre1",300));
		library.addBook(new Book("NJN333","Livre2",455.8));
		library.addBook(new Book("RRTZ65","Livre3",150));
		library.addBook(new Book("PPJH11","Livre4",230.65));
		library.addBook(new Book("NNN333","Livre5",66));
		library.addBook(new Book("XX9090","Livre6",100));
		library.addBook(new Book("WRADQ4","Livre7",377));
		library.addBook(new Book("KXSBC6","Livre8",99));
		library.addBook(new Book("QSCBN2","Livre9",120));
		library.addBook(new Book("XQJQ2Z","Livre10",45.8));
		library.addBook(new Book("QXKL2V","Livre11",828));
		library.addBook(new Book("SDLVLS","Livre12",665));
		library.addBook(new Book("SCDBJ7","Livre13",77));
		library.addBook(new Book("UYZ776","Livre14",98.90));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		if(path.endsWith("Books.do") && req.getMethod().equals("GET"))
		{
			req.setAttribute("library", library);
			req.getRequestDispatcher("Books.jsp").forward(req, resp);
		}else if(path.endsWith("addtocard.do") && req.getMethod().equals("POST"))
		{
			String[] listSBN = req.getParameterValues("checked");
			if(listSBN!=null)
			{
				for(int i=0;i<listSBN.length;i++)
				{
					Book b = library.getBook(listSBN[i]);
					card.addBook(b);
					System.out.println(listSBN[i]);	
				}
			}
			req.getSession().setAttribute("card", card);
			req.getRequestDispatcher("Card.jsp").forward(req, resp);
		}else if(path.contains("delete.do") && req.getMethod().equals("GET"))
		{
			String sbn = req.getParameter("SBN");
			card.removebook(sbn);
			req.getRequestDispatcher("Card.jsp").forward(req, resp);
		}else if (path.endsWith("deleteall.do") && req.getMethod().equals("GET"))
		{
			card.getBooks().clear();
			req.getRequestDispatcher("Card.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	@Override
	public void destroy() {
		
	}
}
