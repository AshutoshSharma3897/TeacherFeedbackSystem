

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerFeedback extends HttpServlet {

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("experience");
        String s2=request.getParameter("subject");
        
         String s3=request.getParameter("comments");
           
          try
           {
                Class.forName("com.mysql.jdbc.Driver");
		String db_url="jdbc:mysql://Localhost:3306/teacher";
		String db_uname="root";
		String db_upass="";
		Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
		Statement st=con.createStatement(); 
                String q="insert into feed values('"+s1+"','"+s2+"','"+s3+"')";
		st.executeUpdate(q);
                response.sendRedirect("login.html");
		
                
           }
          
           catch(Exception e)
           {
               out.println(e);
           }
         
        }
    }
