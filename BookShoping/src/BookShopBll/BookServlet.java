package BookShopBll;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import BookShopDal.BookDal;
import BookShopService.BookService;
import Models.BookModel;
import Models.PageModel;

/**
 * Servlet implementation class BookServlet
 */
@Controller
@RequestMapping("book")
public class BookServlet {
	@Autowired
	private BookService service;

	@RequestMapping("list.do")
	public String list() {
		return "BookList";
	}

	@RequestMapping("/getBookList.do")
	public void getList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession se = request.getSession();
		response.setContentType("utf-8");
		String pageIndex = request.getParameter("page");
		String pageSize = request.getParameter("rows");

		PageModel pageModel = new PageModel();
		pageModel.setLimit(Integer.parseInt(pageSize));
		pageModel.setPageIndex((Integer.parseInt(pageIndex) - 1) * pageModel.getLimit());
		List<BookModel> list = service.getList(pageModel);
		StringBuilder sb = new StringBuilder();
		sb.append("{\"total\":" + 11 + ",\"rows\":[");
		for (BookModel m : list) {
			sb.append("{\"name\":\"" + m.getName() + "\",\"id\":" + m.getId() + ",\"typeName\":\"" + m.getTypeName()
					+ "\",\"author\":\"" + m.getAuthor() + "\",\"pubDate\":\"" + m.getPubDate() + "\"},");
		}
		String str = sb.toString().substring(0, sb.toString().length() - 1) + "]}";

		PrintWriter writer = response.getWriter();
		writer.println(str);
		writer.flush();
		writer.close();
	}

	@RequestMapping("save_user.do")
	public void save_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BookModel m = new BookModel();
		String bookName = request.getParameter("name");
		String typeName = request.getParameter("typeName");
		String typeId = request.getParameter("typeId");
		String author = request.getParameter("author");
		m.setAuthor(author);
		m.setName(bookName);
		m.setTypeName(typeName);
		m.setTypeId(Integer.parseInt(typeId));
		boolean b = service.add(m);
		PrintWriter ps = response.getWriter();
		// title:'Success',msg:result.successMsg}

		String str = "{\"title\":\"Error\",\"errorMsg\":\"添加失败\"}";
		if (b) {
			str = "{\"title\":\"Success\",\"successMsg\":\"添加成功\"}";
		}
		ps.write(str);
		ps.flush();
		ps.close();
	}
}
