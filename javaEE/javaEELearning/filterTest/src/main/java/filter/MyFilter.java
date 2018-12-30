package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("filter constructor...");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("initial config");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    public void destroy() {
        System.out.println("destroy...");
    }

}
