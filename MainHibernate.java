package org.jsp.app.modelB;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainHibernate
{
/*public static void main(String[] args) 
{
	Configuration confg=new Configuration();
	confg.configure("customer_hibernate.xml");
	
	SessionFactory sef=confg.buildSessionFactory();
	
	Session ses=sef.openSession();
	
	  Transaction t=ses.beginTransaction();
	  NetBank n1=new NetBank();
	  n1.setAccountNumber("12345");
	  n1.setEmailId("allenikhil70@gmail.com");
	  n1.setPassword("ab123");
	  n1.setAccountHolder("nikhil");
	  n1.setAccountType("personal");
	  ses.save(n1);
	  
	   Customer c1=new Customer();
	   c1.setAccountNumber("12345");
	   c1.setCustomerName("Nikhil");
	  c1.setEmailId("alle@gmail.com");
	  c1.setMobileNumber("94440");
	  c1.setBalance("123.34");
	  c1.setAccountType("personal");
	  ses.save(c1);
	 
	  HomeLoan h1=new HomeLoan();
	  h1.setAmount("123");
	  h1.setCity("hyd");
	  h1.setInCome("20000");
	  h1.setName("nikhil");
	  h1.setType("new home");
	  h1.setMobileNumber("9440683072");
	  ses.save(h1);
	  t.commit();
		ses.close();

}
*/	
public static int bankAccountRegistration(String name,String mobileNumber,String email ,String type)
	{
		Configuration confg=new Configuration();
		confg.configure("customer_hibernate.xml");
		
		SessionFactory sef=confg.buildSessionFactory();
		
		Session ses=sef.openSession();
		
		 Transaction t=ses.beginTransaction();
		 
		 Random rn=new Random();
		 int Number= rn.nextInt(10000000);
		 String accountNumber=Number+"";
		 String balance="0.0";
		 
		 Customer c=new Customer(accountNumber,name,email,mobileNumber,balance,type);
		  ses.save(c);
		  t.commit();
		  ses.close();
		 
		 
		
		return Number;
}

public static int netBankRegistration(String accountNumber,String email,String password,String name,String type)
{
	Configuration confg=new Configuration();
	confg.configure("customer_hibernate.xml");
	
	SessionFactory sef=confg.buildSessionFactory();
	
	Session ses=sef.openSession();
	
	  Transaction t=ses.beginTransaction();
	  
	
	  String hql_query="from Customer where accountNumber=?";
	  Query q=ses.createQuery(hql_query);
	  q.setString(0, accountNumber);
	  
	  List<Customer> l=q.list();
	 
	  
	  
	  String hql_query1="from NetBank where accountNumber=?";
	  Query q1=ses.createQuery(hql_query1);
	  q1.setString(0, accountNumber);
	  
	  List <NetBank> l1=q1.list();
	  
	  
	  /*System.out.println(l);
	  System.out.println(l1);*/
	  if(l==null || l.isEmpty())
	  {
		  return 0;
	  }
	  else
	  {
		  if(l1==null || l1.isEmpty())
		  {
			  if(l.get(0).getAccountType().equals(type))
			  {
				  NetBank n1=new NetBank(accountNumber,email,password,name,type);
				  ses.save(n1);
				  t.commit();
				  ses.close();
				  return 1;
			  }
			  else
			  {
				  return 2;
			  }
		  }
		  else
		  {
			  return 3;
		  }
	  }
		
}

public static List<NetBank> login(String email,String password)
{
	Configuration confg=new Configuration();
	confg.configure("customer_hibernate.xml");
	
	SessionFactory sef=confg.buildSessionFactory();
	
	Session ses=sef.openSession();
	
	  Transaction t=ses.beginTransaction();
	
	 String hql_query="from NetBank where EmailId=? and Password=?";
	 
	  Query q=ses.createQuery(hql_query);
	  q.setString(0, email);
	  q.setString(1, password);
	  
	  List<NetBank> l=q.list();
	  
      t.commit();
      
      if(l==null || l.isEmpty())
    	  return null;
      
		ses.close();
		
		return l;		
}

public static int update(String email,String password)
{
	Configuration confg=new Configuration();
	confg.configure("customer_hibernate.xml");
	
	SessionFactory sef=confg.buildSessionFactory();
	
	Session ses=sef.openSession();
	
	  Transaction t=ses.beginTransaction();
	  
	 String hql_query="update NetBank set password=? where emailId=?";
	 
	 Query query = ses.createQuery(hql_query);
	 query.setString(0, password);
	 query.setString(1, email);
	 
	 int result = query.executeUpdate();
	 t.commit();
	 ses.close();
	 
	 if(result==1)
		 return 1;
	 else
		 return 0;
	 
	 
}
public static int homeLoan(String type,String amount,String name,String city,String inCome,String mobileNumber)
{
	Configuration confg=new Configuration();
	confg.configure("customer_hibernate.xml");
	
	SessionFactory sef=confg.buildSessionFactory();
	
	Session ses=sef.openSession();
	
	  Transaction t=ses.beginTransaction();
	  
	HomeLoan h1=new HomeLoan(mobileNumber, type, amount, name, city, inCome);
	  
	  ses.save(h1);
	  t.commit();
	  ses.close();
	return 1;
}

public static int carLoan(String type,String city,String brand,String time,String amount,String years,String status,String mobileNumber)
{
	Configuration confg=new Configuration();
	confg.configure("customer_hibernate.xml");
	
	SessionFactory sef=confg.buildSessionFactory();
	
	Session ses=sef.openSession();
	
	  Transaction t=ses.beginTransaction();
	  
	CarLoan c1=new CarLoan(type, city, brand, time, amount, years, status, mobileNumber);
	  
	  ses.save(c1);
	  t.commit();
	  ses.close();
	return 1;
}

public static int goldLoan(String amount,String time,String city,String mobileNumber)
{
	Configuration confg=new Configuration();
	confg.configure("customer_hibernate.xml");
	
	SessionFactory sef=confg.buildSessionFactory();
	
	Session ses=sef.openSession();
	
	  Transaction t=ses.beginTransaction();
	  String y=time+" years";
	GoldLoan g1=new GoldLoan(amount, y, city, mobileNumber);

	  ses.save(g1);
	  t.commit();
	  ses.close();
	return 1;
}
}
