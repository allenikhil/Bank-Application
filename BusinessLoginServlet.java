package org.jsp.app.controllerM;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.app.modelB.MainHibernate;
import org.jsp.app.modelB.NetBank;

@WebServlet(urlPatterns="/view/blogin")
public class BusinessLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	   RequestDispatcher rd=null;
	   PrintWriter pw=resp.getWriter();;
	   
	List<NetBank> businesslogin=MainHibernate.login(req.getParameter("eid"),req.getParameter("psw"));

		if(businesslogin!=null)
		{
			String user=businesslogin.get(0).getAccountHolder();
			String accnum=businesslogin.get(0).getAccountNumber();
			String mailid=businesslogin.get(0).getEmailId();
			String type=businesslogin.get(0).getAccountType();
			
			ServletContext scon=getServletContext();
			scon.setAttribute("user",user);
			scon.setAttribute("accnum",accnum);
			scon.setAttribute("mailid", mailid);
			scon.setAttribute("type", type);
			
			rd=req.getRequestDispatcher("jsp files/blogin.jsp");
			rd.forward(req, resp);
		}
		else
		{
			pw.println("<html><body><h1>User name or Password wrong or Account Type Wrong</h1><br><a href='index.html'><button>Home</button></a><br><a href='signup.html' style='color:red'>New to NetBanking?</a></body></html>");
		}
	}	
}
