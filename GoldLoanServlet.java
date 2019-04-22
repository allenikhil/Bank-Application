package org.jsp.app.controllerM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.app.modelB.MainHibernate;

@WebServlet(urlPatterns="/view/goldloan")
public class GoldLoanServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	PrintWriter pw=resp.getWriter();
	int r=MainHibernate.goldLoan(req.getParameter("amt"), req.getParameter("yr"), req.getParameter("city"), req.getParameter("mn"));
	
	if(r==1)
	  pw.println("<html><body><h1>Gold Loan Applyed Sucessfully</h1><a href='index.html'><button>Home</button></a></body></html>");
	else
	  pw.println("<html><body><h1>Loan Failed</h1><a href='index.html'><button>Home</button></a></body></html>");	
	
}
}
