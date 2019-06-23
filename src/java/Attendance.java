import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Attendance extends HttpServlet {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
                String b1=request.getParameter("b");
                if(b1!=null)
                {
                 out.println("alert('DATA UPDATED')");
                }
		String s11=request.getParameter("ch11");
		String s12=request.getParameter("ch12");
                String s13=request.getParameter("ch13");
		String s14=request.getParameter("ch14");
                String s15=request.getParameter("ch15");
                
                String s21=request.getParameter("ch21");
		String s22=request.getParameter("ch22");
                String s23=request.getParameter("ch23");
		String s24=request.getParameter("ch24");
                String s25=request.getParameter("ch25");
                
                String s31=request.getParameter("ch31");
		String s32=request.getParameter("ch32");
                String s33=request.getParameter("ch33");
		String s34=request.getParameter("ch34");
                String s35=request.getParameter("ch35");
                
                String s41=request.getParameter("ch41");
		String s42=request.getParameter("ch42");
                String s43=request.getParameter("ch43");
		String s44=request.getParameter("ch44");
                String s45=request.getParameter("ch45");
                
                String s51=request.getParameter("ch51");
		String s52=request.getParameter("ch52");
                String s53=request.getParameter("ch53");
		String s54=request.getParameter("ch54");
                String s55=request.getParameter("ch55");
	
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		String db_url="jdbc:mysql://Localhost:3306/teacher";
		String db_uname="root";
		String db_upass="";
		Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
		Statement st=con.createStatement();
		String q1="update attendance set Eng='"+s11+"', hin='"+s12+"', mat='"+s13+"', phy='"+s14+"', che='"+s15+"' where sid='s01'";
                String q2="update attendance set Eng='"+s21+"', hin='"+s22+"' ,mat='"+s23+"' ,phy='"+s24+"' ,che='"+s25+"' where sid='s02'";
                String q3="update attendance set Eng='"+s31+"' ,hin='"+s32+"', mat='"+s33+"' ,phy='"+s34+"', che='"+s35+"' where sid='s03'";
                String q4="update attendance set Eng='"+s41+"' ,hin='"+s42+"', mat='"+s43+"', phy='"+s44+"' ,che='"+s45+"' where sid='s04'";
                String q5="update attendance set Eng='"+s51+"' ,hin='"+s52+"', mat='"+s53+"', phy='"+s54+"' ,che='"+s55+"' where sid='s05'";
		st.executeUpdate(q1);
                st.executeUpdate(q2);
                st.executeUpdate(q3);
                st.executeUpdate(q4);
                st.executeUpdate(q5);
                
		con.close();
		}
		catch(Exception e)
		{
		out.println(e);
		}
		out.close();   
            
        }
}