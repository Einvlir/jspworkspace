/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.66
 * Generated at: 2021-07-20 05:47:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

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
    _jspx_imports_classes = null;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- Add icon library -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("body {font-family: Arial, Helvetica, sans-serif;}\r\n");
      out.write("* {box-sizing: border-box;}\r\n");
      out.write(".input-container {\r\n");
      out.write("  display: -ms-flexbox; /* IE10 */\r\n");
      out.write("  display: flex;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  margin-bottom: 15px;\r\n");
      out.write("}\r\n");
      out.write(".icon {\r\n");
      out.write("  padding: 10px;\r\n");
      out.write("  background: dodgerblue;\r\n");
      out.write("  color: white;\r\n");
      out.write("  min-width: 50px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".input-field {\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  padding: 10px;\r\n");
      out.write("  outline: none;\r\n");
      out.write("}\r\n");
      out.write(".input-field:focus {\r\n");
      out.write("  border: 2px solid dodgerblue;\r\n");
      out.write("}\r\n");
      out.write("/* Set a style for the submit button */\r\n");
      out.write(".btn {\r\n");
      out.write("  background-color: dodgerblue;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 15px 20px;\r\n");
      out.write("  border: none;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  opacity: 0.9;\r\n");
      out.write("}\r\n");
      out.write(".btn:hover {\r\n");
      out.write("  opacity: 1;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("	$(\"button[type='button']\").click(function(){\r\n");
      out.write("		loginCheck();\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("function loginCheck(){\r\n");
      out.write("	//서버에 로그인 요청 \r\n");
      out.write("	$(\"form\").attr({\r\n");
      out.write("		\"action\":\"/admin/login\",\r\n");
      out.write("		\"method\":\"post\"\r\n");
      out.write("	});		\r\n");
      out.write("	$(\"form\").submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<form style=\"max-width:500px;margin:auto\">\r\n");
      out.write("  <h2>Register Form</h2>\r\n");
      out.write("  <div class=\"input-container\">\r\n");
      out.write("    <i class=\"fa fa-user icon\"></i>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" placeholder=\"ID\" name=\"host_id\">\r\n");
      out.write("  </div>\r\n");
      out.write("	<!-- \r\n");
      out.write("  <div class=\"input-container\">\r\n");
      out.write("    <i class=\"fa fa-envelope icon\"></i>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" placeholder=\"Email\" name=\"email\">\r\n");
      out.write("  </div>\r\n");
      out.write(" 	-->  \r\n");
      out.write("  <div class=\"input-container\">\r\n");
      out.write("    <i class=\"fa fa-key icon\"></i>\r\n");
      out.write("    <input class=\"input-field\" type=\"password\" placeholder=\"Password\" name=\"password\">\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <button type=\"button\" class=\"btn\">Login</button>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
