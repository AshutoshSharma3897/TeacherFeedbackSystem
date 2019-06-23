

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowFeedback extends HttpServlet {

   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
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
		String q="select * from feed";
                ResultSet rs=st.executeQuery(q);
		out.println("<html>");
			out.println("<head>");
			
			out.println("<link rel='stylesheet'  href='stylepage.css'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div id='menu'>");
                        out.println("<ul>");
                       
                      
                     
                        out.println("</ul>");
                        out.println("</div>");
                        
			out.println("<div>");
			
			out.println("<table cellpadding=20px id='form1'>");

			out.println("<tr>");
			out.println("<td >Experience</td>");
			out.println("<td >subject</td>");
			out.println("<td >comments</td>");
			out.println("</tr>");				
			

                    while(rs.next())
                    {
			out.println("<tr>");
                       
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
						
                         out.println("</tr>");
                    }  
                    
					
                    out.println("</div>");
			
                    out.println("</body>");
                    out.println("</html>");
                    con.close();
                    
            }       
            catch(Exception e)
                    {
                    out.println(e);
                    }
          
		
    }
            
        }
    

