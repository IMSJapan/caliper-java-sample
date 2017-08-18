package imsjapan.caliper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

@WebServlet(
    name = "LogoutServlet",
    urlPatterns = {"/logout"}
)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String userName = (String)request.getSession().getAttribute("user_name");
    	DateTime loginTime = (DateTime)request.getSession().getAttribute("login_time");

    	// ログアウトイベントの送信
    	if (CaliperSession.sendSessionLoggedOut(userName, loginTime)) {
    		// イベント送信成功
        	request.getSession().setAttribute("message", "SessionEvent(Logged Out) was sent successfully.");
    	} else {
    		// イベント送信失敗
        	request.getSession().setAttribute("message", "Failed to send SessionEvent(Logged Out).");
    	}

    	response.sendRedirect("/login.jsp");
    }

}
