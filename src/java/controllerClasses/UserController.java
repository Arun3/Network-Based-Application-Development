package controllerClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import utilityClasses.hash;
import utilityClasses.ActivationMail.*;
import utilityClasses.hash.*;

import modelClasses.User;
import utilityClasses.UserDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.util.*;
import utilityClasses.ActivationMail;

/**
 *
 * @author Arun
 */
@WebServlet("/userController")

public class UserController extends HttpServlet {
    private Object passwordUtil;

   @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/login.jsp";
        String message="";
        HttpSession theUser=request.getSession();
        String cname;
       int port;
       
       
        
        HttpSession session=request.getSession();
         
       
        
        

         try{
   
        // get current action
        String action = request.getParameter("action");
        String password="";
        String salt="";
             if(action.equals("login"))
             {
                 // get parameters from the request
                 String Email = request.getParameter("email");
                 String Password = request.getParameter("password");
                 String id=request.getParameter("token");
                 System.out.println("token from url"+id);
                 String Name="";
                 
                 
                 // store data in User object and save User object in database
                 
                 int i=UserDB.validate(Email,Password,salt);
                    
                
                 System.out.println("In User controller");
                        System.out.println(i);
                 if(i==1)
                 {
                     // set User object in request object and set URL
                     User user = new User();
                     request.setAttribute("user", user);
                        Name=UserDB.retrieveName(Email);
                        
                     user.setName(Name);
                      user.setEmail(Email);
                     session.setAttribute("theUser",user);
                     session.setAttribute("email",Email);
                     request.setAttribute("user",user);
                     theUser.setAttribute("name",theUser);
                     theUser.setAttribute("email",Email);

                     message="";
                     url = "/postlogin.jsp";   // the "thanks" page
                 }
                 else
                 {
                     message="Username/Password not valid";
                     request.setAttribute("message",message);
                     url="/login.jsp";
                 }
             }
             else if(action.equals("create"))
             {
                 // get parameters from the request
                 String Name = request.getParameter("name");
                 String Email = request.getParameter("email");
                 String Password = request.getParameter("password");
                 String confirmPassword = request.getParameter("confirmpassword");
                 
                 String id=request.getParameter("token");
                 
                 
                 if(Password.equals(confirmPassword))
                 {
        
                  String token=UUID.randomUUID().toString().replaceAll("-", "");
                  String token1=token.substring(0,10);
                  System.out.println("token"+token);
                  String msg="";
                  
                   User user = new User();
                  
                   user.setName(Name);
                   user.setEmail(Email);
                   user.setPassword(Password);
                   user.setParticipants(0);
                   user.setCoins(0);
                   user.setParticipation(0);
                   
                  
                   session.setAttribute("user", user);
                   
                   try {
                        salt = hash.getSalt();
                        password = hash.hashAndSaltPassword(Password, salt);
                        System.out.println("Hash:"+password);
                        System.out.println("salt:"+salt);
                    } catch (Exception e) {
                       System.out.println("coundn't register due to technical error, please try again!");
                    }
                   
                    UserDB.insert(user,token1,salt,password);
                    String subject="Activation Link";
                    if(id.equals(""))
                    {
                    msg="http://localhost:8080/NbadProject1/userController?action=activate&token="+token1;
                    }
                    else
                    {
                       msg="http://localhost:8080/NbadProject1/userController?action=activate&token="+token1+"&user="+id;
                        
                    }
                    
                    ActivationMail.sendActivation(user.getEmail(), subject, msg, "","");
                    message="Please follow the link sent to your mail to verify your account";
                    
                request.setAttribute("message",message);
                     url="/login.jsp";
                 }
                 else{
                 message="Passwords doesn't match";
                 request.setAttribute("message",message);
                 url="/signup.jsp";
                 }
                 
                 
             }     
             
             else if(action.equals("updatePwd"))
             {
                 // get parameters from the request
                 String token = request.getParameter("token");
                password=request.getParameter("password");
               String confirmPassword=request.getParameter("confirmPassword");
                 
                 
                 if(password.equals(confirmPassword))
                 {
                     try {
                        salt = hash.getSalt();
                        password = hash.hashAndSaltPassword(password, salt);
                        System.out.println("Hash:"+password);
                        System.out.println("salt:"+salt);
                    } catch (Exception e) {
                       System.out.println("coundn't register due to technical error, please try again!");
                    }
                     
                     String email=UserDB.updatePwd(token,password,salt);
                     if(email.equals(null))
                     {
                           message="Error!!! Please try again later";
                 request.setAttribute("message",message);
                 url="/requestPwd.jsp";
                     }
                     else
                     {
                           message="Password Set successfully.Please login";
                 request.setAttribute("message",message);
                 url="/login.jsp";
                     }
                   
                 }
                 else
                 {
                       
                   message="Passwords doesnt match";
                 request.setAttribute("message",message);
                 url="/requestPwd.jsp";
                 }
                 
                 
                 
             }     
        
             
             else if(action.equals("resetrequest"))
             {
                 // get parameters from the request
                 
                 String Email = request.getParameter("email");
                 
                 String token=UUID.randomUUID().toString().replaceAll("-", "");
                  String token1=token.substring(0,10);
                  System.out.println("token"+token1);
                  
                  int a=UserDB.forgotPwd(token1,Email);
                  
                  if(a==1)
                  {
                      String subject="Password Reset Link";
                    String msg="http://localhost:8080/NbadProject1/userController?action=reset&token="+token1;
                    ActivationMail.sendActivation(Email, subject, msg, "","");
                    message="Please follow the link sent to your mail to reset your password";
                    
                request.setAttribute("message",message);
                     url="/forgotPwd.jsp";

                  }
                  else
                  {
                      message="Error!!! Please try again later";
                    request.setAttribute("message",message);
                     url="/forgotPwd.jsp";   
                  }
                 
                 
                 
                
                 
                 
             }     
        
              
                
               
                 
                
                 String remoteAddr = request.getRemoteHost();
                Integer remotePort = request.getRemotePort();
                Cookie cookieAddr = new Cookie("remoteAddr", remoteAddr);
                response.addCookie(cookieAddr);
                Cookie cookiePort = new Cookie("remotePort", remotePort.toString());
                response.addCookie(cookiePort);
                request.setAttribute("address",remoteAddr);
                request.setAttribute("port",remotePort);
                
                 
                 
                 // forward request and response objects to specified URL
                 getServletContext()
                         .getRequestDispatcher(url)
                         .forward(request, response);
             } 
    catch(ClassNotFoundException e)
    {
    String sqlresult="Class Not found exception"+e;
    request.setAttribute("message",e);
    url="/login.jsp";
     getServletContext()
                         .getRequestDispatcher(url)
                         .forward(request, response);
    }
         catch(SQLException e)
    {
    String sqlresult="SQL Exception"+e;
            request.setAttribute("message","User already exists");
            url="/signup.jsp";
             getServletContext()
                         .getRequestDispatcher(url)
                         .forward(request, response);
    }
    }
             
            
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        
        try{
        String url = "";
        String name="";
        User user = null;
        HttpSession session = null;
        String action=request.getParameter("action");
         HttpSession session2=request.getSession();
          HttpSession theUser=request.getSession();
        user = (User) session2.getAttribute("theUser");
        System.out.println("Email in user controller"+session2.getAttribute("theUser"));
          User user1=new User();
          user1=(User)session2.getAttribute("user");
          
         
        
        if(action.equals("how"))
        {
            
            
            user.setEmail(name);
            System.out.println("Email in user controller"+session2.getAttribute("email"));
         if(session2.getAttribute("theUser")==null)
        {
            url="/how.jsp";
        }
        
       
        
        else
        {
           String email=(String)session2.getAttribute("email");
           System.out.println("email object in how"+email);
           int participants=UserDB.getAttribute(email);
           int coins=UserDB.coins(email);
          int participation=UserDB.participation(email);
          
           user.setParticipants(participants);
           user.setCoins(coins);
           user.setParticipation(participation);
          
           request.setAttribute("user",user);
           
           
       
                     
                    url="/main.jsp"; 
        }
        }
        
        else if(action.equals("activate"))
             {
                 // get parameters from the request
                 String token = request.getParameter("token");
                 String userToken=request.getParameter("user");
               if(userToken!=null)
               {
                 String recommEmail=UserDB.validateUsertoken(userToken);
                  int coins=UserDB.updateCoinsForRecommedn(recommEmail);
         int participants=UserDB.getAttribute(recommEmail);
           int coins1=UserDB.coins(recommEmail);
          int participation=UserDB.participation(recommEmail);
               
          User user5=new User();
           user5.setParticipants(participants);
           user5.setCoins(coins1);
           user5.setParticipation(participation);
          
           request.setAttribute("user",user5);
        session2.setAttribute("user",user5);
               }
               String salt="";
               String Password="";
               try {
                        salt = hash.getSalt();
                        Password = hash.hashAndSaltPassword(Password, salt);
                        System.out.println("Hash:"+Password);
                        System.out.println("salt:"+salt);
                    } catch (Exception e) {
                       System.out.println("coundn't register due to technical error, please try again!");
                    }
                 String email=UserDB.activate(token,salt);
                 if(email.equals(null))
                 {
                    String message="User record not found";
                 request.setAttribute("message",message);
                 url="/signup.jsp";
                 }
                 else
                 {
                       
                 System.out.println("email from token"+email);
                  
                  User user2=new User();
                  user2.setEmail(email);
                  
                   
                  String Name=UserDB.retrieveName(email);
                   user2.setName(Name);
                      
                     session2.setAttribute("theUser",user2);
                     session2.setAttribute("email",email);
                     request.setAttribute("user",user2);
                     theUser.setAttribute("name",theUser);
                   
                    
                   
                     url="/main.jsp";
                 }
                 
                 
                 
             }  
        
        else if(action.equals("reset"))
             {
                 // get parameters from the request
                 String token = request.getParameter("token");
               
                 String email=UserDB.resetPassword(token);
                 
                 User user2=new User();
                 user2.setEmail(email);
                 
                     if(email.equals(null))
                     {
                          String message="Error!!! Please try again later";
                 request.setAttribute("message",message);
                 url="/requestPwd.jsp";
                     }
                     else
                     {
                          
                 request.setAttribute("email",email);
                 request.setAttribute("user",user2);
                 url="/requestPwd.jsp";
                     }
                   
                 }
                     
        
             
        else if(action.equals("about"))
        {
            
            
            
         if(session2.getAttribute("theUser")==null)
        {
            url="/about.jsp";
        }
        
       
        
        else
        {
             String email=(String)session2.getAttribute("email");
           System.out.println("email object in how"+email);
           int participants=UserDB.getAttribute(email);
           int coins=UserDB.coins(email);
          int participation=UserDB.participation(email);
          
           user.setParticipants(participants);
           user.setCoins(coins);
           user.setParticipation(participation);
          
           request.setAttribute("user",user);
        url="/aboutl.jsp";
        }
        }
         else if(action.equals("home"))
        {
            
            
            
         if(session.getAttribute("theUser")==null)
        {
            url="/home.jsp";
        }
        
       
        
        else
        {
        url="/main.jsp";
        }
        }
          else if(action.equals("main"))
        {
            
            
            
         if(session.getAttribute("theUser")==null)
        {
            url="/login.jsp";
        }
        
       
        
        else
        {
        url="/main.jsp";
        }
        }
        else if(action.equals("logout"))
             {
                 // get parameters from the request
                 
                 HttpSession session1=request.getSession();
                 session1.invalidate();
                 url="/home.jsp";
                 
                
                
                
             }   
        
       
             
        getServletContext()
                         .getRequestDispatcher(url)
                         .forward(request, response);
        }
    catch(ClassNotFoundException e)
    {
    String sqlresult="Class Not found exception"+e;
    request.setAttribute("message",e);
    String url="/login.jsp";
     getServletContext()
                         .getRequestDispatcher(url)
                         .forward(request, response);
    }
         catch(SQLException e)
    {
    String sqlresult="SQL Excetion"+e;
            request.setAttribute("message",e);
            String url="/login.jsp";
             getServletContext()
                         .getRequestDispatcher(url)
                         .forward(request, response);
    }
    }}