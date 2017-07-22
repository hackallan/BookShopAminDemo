package BookShopBll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookShopDal.BookDal;
import Models.BookModel;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/update_book")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BookModel m = new BookModel();
		m.setAuthor(request.getParameter("author"));
		m.setId(Integer.parseInt(request.getParameter("id")));
		m.setName(request.getParameter("name"));
		m.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		m.setTypeName(request.getParameter("typeName"));
		PrintWriter ps = response.getWriter();
		Boolean b = BookDal.getInstance().update(m);
		String str = "{\"title\":\"Error\",\"errorMsg\":\"修改失败\"}";
		if (b) {
			str = "{\"title\":\"Success\",\"successMsg\":\"修改成功\"}";
		}
		ps.write(str);
		ps.flush();
		ps.close();
	}

}
