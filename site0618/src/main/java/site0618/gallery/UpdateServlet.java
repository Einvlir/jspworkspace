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

import com.oreilly.servlet.MultipartRequest;

import site0618.model.domain.Gallery;
import site0618.model.gallery.dao.GalleryDAO;
import site0618.util.FileManager;

public class UpdateServlet extends HttpServlet{
	GalleryDAO galleryDAO;
	ServletContext context;
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		galleryDAO = new GalleryDAO();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("업로드 처리");
		request.setCharacterEncoding("utf-8");
		String path = context.getRealPath("/data");
		out.print(path);
		//String path = "E:\\korea202102_jspworkspace\\site0618\\src\\main\\webapp\\data";
//		MultipartRequest multi = new MultipartRequest(request, );
//		out.print("업로드 완료~<br>");
		
		int maxSize = 6*1024*1024;
		//두번째 생성자는 업로드 용량을 제한한다.
		try {
			//생성전 삭제
			MultipartRequest multi = new MultipartRequest(request, path, maxSize, "utf-8");
			
			String filename = multi.getParameter("filename");
			String gallery_id = multi.getParameter("gallery_id");
			out.print(gallery_id+"<br>");
			File oldfile = new File(path+"/"+filename);
			oldfile.delete();
			
			
			File file = multi.getFile("myfile");
			long time = System.currentTimeMillis();
			String destName = time+"."+FileManager.getExt(file.getName());
			
			File dest = new File(path+"/"+destName);
			file.renameTo(dest);
			out.print("업로드성공.<br>");
			
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String content = multi.getParameter("content");
			out.print(title+"<br>");
			out.print(writer+"<br>");
			out.print(content+"<br>");
			
			Gallery gallery = new Gallery();
			gallery.setTitle(title);
			gallery.setWriter(writer);
			gallery.setContent(content);
			gallery.setFilename(destName);
			
			int result = galleryDAO.update(gallery);
			if(result == 0) {
				out.print("에러 에러");
			}else {
				out.print("성공 성공");
				//list 요청
				response.sendRedirect("/gallery/list.jsp"); //클라이언트에게 지정한 주소로 재접속 명령
				
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			out.print("업로드실패, 용량이 너무 큽니다.<br>");
		}
	}
}
