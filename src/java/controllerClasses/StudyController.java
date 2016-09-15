/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerClasses;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;

import utilityClasses.StudyDB;
import modelClasses.Study;
import modelClasses.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import utilityClasses.UserDB;

/**
 *
 * @author Arun
 */
/**
 * Servlet implementation class StudyController
 */
@WebServlet(name="StudyController", loadOnStartup=1, urlPatterns={ "/myStudies", "/participate", "/answer", "/start", "/stop", "/add", "/edit", "/update" })
@MultipartConfig
public class StudyController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019790817492745738L;
	
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In StudyController");
		HttpSession session = null;
		//String action = request.getParameter("action");
		String userPath = request.getServletPath().substring(1, request.getServletPath().length());
		RequestDispatcher dispatcher = null;
		String reDirect = null;
		String studyCode = null;
		String choice = null;
		StudyDB studyDB = null;
		List<Study> studies = null;
		User user = null;
                
		try{
		     HttpSession session2=request.getSession();	
                     String email=(String)session2.getAttribute("email");
                    session = request.getSession(false);
			if(session != null && session.getAttribute("theUser") != null ){
				user = (User) session.getAttribute("theUser");
				studyDB = new StudyDB();
				if(userPath.equals("participate")){
					studyCode = request.getParameter("studyCode");
                                        String email1=(String)session2.getAttribute("email");
                                        
                                        System.out.println("user email in study controller from session"+email1);
					if(studyCode != null && !studyCode.isEmpty()){
						System.out.println("studyCode in first block:  " + studyCode);
						Study study = studyDB.getStudy(studyCode);
						request.setAttribute("study", study);
						reDirect = "question";
					}else{
						 
                                                        
                                                        
                                                        List result=StudyDB.retrieveStudies1(email);
                                                Study study=new Study();
                                                
                                                String s=study.getName();
                                                System.out.println("Controller study object"+s);
                                                
						
						request.setAttribute("study",study);
                                                request.setAttribute("result",result);
						reDirect = "participate";
					}
				}else if(userPath.equals("answer")){
					studyCode = request.getParameter("studyCode");
					choice = request.getParameter("choice");
					System.out.println("studyCode: "+studyCode);
					System.out.println("choice: "+choice);
                                          
					
                                        List result=StudyDB.answer(email,choice,studyCode);
                                        
					int i=UserDB.updateParticipations(email);
                                        user.setParticipation(i);
                                        int j=UserDB.updateCoins(email);
                                        user.setCoins(j);
                                        int k=UserDB.updateParticipants(email,studyCode);
                                        user.setParticipants(k);
                                         int participants=UserDB.getAttribute(email);
           int coins=UserDB.coins(email);
          int participation=UserDB.participation(email);
          
           user.setParticipants(participants);
           user.setCoins(coins);
           user.setParticipation(participation);
          
           request.setAttribute("user",user);
                                        
					/**
					List result = studyDB.getStudies();
					List<Study> sInStart = new ArrayList<Study>();
					for(Study study: studies){
						if(study.getStatus().equalsIgnoreCase("start")){
							sInStart.add(study);
						}
					}
					System.out.println(sInStart.size());**/
					session.setAttribute("theUser", user);
					request.setAttribute("openStudies", result);
                                        request.setAttribute("result",result);
                                        
					reDirect = "participate";
				}else if(userPath.equals("myStudies")){
					List result= studyDB.retrieveStudies(email);
                                        Study study=new Study();
                                        request.setAttribute("study",study);
                                                request.setAttribute("result",result);
                                                session.setAttribute("result",result);
					session.setAttribute("myStudies", studies);
					reDirect = "studies";
				}else if(userPath.equals("edit")){
					studyCode = request.getParameter("studyCode");
                                        String email3=(String)session2.getAttribute("email");
                                        
                                                    
                                        Study study=new Study();
                                               study=StudyDB.getStudy(studyCode);
                                               /**
					if(session.getAttribute("myStudies")!=null){
						studies = (List<Study>) session.getAttribute("myStudies");
					}else{
						studies = studyDB.getStudies(user.getEmail());
					}
					for(Study study: studies){
						if(study.getCode() == Integer.parseInt(studyCode)){
							request.setAttribute("study", studyDB.getStudy(Integer.parseInt(studyCode)));
							break;
						}
					}**/
					request.setAttribute("study",study);
					reDirect = "editstudy";
					/*Pending*/
				}else if(userPath.equals("update")){
					studyCode = request.getParameter("studyCode");
                                        Study study=new Study();
                                        study.setCode(Integer.parseInt(request.getParameter("studyCode")));
							study.setName(request.getParameter("studyName"));
							study.setQuestion(request.getParameter("questionText"));
							study.setRequestedParticipants(Integer.parseInt(request.getParameter("participants")));
							study.setDescription(request.getParameter("description"));
                                                        Part part = request.getPart("imageFile");
                                                       String fileName= part.getSubmittedFileName();
                                                       String file1="images/"+fileName;
                                                       study.setImageURL(file1);
		
                                                       
                System.out.println("IMAGE NAME"+file1);
                System.out.println("IMAGE NAME FROM STUDY OBJECT"+study.getImageURL());
                                                        



                                        List result=StudyDB.updateStudy(study,email);
                                        /**
					if(session.getAttribute("myStudies")!=null){
						studies = (List<Study>) session.getAttribute("myStudies");
					}else{
						studies = studyDB.getStudies(user.getEmail());
					}
					for(Study study: studies){
						if(study.getCode() == Integer.parseInt(studyCode)){
							studies.remove(study);
							study.setCode(Integer.parseInt(request.getParameter("studyCode")));
							study.setName(request.getParameter("studyName"));
							study.setQuestion(request.getParameter("questionText"));
							study.setRequestedParticipants(Integer.parseInt(request.getParameter("participants")));
							study.setDescription(request.getParameter("description"));
							
							studies.add(study);
							break;
						}
					}**/
                                        request.setAttribute("result",result);
                                        request.setAttribute("study",study);
					session.setAttribute("myStudies", studies);
					reDirect = "studies";
				}else if(userPath.equals("add")){
                                    
					Study study = new Study();
					study.setCode((int)Math.random());
					study.setName(request.getParameter("studyName"));
					study.setQuestion(request.getParameter("questionText"));
					study.setRequestedParticipants(Integer.parseInt(request.getParameter("participants")));
                                        
					study.setDescription(request.getParameter("description"));
                                           Part part = request.getPart("imageFile");
                                                       String fileName= part.getSubmittedFileName();
                                                       String file1="images/"+fileName;
                                                       study.setImageURL(file1);
					/**
					studies = (List<Study>) session.getAttribute("myStudies");
					studies.add(study);**/
                                        List result1=StudyDB.addStudy(study,email);
                                         
                                              List result=StudyDB.retrieveStudies(email);
                                                Study study1=new Study();
                                                request.setAttribute("result",result);
                                                
					session.setAttribute("myStudies", studies);
					reDirect = "studies";
				}else if(userPath.equals("start")){
					studyCode = request.getParameter("studyCode");
                                        
                                        List result=StudyDB.startStudy(studyCode,email);
                                        Study study=new Study();
                                        session.setAttribute("result",result);
                                        study.setStatus("started");
                                        session.setAttribute("choice","started");
                                        /**
					if(session.getAttribute("myStudies")!=null){
						studies = (List<Study>) session.getAttribute("myStudies");
					}
					for(Study study: studies){
						if(study.getCode() == Integer.parseInt(studyCode)){
							studies.remove(study);
							study.setStatus("start");
							studies.add(study);
							System.out.println("studyCode:  " + studyCode);
							System.out.println("New Status:  " + study.getStatus());
							break;
						}
					}**/
					session.setAttribute("myStudies", studies);
					reDirect = "studies";
				}else if(userPath.equals("stop")){
					studyCode = request.getParameter("studyCode");
                                        
                                        System.out.println("study code from DB"+studyCode);
                                        List result=StudyDB.stopStudy(studyCode,email);
                                        Study study=new Study();
                                        study.setStatus("stopped");
                                        session.setAttribute("result",result);
                                        
					System.out.println("studyCode:  " + studyCode);
                                        /**
					if(session.getAttribute("myStudies")!=null){
						studies = (List<Study>) session.getAttribute("myStudies");
					}
					for(Study study1: studies){
						if(study1.getCode() == Integer.parseInt(studyCode)){
							studies.remove(study);
							study1.setStatus(null);
							studies.add(study);
							System.out.println("studyCode:  " + studyCode);
							System.out.println("New Status:  " + study.getStatus());
							break;
						}
					}**/
					session.setAttribute("myStudies", studies);
					reDirect = "studies";
				}
				dispatcher = getServletContext().getRequestDispatcher(
						"/" + reDirect + ".jsp");
				dispatcher.forward(request, response);
			}else{
				dispatcher = getServletContext().getRequestDispatcher(
						"/" + "login" + ".jsp");
				dispatcher.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			dispatcher = getServletContext().getRequestDispatcher("/main.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
