package imsjapan.caliper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

@WebServlet(
    name = "LoginServlet",
    urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String userName = request.getParameter("user_name");
    	DateTime loginTime = DateTime.now();

    	// ログインイベントの送信
    	if (CaliperSession.sendSessionLoggedIn(userName, loginTime)) {
    		// イベント送信成功
        	request.getSession().setAttribute("message", "SessionEvent(Logged In) was sent successfully.");
    	} else {
    		// イベント送信失敗
        	request.getSession().setAttribute("message", "Failed to send SessionEvent(Logged In).");
    	}

    	request.getSession().setAttribute("user_name", request.getParameter("user_name"));
    	request.getSession().setAttribute("login_time", loginTime);

    	response.sendRedirect("/logout.jsp");
    }

}
