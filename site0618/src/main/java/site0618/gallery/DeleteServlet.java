package site0618.gallery;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site0618.model.gallery.dao.GalleryDAO;

public class DeleteServlet extends HttpServlet{
	ServletContext context;
	GalleryDAO galleryDAO;
	public void init(ServletConfig config) throws ServletException {
		context=config.getServletContext();//<<해당 서블릿의 모든 정보를 가지고 있음..
		galleryDAO = new GalleryDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gallery_id = request.getParameter("gallery_id");
		String filename = request.getParameter("filename");
		response.setContentType("text/html; charset=UTF-8");//jsp에서 page지시영역..
		PrintWriter out = response.getWriter();
		//삭송이
		
		int result = galleryDAO.del(Integer.parseInt(gallery_id));
		if(result != 0) {
			String path = context.getRealPath("/data");
			File file =new File(path+"/"+filename);
			if(file.delete()) {
				out.print("<script>");
				out.print("alert('삭제완료')");
				response.sendRedirect("/gallery/list.jsp");				
				out.print("</script>");
			}else {
				
				out.print("삭제중 에러가 발생했습니다.");				
			}
		}else {
			out.print("삭제중 에러가 발생했습니다.");
		}
		
	}
}
