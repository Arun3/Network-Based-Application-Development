import java.io.*;
import java.sql.SQLException;
import java.util.UUID;
import javax.servlet.*;
import javax.servlet.http.*;
import modelClasses.User;
import utilityClasses.UserDB;

public class MailApp extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url="";
        HttpSession session2=request.getSession();	
                     String email=(String)session2.getAttribute("email");
        String action=request.getParameter("action");
        if(action.equals("recommend"))
        {
         String token=UUID.randomUUID().toString().replaceAll("-", "");
                  String token1=token.substring(0,10);
                  System.out.println("token"+token1);
          String email1=request.getParameter("email");
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String msg=message+"\n\nhttp://localhost:8080/NbadProject1/signup.jsp?token="+token1;
        SendMail.send(to,subject, msg, user, pass);
        
            try{
      
                int count=UserDB.recommendationToken(email1,token1);
        }
            catch(ClassNotFoundException e)
    {
    String sqlresult="Class Not found exception"+e;
  
    }
         catch(SQLException e)
    {
    String sqlresult="SQL Excetion"+e;
            
            url="/login.jsp";
             
    }
        
        out.println("Mail send successfully");
        url="/confirmr.jsp";
        
        }
        else if(action.equals("contact"))
        {
             String to = "researchparticipations@gmail.com";
        String subject = request.getParameter("name");
        String message =  request.getParameter("message");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        contactEmail.contact(to,subject, message, user, pass);
        try
        {
         int participants=UserDB.getAttribute(email);
           int coins1=UserDB.coins(email);
          int participation=UserDB.participation(email);
          User user1=new User();
           user1.setParticipants(participants);
           user1.setCoins(coins1);
           user1.setParticipation(participation);
        
          
           request.setAttribute("user",user1);
        session2.setAttribute("user",user1);
        out.println("Mail send successfully");
        url="/confirmc.jsp";
        }
                  catch(ClassNotFoundException e)
    {
    String sqlresult="Class Not found exception"+e;
  
    }
         catch(SQLException e)
    {
    String sqlresult="SQL Excetion"+e;
            
            url="/login.jsp";
             
    }
        
        }
        else
        {
            url="/main.jsp";
        }
         getServletContext()
                         .getRequestDispatcher(url)
                         .forward(request, response);
        }
    }   
