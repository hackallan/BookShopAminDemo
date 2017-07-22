package BookShopBll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import BookShopService.BookService;
import Models.BookModel;
import Models.PageModel;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/get_books")
public class BookServlet implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession se = request.getSession();
		response.setContentType("utf-8");
		String pageIndex = request.getParameter("page");
		String pageSize = request.getParameter("rows");

		PageModel pageModel = new PageModel();
		pageModel.setLimit(Integer.parseInt(pageSize));
		pageModel.setPageIndex((Integer.parseInt(pageIndex) - 1) * pageModel.getLimit());
		ApplicationContext ac = new ClassPathXmlApplicationContext("springContext.xml");
		BookService bs = ac.getBean("bookService", BookService.class);
		List<BookModel> list = bs.getList(pageModel);
		StringBuilder sb = new StringBuilder();
		sb.append("{\"total\":" + 11 + ",\"rows\":[");
		for (BookModel m : list) {
			sb.append("{\"name\":\"" + m.getName() + "\",\"id\":" + m.getId() + ",\"typeName\":\"" + m.getTypeName()
					+ "\",\"author\":\"" + m.getAuthor() + "\",\"pubDate\":\"" + m.getPubDate() + "\"},");
		}
		String str = sb.toString().substring(0, sb.toString().length() - 1) + "]}";

		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
		
		return null;
	}
	
	

}
