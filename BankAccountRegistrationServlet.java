package org.jsp.app.controllerM;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsp.app.modelB.MainHibernate;

@WebServlet(urlPatterns="/view/bankaccount")
public class BankAccountRegistrationServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	RequestDispatcher rd=null;
	int acc=MainHibernate.bankAccountRegistration(req.getParameter("fname"), req.getParameter("mbn"), req.getParameter("eid"),req.getParameter("account"));
	PrintWriter pw=resp.getWriter();
	if(acc>0)
	{
		ServletContext scon=getServletContext();
		scon.setAttribute("accnum", acc);
		
		rd=req.getRequestDispatcher("jsp files/accountcreation.jsp");
		rd.forward(req, resp);
	//pw.println("<html><body><h1>Your Account Number is:"+acc+"</h1><a href='index.html'><button>Home</button></a></body></html>");
	}
}
}
