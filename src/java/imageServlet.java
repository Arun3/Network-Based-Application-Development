/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import static org.apache.taglibs.standard.tag.common.core.OutSupport.out;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import utilityClasses.StudyDB;

/**
 *
 * @author Arun
 */
@WebServlet(urlPatterns = {"/imageServlet"})
public class imageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet imageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet imageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name="";
        String value="";
        String imageurl="";
        String path="";
        try
{
String ImageFile="";
String itemName = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if (!isMultipart)
{
}
else
{
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List items = null;
try
{
items = upload.parseRequest(request);
}
catch (FileUploadException e)
{
System.out.println("Exception in upload");
    e.getMessage();
}
 
Iterator itr = items.iterator();
while (itr.hasNext())
{
FileItem item = (FileItem) itr.next();
if (item.isFormField())
{
name = item.getFieldName();
value = item.getString();
if(name.equals("ImageFile"))
{
ImageFile=value;
}
 
}
else
{
try
{
  
itemName = item.getName();
File savedFile = new File(this.getServletContext().getRealPath("/")+"images\\"+itemName);
File image=new File(request.getParameter("ImageFile"));
path="/images/";
name=itemName;
        item.write(savedFile);
}
catch (Exception e)
{
System.out.println("Error"+e.getMessage());
}
}
}
try
{
    int image=StudyDB.uploadImage("/images/"+itemName);
imageurl=StudyDB.retrieveImage();

                
}
catch(Exception el)
{
System.out.println("Inserting error"+el.getMessage());
}
}
}
catch (Exception e){
System.out.println(e.getMessage());
}
         String URL="/displayImage.jsp";
        String message="Success";
        request.setAttribute("message",message);
        request.setAttribute("imageurl",imageurl);
         getServletContext()
                         .getRequestDispatcher(URL)
                         .forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
