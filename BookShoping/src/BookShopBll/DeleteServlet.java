package BookShopBll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookShopDal.BookDal;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/destroy_user")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		Boolean b=BookDal.getInstance().delete(Integer.parseInt(id));
		String str = "{\"title\":\"Error\",\"errorMsg\":\"修改失败\"}";
		if (b) {
			str = "{\"title\":\"Success\",\"success\":\"修改成功\"}";
		}
		
		PrintWriter p = response.getWriter();
		p.write(str);
		p.flush();
		p.close();
	}

}
