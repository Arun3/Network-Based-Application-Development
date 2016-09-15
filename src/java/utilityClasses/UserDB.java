/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilityClasses;

import utilityClasses.hash.*;

import controllerClasses.*;
import modelClasses.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class UserDB {
    
    String Driver="com.mysql.jdbc.Driver";
    String DB_URL ="jdbc:mysql://localhost:3306/nbad2?zeroDateTimeBehavior=convertToNull [root on Default schema]";
    String User="root";
    String Password="Ar_un@200491";
    String s="";
    String salt="";
    String password="";
    int i;

    public static int insert(User user,String id,String salt,String password) throws ClassNotFoundException,SQLException{
         {
        String token=id;
      String sqlResult="";
      String Salt=salt;
      String Password=password;
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="insert into tempUser values(?,?,?,?,?)";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,user.getName());
      ps.setString(2,user.getEmail());
      ps.setString(3,Password);
      ps.setString(4,token);
      ps.setString(5,salt);
    
      int count=ps.executeUpdate();
      return count;
      
    }
    }
    public static int validate(String name,String password,String salt) throws ClassNotFoundException,SQLException
    {
        String DBName=name;
      String Password=password;
      String sqlResult="";
      int i=0;
      
      String hash="";
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select * from User where Email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,DBName);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
      String test=rs.getString("password");
      String Salt=rs.getString("salt");
      try {
                       
                        password = utilityClasses.hash.hashAndSaltPassword(password,Salt);
                        System.out.println("name in DB"+DBName);
                        System.out.println("password in DB"+test);
                        System.out.println("hash in DB"+password);
                        System.out.println("salt in DB"+Salt);
                       
                    } catch (Exception e) {
                       System.out.println("coundn't register due to technical error, please try again!");
                    }
      
      
          if(rs.getString("Password").equals(password))
      {
          i=1;
          
      }
      else
      {
         i=0;
      }
      }
    return i; 
    }
    
    public static String activate(String id,String salt) throws ClassNotFoundException,SQLException
    {
        String token=id;
     String email="";
     String password="";
     String name="";
      String sqlResult="";
      String Salt=salt;
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select * from tempUser where token=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,token);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
      
          name=rs.getString("UName");
          email=rs.getString("Email");
          password=rs.getString("Password");
          
          
          String Query1="insert into user values(?,?,?,0,0,0,?)";
          PreparedStatement ps1=con.prepareCall(Query1);
          ps1.setString(1,name);
          ps1.setString(2,email);
          ps1.setString(3,password);
          ps1.setString(4,salt);
          int j=ps1.executeUpdate();
          
      }
    return email; 
    }
    public static String updatePwd(String id,String pass,String salt) throws ClassNotFoundException,SQLException
    {
        String token=id;
     String email="";
     String password=pass;
     String name="";
      String sqlResult="";
      String Salt=salt;
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select email from forgotPwd where token=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,token);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
      
          
          email=rs.getString("Email");
          
          
          
          String Query1="update user set password=?,salt=? where email=?";
          PreparedStatement ps1=con.prepareCall(Query1);
          ps1.setString(1,password);
          ps1.setString(2,Salt);
          ps1.setString(3,email);
          
          int j=ps1.executeUpdate();
          
      }
    return email; 
    }
    
     public static String resetPassword(String id) throws ClassNotFoundException,SQLException
    {
        String token=id;
     String email="";
     String password="";
     String name="";
      String sqlResult="";
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select Email,expirationDate from forgotPwd where token=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,token);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
      
          email=rs.getString("Email");
         
          
          
          
          
      }
    return email; 
    }
    
    public static int forgotPwd(String id,String uemail) throws ClassNotFoundException,SQLException
    {
        String token=id;
     String email=uemail;
     
     java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

     String name="";
      String sqlResult="";
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="insert into forgotPwd values(?,?,?)";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,email);
        ps.setString(2,token);
        ps.setTimestamp(3,date);
      
      i=ps.executeUpdate();
      
    return i; 
    }
      
      
        
   
    
    
    public static String retrieveName(String emailId) throws ClassNotFoundException,SQLException
    {
        String email=emailId;
        String name="";
      
      String sqlResult="";
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select * from User where Email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,email);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
      name=rs.getString("UName");
      
       
    
    }
      return name;
}
    public static int updateParticipations(String email) throws ClassNotFoundException,SQLException
    {
        String useremail=email;
      
     
     
          int participation=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="update User set participation=participation+1 where email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      int i=ps.executeUpdate();
      
       String Query2="select * from User where email=?";
      PreparedStatement ps1=con.prepareStatement(Query2);
      ps1.setString(1,useremail);
      ResultSet rs=ps1.executeQuery();
      while(rs.next())
      {
         participation=rs.getInt("participation");
      }
     
     
      return participation;
}
    
     public static int updateCoins(String email) throws ClassNotFoundException,SQLException
    {
        String useremail=email;
      
     
     
          int coins=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="update User set coins=coins+1 where email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      int i=ps.executeUpdate();
      
       String Query2="select * from User where email=?";
      PreparedStatement ps1=con.prepareStatement(Query2);
      ps1.setString(1,useremail);
      ResultSet rs=ps1.executeQuery();
      while(rs.next())
      {
         coins=rs.getInt("coins");
      }
     
     
      return coins;
}
     
    public static int updateParticipants(String email,String SCode) throws ClassNotFoundException,SQLException
    {
        
      String useremail=email;
     
     String code=SCode;
          int participants=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="update User set Participants=Participants+1 where email=(select email from study where SCode=?)";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,code);
      int i=ps.executeUpdate();
      
       String Query2="select * from User where email=?";
      PreparedStatement ps1=con.prepareStatement(Query2);
      ps1.setString(1,useremail);
      ResultSet rs=ps1.executeQuery();
      while(rs.next())
      {
         participants=rs.getInt("participants");
      }
     
     
      return participants;
}
    public static int getAttribute(String email) throws ClassNotFoundException,SQLException
    {
        
      
     String useremail=email;
     
          int participants=0;
          int coins=0;
          int participation=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select * from User where email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      
      
      ResultSet rs=ps.executeQuery();
      User user=new User();
      while(rs.next())
      {
          
         participants=rs.getInt("participants");
         
      }
     
     
      return participants;
}
    
      public static int coins(String email) throws ClassNotFoundException,SQLException
    {
        
      
     String useremail=email;
     
          int participants=0;
          int coins=0;
          int participation=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select * from User where email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      
      
      ResultSet rs=ps.executeQuery();
      User user=new User();
      while(rs.next())
      {
          
         coins=rs.getInt("coins");
         
      }
     
     
      return coins;
}
      
      public static int participation(String email) throws ClassNotFoundException,SQLException
    {
        
      
     String useremail=email;
     
          int participants=0;
          int coins=0;
          int participation=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select * from User where email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      
      
      ResultSet rs=ps.executeQuery();
      User user=new User();
      while(rs.next())
      {
          
         participation=rs.getInt("participation");
         
      }
     
     
      return participation;
}
       public static int updateCoinsForRecommedn(String email) throws ClassNotFoundException,SQLException
    {
        
      
     String useremail=email;
     
          int coins=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="update User set coins=coins+2 where email=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      int i=ps.executeUpdate();
      
       String Query2="select * from User where email=?";
      PreparedStatement ps1=con.prepareStatement(Query2);
      ps1.setString(1,useremail);
      ResultSet rs=ps1.executeQuery();
      while(rs.next())
      {
         coins=rs.getInt("coins");
      }
     
     
      return coins;
}
       public static int recommendationToken(String email,String token) throws ClassNotFoundException,SQLException
    {
        
      
     String useremail=email;
     String token1=token;
     
     java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
     
          int coins=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="insert into recommend values(?,?,?)";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      ps.setString(2,token1);
      ps.setTimestamp(3,date);
      int i=ps.executeUpdate();
      
       return i;
}
       public static String validateUsertoken(String token) throws ClassNotFoundException,SQLException
    {
        
      
     String email="";
     String token1=token;
     
     java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
     
          int coins=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
        String Query="select Email from recommend where token=?";
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,token1);
      
      ResultSet rs=ps.executeQuery();
      
       while(rs.next())
       {
          email=rs.getString("Email");
       }
return email;
    }
}

