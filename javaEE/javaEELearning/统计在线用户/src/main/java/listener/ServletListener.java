package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebListener()
public class ServletListener implements ServletContextListener,
        HttpSessionListener, ServletRequestListener {

    private Map<String, List<HttpSession>> ipMap;

    // Public constructor is required by servlet spec
    public ServletListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        this.ipMap = new HashMap<>();
    }

    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String ip = request.getRemoteAddr();

        if (!this.ipMap.containsKey(ip)) {
            this.ipMap.put(ip, new ArrayList<>());
        }

        HttpSession session = request.getSession();
        if (!this.ipMap.get(ip).contains(session)) {
            this.ipMap.get(ip).add(session);
            session.setAttribute("ip", ip);
        }

        System.out.println(this.ipMap);
        sre.getServletContext().setAttribute("ipCount", this.ipMap.size());
    }


//    public void sessionCreated(HttpSessionEvent se) {
//
//    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String ip = (String) session.getAttribute("ip");

        List<HttpSession> sessionList = this.ipMap.get(ip);
        sessionList.remove(session);

        if (sessionList.size() == 0) {
            this.ipMap.remove(ip);
        }

        session.getServletContext().setAttribute("ipCount", this.ipMap.size());
    }

}
