package guest.jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JdbcDriverLoad extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String jdbcDriver = config.getInitParameter("jdbcDriver");
		
		try {
			jdbcDriver = jdbcDriver == null ? "com.mysql.cj.jdbc.Driver" : jdbcDriver;
			Class.forName(jdbcDriver);
			System.out.println("mysql Driver Load....!!!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
