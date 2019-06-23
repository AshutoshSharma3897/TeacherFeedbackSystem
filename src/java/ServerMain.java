
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


public class ServerMain extends HttpServlet {


    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String db_url="jdbc:mysql://Localhost:3306/teacher";
		String db_uname="root";
		String db_upass="";
		Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
		Statement st=con.createStatement();
		String q="select * from time";
                ResultSet rs=st.executeQuery(q);
                    
			out.println("<html>");
			out.println("<head>");
			
			out.println("<link rel='stylesheet'  href='stylepage.css'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div id='menu'>");
                        out.println("<ul>");
                       
                        out.println("<li><a href='login.html' class='link'>Login</a></li>");
                        out.println("<li><a href='registerpage.html' class='link'>Registration</a></li>");
                     
                        out.println("</ul>");
                        out.println("</div>");
                        
			out.println("<div>");
			
			out.println("<table cellpadding=20px id='form1'>");

			out.println("<tr>");
			out.println("<td >Subject</td>");
			out.println("<td >Class-Start</td>");
			out.println("<td >Class-Ends</td>");
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
          out.close();
        }
    }
