<%@page import="site0618.model.domain.Gallery"%>
<%@page import="site0618.model.gallery.dao.GalleryDAO"%>
<%@page import="site0618.util.FileManager"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!GalleryDAO galleryDAO = new GalleryDAO(); %>

<%
	//jsp에서는 서블릿에서 사용되는 여러 객체들을 이름을 이미 부여해둔
	//내장객체로 지원한다. HttpServletRequest: request
	//HttpservletResponse : response
	//PrintWriter : out
	//ServletContext : application


	//멀티파트 객체는 생성자의 호출만으로 업로드가 발생한다.
	int maxSize = 2*1024*1024;
	String encoding="utf-8";
	String path = application.getRealPath("/data");
	MultipartRequest multi = new MultipartRequest(request, path, maxSize, encoding);
	//사용자가 새로운 파일의 업로드를 희망할 경우
	//String myfile = multi.getParameter("myfile");
	String myfile = multi.getOriginalFileName("myfile");//유저가 업로드한 파일명
	String filename = multi.getParameter("filename");
	
	String title = multi.getParameter("title");
	String writer = multi.getParameter("writer");
	String content = multi.getParameter("content");
	String gallery_id = multi.getParameter("gallery_id");
	
	if(myfile!=null){
		out.print("새로운 파일 업로드<br>");
		File oldFile = new File(path+"/"+filename);
		if(oldFile.delete()){
			File newFile = multi.getFile("myfile");
			long time = System.currentTimeMillis();
			String ext = FileManager.getExt(myfile);
			boolean result = newFile.renameTo(new File(path+"/"+time+"."+ext));
			if(result){
				Gallery gallery = new Gallery();
				gallery.setTitle(title);
				gallery.setWriter(writer);
				gallery.setContent(content);
				gallery.setFilename(time+"."+ext);
				gallery.setGallery_id(Integer.parseInt(gallery_id));
				galleryDAO.update(gallery);
			}
		}
	}else{
	//DB만 수정할 경우
		out.print("파일 유지<br>");		
		Gallery gallery = new Gallery();
		gallery.setTitle(title);
		gallery.setWriter(writer);
		gallery.setContent(content);
		gallery.setFilename(filename);
		gallery.setGallery_id(Integer.parseInt(gallery_id));
		galleryDAO.update(gallery);
		
	}		
	//jsp를 사용할 경우 html과 혼용이 가능하므로
	//스크립틀릿 바깥에 자바스크립트를 명시하는것이 더 편할 수 있다.
%>
<script>
alert('수정완료');
location.href="/gallery/list.jsp";

</script>