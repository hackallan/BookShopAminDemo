package Login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookShopDal.BookTypeDal;
import Models.BookTypeModel;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/loginuser")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", name);
		session.setMaxInactiveInterval(600);
		//ServletContext context = request.getServletContext();
		//List<BookTypeModel> list = BookTypeDal.getInstance().getList();
		//context.setAttribute("typelist", list);		
		request.getRequestDispatcher("BookList1.html").forward(request, response);
	}

}
