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
 * Servlet implementation class AddBook
 */
@WebServlet("/save_user")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
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
		response.setCharacterEncoding("utf-8");
		BookModel m = new BookModel();
		String bookName = request.getParameter("name");
		String typeName = request.getParameter("typeName");
		String typeId = request.getParameter("typeId");
		String author=request.getParameter("author");
		m.setAuthor(author);
		m.setName(bookName);
		m.setTypeName(typeName);
		m.setTypeId(Integer.parseInt(typeId));
		Boolean b=BookDal.getInstance().add(m);
		PrintWriter ps=response.getWriter();
		//title:'Success',msg:result.successMsg}
		
		String str = "{\"title\":\"Error\",\"errorMsg\":\"添加失败\"}";
		if(b)
		{
			str = "{\"title\":\"Success\",\"successMsg\":\"添加成功\"}";
		}
		ps.write(str);
		ps.flush();
		ps.close();
	}
}
