package org.jsp.app.controllerM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.app.modelB.MainHibernate;

@WebServlet(urlPatterns="/view/reg")
public class NetBankRegistrationServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		PrintWriter pw=resp.getWriter();
		if(req.getParameter("psw").equals(req.getParameter("cpsw")))
		{
			
			int b= MainHibernate.netBankRegistration(req.getParameter("acn"), req.getParameter("eid"), req.getParameter("psw"),req.getParameter("name"),req.getParameter("account"));
			if(b==1)
			{
				rd=req.getRequestDispatcher("jsp files/netbankcreation.jsp");
				rd.forward(req, resp);
			}
			else if(b==0)
			{
				rd=req.getRequestDispatcher("jsp files/failsignup.jsp");
				rd.forward(req, resp);
			}
			else if(b==2)
			{
				rd=req.getRequestDispatcher("jsp files/accountmismatch.jsp");
				rd.forward(req, resp);
			}
			else
			{
				rd=req.getRequestDispatcher("jsp files/existingnetbank.jsp");
				rd.forward(req, resp);
			}
			
		}
		else
		{
			rd=req.getRequestDispatcher("jsp files/passwordmismatch.jsp");
			rd.forward(req, resp);
		}
	}
}
