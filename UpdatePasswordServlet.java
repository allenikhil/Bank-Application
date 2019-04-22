package org.jsp.app.controllerM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.app.modelB.MainHibernate;

@WebServlet(urlPatterns="/view/forgot")
public class UpdatePasswordServlet  extends HttpServlet
{

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	PrintWriter pw=resp.getWriter();
	if(req.getParameter("psw").equals(req.getParameter("cpsw")))
	{
		int r=MainHibernate.update(req.getParameter("eid"), req.getParameter("psw"));
		
		if(r==1)
			pw.println("<html><body><h1>Sucessfully Updated</h1><a href='index.html'><button>Home</button></a></body></html>");
		else
			pw.println("<html><body><h1>Your Mail Doesnot Exit In Our Bank Please Check Your Mail</h1><a href='index.html'><button>Home</button></a></body></html>");
	}
	else
	{
		
		pw.println("<html><body><h1>Password Mismatch</h1><a href='index.html'><button>Home</button></a></body></html>");

	}
}
}
