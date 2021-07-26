<%@page import="site0618.model.domain.Gallery"%>
<%@page import="java.util.List"%>
<%@page import="site0618.model.gallery.dao.GalleryDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	GalleryDAO galleryDAO = new GalleryDAO();
%>
<%
	List<Gallery> gallerylist = galleryDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset ="UTF-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
  position:relative;
  left:-1700px;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
    var table = $("table");  
    table.animate({left: '0px'}, "slow");
});
</script>
</head>
<body>

<h2>게시판 목록</h2>

<table>
	<tr>
		<th>No</th>
		<th>이미지</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<%for(Gallery gallery : gallerylist){%>
	<tr>
		<td>jill</td>
		<td><img src = "/data/<%=gallery.getFilename()%>" width="50px"></td>
		<td>
			<a href = "/gallery/detail.jsp?gallery_id=<%=gallery.getGallery_id()%>"><%=gallery.getTitle() %>
		</td>
		<td><%=gallery.getWriter() %></td>
		<td><%=gallery.getRegdate()%></td>
		<td><%=gallery.getHit()%></td>
		
	</tr>
	<%} %>
	<tr>
		<td colspan ="5">
			<button onclick="location.href='/photo/regist.jsp'">등록</button>
		</td>
	</tr>
  
</table>

</body>
</html>
