package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet implementation class UserLoginServlet
 */
@Controller
@RequestMapping("login")
public class UserLoginServlet {

	@RequestMapping(name="loginuser.do",method=RequestMethod.POST)
	protected String loginuser(HttpServletRequest request) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("userName");

		HttpSession session = request.getSession();
		session.setAttribute("username", name);
		session.setMaxInactiveInterval(600);

		return "BookList";
	}

}
