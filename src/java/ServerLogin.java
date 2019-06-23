
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


public class ServerLogin extends HttpServlet {

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           String s1=request.getParameter("u1");
           String s2=request.getParameter("email");
           String s3=request.getParameter("pass");
           String stu="Student";
           String tchr="Teacher";
      if(s1.equals(stu))
       {
           try
           {
                Class.forName("com.mysql.jdbc.Driver");
		String db_url="jdbc:mysql://Localhost:3306/teacher";
		String db_uname="root";
		String db_upass="";
		Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
		Statement st=con.createStatement(); 
                String q="select * from studentRegister where id='"+s2+"' and pass='"+s3+"'";
		ResultSet rs=st.executeQuery(q);
		if(rs.next())
		{
                    Cookie ck=new Cookie("id",s1);
                    ck.setMaxAge(60*30);
                    response.addCookie(ck);
                    
                    response.sendRedirect("feedback.html");
		}
		else
		{
			out.println("invalid id /password");
		}
                
           }
           catch(Exception e)
           {
               out.println(e);
           }
           
        }
        if(s1.equals(tchr))
        {
           try
           {
                Class.forName("com.mysql.jdbc.Driver");
		String db_url="jdbc:mysql://Localhost:3306/teacher";
		String db_uname="root";
		String db_upass="";
		Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
		Statement st=con.createStatement(); 
                String q="select * from teacher where tid='"+s2+"' and password='"+s3+"'";
		ResultSet rs=st.executeQuery(q);
		if(rs.next())
		{
                    Cookie ck=new Cookie("tid",s1);
                    ck.setMaxAge(60*30);
                    response.addCookie(ck);
                    
                     if(s2.equals("anubha")&&s3.equals("123"))
                     {
			response.sendRedirect("upload.html");
                     }
                     else
                     {
                        response.sendRedirect("ShowTimetable"); 
                     }
		}
		else
		{
			out.println("invalid id /password");
		}
                
           }
           catch(Exception e)
           {
               out.println(e);
           }
        }
            out.close();   
          
          
    }

}