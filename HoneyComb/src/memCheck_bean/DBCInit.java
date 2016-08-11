package memCheck_bean;

import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DBCInit extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		try {
			String drivers = config.getInitParameter("jdbcdriver");

			StringTokenizer st = new StringTokenizer(drivers, ",");
			while (st.hasMoreTokens()) {
				String jdbcDriver = st.nextToken();
				
				Class.forName(jdbcDriver);
				//JDBC ?��?��?���?? 로딩
			}

			Class.forName("org.apache.commons.dbcp.PoolingDriver");

		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

}
