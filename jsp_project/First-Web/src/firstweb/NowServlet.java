package firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/now2")
public class NowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get으로 요청");
		
		resp.setContentType("text/html; charser = utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("	<head><title>Now Servlet</title></head>");
		out.println("	<body>");
		out.println("		<h1>" + new Date() + "</h1>");
		out.println("	</body>");
		out.println("</html>");
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post로 요청");
	}

}
