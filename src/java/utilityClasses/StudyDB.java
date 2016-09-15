/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilityClasses;

/**
 *
 * @author Arun
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelClasses.Study;
import modelClasses.User;

public class StudyDB {
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	public static Study getStudy(String studyCode)throws ClassNotFoundException,SQLException{
		 Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       
        String code=studyCode;
        String Query="select * from Study where SCode=?";
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,code);
      ResultSet rs=ps.executeQuery();
       Study study = new Study();
      
      while(rs.next())
      {
         	    

         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
           
      
         
    
    }
      
      return study;   
	}
	
	public List<Study> getStudies(String email)throws ClassNotFoundException,SQLException
        {
		     List<Study> studies = new ArrayList<Study>();
        String userEmail=email;
         System.out.println("user email in Study controller"+userEmail);
      
      String sqlResult="";
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
      
     
        String Query="select * from Study where Email=?";
        
        
       PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,userEmail);
      ResultSet rs=ps.executeQuery();
      
      while(rs.next())
      {
         	    Study study = new Study();

         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
            studies.add(study);
      
         
    
    }
      return studies;
      
	}
	
	public List<Study> getStudies(){
		List<Study> studies = new ArrayList<Study>();
	    Study study = new Study();
	    study.setCode(1000);
	    study.setName("GUI");
	    study.setDateCreated("2015-10-12 13:16:05");
	    study.setEmail("vratakon@uncc.edu");
	    study.setQuestion("Is adobe GUI tool is good?");
	    study.setImageURL("images/computer.jpg");
	    study.setRequestedParticipants(10);
	    study.setNumOfParitipants(2);
	    study.setDescription("Discussion regarding the best GUI tools");
	    study.setStatus("start");
	    studies.add(study);
	    
	    study = new Study();
	    study.setCode(1001);
	    study.setName("NBAD");
	    study.setDateCreated("2015-08-01 10:02:01");
	    study.setEmail("hponnuru@uncc.edu");
	    study.setQuestion("How is Nbad course?");
	    study.setImageURL("images/outdoor.jpg");
	    study.setRequestedParticipants(8);
	    study.setNumOfParitipants(1);
	    study.setDescription("Discussion regarding NBAD course");
	    study.setStatus("start");
	    studies.add(study);
	    
	    study = new Study();
	    study.setCode(1002);
	    study.setName("MAD");
	    study.setDateCreated("2015-08-10 12:02:01");
	    study.setEmail("ubolt@sprinter.com");
	    study.setQuestion("How is the course structure?");
	    study.setImageURL("images/computer.jpg");
	    study.setRequestedParticipants(8);
	    study.setNumOfParitipants(1);
	    study.setDescription("Discussion regarding MAD course");
	    study.setStatus("start");
	    studies.add(study);
	    return studies;
		
	}

        public static List<Study> retrieveStudies1(String email) throws ClassNotFoundException,SQLException
    {
        List<Study> studies = new ArrayList<Study>();
        String useremail=email;
         
      
      String sqlResult="";
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       /**
        String Query1="select ";
       Statement stmt1=con.createStatement();
       ResultSet rs1=stmt1.executeQuery(Query1);**/
     
        String Query="select * from Study where email!=? and SStatus='started' and Scode NOT IN(select Scode from Answer where email=?)";
        
        PreparedStatement ps=con.prepareStatement(Query);
        ps.setString(1,useremail);
        ps.setString(2,useremail);
         
        
      
      ResultSet rs=ps.executeQuery();
      
      while(rs.next())
      {
         	    Study study = new Study();

         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
            studies.add(study);
      
         
    
    }
      return studies;
      
}
        
        public static List<Study> addStudy(Study study,String email) throws ClassNotFoundException,SQLException
    {
        List<Study> studies = new ArrayList<Study>();
        String userEmail=email;
         
      
      String sqlResult="";
      
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       System.out.println("Study object in DB"+study.getName());
        String Query="insert into Study values(?,?,?,?,?,?,?,?,?,?)";
       PreparedStatement ps=con.prepareStatement(Query);
      
       ps.setString(1,study.getName());
       ps.setInt(2,study.getCode());
       ps.setString(3,study.getDescription());
       ps.setString(4,userEmail);
       ps.setString(5,"2015-11-12 00:00:00");
       ps.setString(6,study.getQuestion());
       ps.setString(7,study.getImageURL());
       ps.setInt(8,study.getRequestedParticipants());
       ps.setInt(9,0);
       ps.setString(10,"started");
         
      int i=ps.executeUpdate();
    
       String Query1="select * from Study where email=?";
        
        
        PreparedStatement ps1=con.prepareStatement(Query1);
      ps1.setString(1,userEmail);
      ResultSet rs=ps1.executeQuery();
      
      while(rs.next())
      {
         	   

         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
            studies.add(study);
      
         
    
    }
      
      return studies;   
    
      
}
        
        public static List<Study> startStudy(String studyCode,String email) throws ClassNotFoundException,SQLException
    {
        List<Study> studies = new ArrayList<Study>();
        String code=studyCode;
        String useremail=email;
         
      
      
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       String Query="update Study set SStatus='started' where SCode=?";
        
        
        PreparedStatement ps=con.prepareStatement(Query);
        ps.setString(1, code);
      
      i=ps.executeUpdate();
      
    String Query1="select * from Study where email=?";
        
        
        PreparedStatement ps1=con.prepareStatement(Query1);
      ps1.setString(1,useremail);
      ResultSet rs=ps1.executeQuery();
      
      while(rs.next())
      {
         	    Study study = new Study();

         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
            studies.add(study);
      
         
    
    }
      
      return studies;   
    
    }
        
         public static List<Study> stopStudy(String studyCode,String email) throws ClassNotFoundException,SQLException
    {
        List<Study> studies = new ArrayList<Study>();
        String code=studyCode;
        String useremail=email;
      
      
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       String Query="update Study set SStatus='stopped' where SCode=?";
        
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,code);
      i=ps.executeUpdate();
       String Query1="select * from Study where email=?";
        
        
         PreparedStatement ps1=con.prepareStatement(Query1);
      ps1.setString(1,useremail);
      ResultSet rs=ps1.executeQuery();
      
      while(rs.next())
      {
         	    Study study = new Study();

         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
            studies.add(study);
      
         
    
    }
      
      return studies;   
     
    
    }
         
          public static List<Study> updateStudy(Study study,String email) throws ClassNotFoundException,SQLException
    {
        List<Study> studies = new ArrayList<Study>();
        String useremail=email;
              
      
      
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       String Query="update Study set Sname=?,Description=?,Question=?,ReqParticipants=?,ImageURL=? where SCode=?";
        
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,study.getName());
      ps.setString(2,study.getDescription());
      ps.setString(3,study.getQuestion());
      ps.setInt(4,study.getRequestedParticipants());
      ps.setString(5,study.getImageURL());
      ps.setInt(6,study.getCode());
      i=ps.executeUpdate();
       String Query1="select * from Study where email=?";
        
        
        PreparedStatement ps1=con.prepareStatement(Query1);
      ps1.setString(1,useremail);
      ResultSet rs=ps1.executeQuery();
      
      while(rs.next())
      {
         	    

         Study study1=new Study();
        study1.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study1.setName(rs.getString("SName"));
	    study1.setDateCreated(rs.getString("DateCreated"));
	    study1.setEmail(rs.getString("Email"));
	    study1.setQuestion(rs.getString("Question"));
	    study1.setImageURL(rs.getString("ImageURL"));
	    study1.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study1.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study1.setDescription(rs.getString("Description"));
	    study1.setStatus(rs.getString("SStatus"));
            studies.add(study1);
      
         
    
    }
      
      return studies;   
     
    
    }
          
           public static List<Study> answer(String email,String choice,String SCode) throws ClassNotFoundException,SQLException
    {
        List<Study> studies = new ArrayList<Study>();
              
      String anschoice=choice;
      String code=SCode;
      String useremail=email;
      System.out.println("email object in answer DB"+useremail);
      
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       String Query="insert into Answer values(?,?,?,?)";
        
        
        PreparedStatement ps=con.prepareStatement(Query);
      ps.setString(1,useremail);
      ps.setString(2,choice);
      ps.setString(3,code);
      ps.setString(4,"2015-11-12 00:00:00");
      
      i=ps.executeUpdate();
      
      String Query2="update study set ActParticipants=ActParticipants+1 where SCode=?";
      PreparedStatement ps1=con.prepareStatement(Query2);
      ps1.setString(1,code);
      int x=ps1.executeUpdate();
       String Query1="select * from Study where email!=? and SStatus='started' and Scode NOT IN(select Scode from Answer where email=?)";
        
        PreparedStatement ps2=con.prepareStatement(Query1);
        ps2.setString(1,useremail);
        ps2.setString(2,useremail);
         
      
      ResultSet rs=ps2.executeQuery();
      
      while(rs.next())
      {
         	    
                Study study=new Study();
         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
            studies.add(study);
      
         
    
    }
      
      return studies;   
     
    
    }
           
          public static List<Study> retrieveStudies(String email) throws ClassNotFoundException,SQLException
    {
        List<Study> studies = new ArrayList<Study>();
        String useremail=email;
        
         
      
      String sqlResult="";
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       String Query1="select count(*)as count from Study";
       Statement stmt1=con.createStatement();
       ResultSet rs1=stmt1.executeQuery(Query1);
     
        String Query="select * from Study where email=?";
        
        
         PreparedStatement ps=con.prepareStatement(Query);
         ps.setString(1,useremail);
      
      ResultSet rs=ps.executeQuery();
      
      while(rs.next())
      {
         	    Study study = new Study();

         
        study.setCode(rs.getInt("SCode"));
        System.out.println("Study code"+study.getCode());
	    study.setName(rs.getString("SName"));
	    study.setDateCreated(rs.getString("DateCreated"));
	    study.setEmail(rs.getString("Email"));
	    study.setQuestion(rs.getString("Question"));
	    study.setImageURL(rs.getString("ImageURL"));
	    study.setRequestedParticipants(rs.getInt("ReqParticipants"));
	    study.setNumOfParitipants(rs.getInt("Actparticipants"));
	    study.setDescription(rs.getString("Description"));
	    study.setStatus(rs.getString("SStatus"));
            studies.add(study);
      
         
    
    }
      return studies;
      
}
          public static int uploadImage(String image) throws ClassNotFoundException,SQLException
    {
       
        String imageURL=image;
         
      
      String sqlResult="";
      int i=0;
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       
     
        String Query="insert into image1 values(9,?)";
        
        
         PreparedStatement ps=con.prepareStatement(Query);
         ps.setString(1,imageURL);
      
      int l=ps.executeUpdate();
      
      return l;
      
      
}
          public static String retrieveImage() throws ClassNotFoundException,SQLException
    {
       
        
         
      
     String imageurl="";
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad2","root","Ar_un@200491");
       
     
        String Query="select * from image1 where id=3";
        
        
         Statement stmt=con.createStatement();
        
      
      ResultSet rs=stmt.executeQuery(Query);
      while(rs.next())
      {
      imageurl=rs.getString("itemName");
      }
      return imageurl;
      
}
      
      
}
    