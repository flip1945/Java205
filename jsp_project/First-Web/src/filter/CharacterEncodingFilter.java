package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(
		urlPatterns = {
				"/*", 
				"/request/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class CharacterEncodingFilter implements Filter {

	private String encoding;
    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		httpRequest.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String paramValue = fConfig.getInitParameter("encoding");
		if (paramValue != null) {
			this.encoding = "utf-8";
		} else {
			this.encoding = paramValue;
		}
	}

}
