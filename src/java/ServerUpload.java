import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class ServerUpload extends HttpServlet {

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
		String s11=request.getParameter("s1");
		String s12=request.getParameter("s2");
                String s13=request.getParameter("s3");
		String s14=request.getParameter("s4");
                String s15=request.getParameter("s5");
                
                String s21=request.getParameter("cs1");
		String s22=request.getParameter("cs2");
                String s23=request.getParameter("cs3");
		String s24=request.getParameter("cs4");
                String s25=request.getParameter("cs5");
                
                String s31=request.getParameter("ce1");
		String s32=request.getParameter("ce2");
                String s33=request.getParameter("ce3");
		String s34=request.getParameter("ce4");
                String s35=request.getParameter("ce5");
	
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		String db_url="jdbc:mysql://Localhost:3306/teacher";
		String db_uname="root";
		String db_upass="";
		Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
		Statement st=con.createStatement();
                
		String q1="update time set subst='"+s21+"',subct='"+s31+"' where sub='"+s11+"'";
                String q2="update time set subst='"+s22+"',subct='"+s32+"' where sub='"+s12+"'";
                String q3="update time set subst='"+s23+"',subct='"+s33+"' where sub='"+s13+"'";
                String q4="update time set subst='"+s24+"',subct='"+s34+"' where sub='"+s14+"'";
                String q5="update time set subst='"+s25+"',subct='"+s35+"' where sub='"+s15+"'";
		st.executeUpdate(q1);
                st.executeUpdate(q2);
                st.executeUpdate(q3);
                st.executeUpdate(q4);
                st.executeUpdate(q5);
                response.sendRedirect("upload.html");
		con.close();
		}
		catch(Exception e)
		{
		out.println(e);
		}
		out.close();   
            
        }
    }
