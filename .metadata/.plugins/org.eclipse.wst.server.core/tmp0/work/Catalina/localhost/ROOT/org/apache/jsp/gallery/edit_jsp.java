/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.66
 * Generated at: 2021-06-21 02:04:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.gallery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import site0618.model.domain.Gallery;
import site0618.model.gallery.dao.GalleryDAO;
import site0618.util.FileManager;
import java.io.File;
import com.oreilly.servlet.MultipartRequest;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

GalleryDAO galleryDAO = new GalleryDAO(); 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("site0618.model.domain.Gallery");
    _jspx_imports_classes.add("site0618.util.FileManager");
    _jspx_imports_classes.add("site0618.model.gallery.dao.GalleryDAO");
    _jspx_imports_classes.add("java.io.File");
    _jspx_imports_classes.add("com.oreilly.servlet.MultipartRequest");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("alert('수정완료');\r\n");
      out.write("location.href=\"/gallery/list.jsp\";\r\n");
      out.write("\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}