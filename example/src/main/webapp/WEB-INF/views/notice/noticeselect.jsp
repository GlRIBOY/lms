<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<table border="1" style="border-radius: 20px">
				<thead>
					<tr>
						<th width="50" height="30" style="border-top-left-radius: 20px">번호</th>
						<td width="50" align="center">${n.noticeId }</td>
						<th width="50">제목</th>
						<td width="250" align="center">${n.noticeTitle }</td>
						<th width="80">작성자</th>
						<td width="120" align="center">${n.noticeWriter }</td>
						<th width="80">작성일</th>
						<td width="120" align="center"
							style="border-top-right-radius: 20px">${n.noticeDate }</td>
					</tr>
					<tr>
						<td colspan="8" height="500" width="800" valign="top"
							bgcolor="#EFF8FB">${n.noticeSubject }</td>
					</tr>
					<tr>
						<td align="center" colspan="3"
							style="border-bottom-left-radius: 20px; padding: 10px">첨부파일</td>
						<td colspan="5"
							style="border-bottom-right-radius: 20px; padding-left: 15px">${n.noticeAttech }</td>
					</tr>
				</thead>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${name eq n.noticeWriter }">
				<button type="button" onclick="noticeUpdate('E')">수정</button>&nbsp;&nbsp;&nbsp;

				<button type="button" onclick="noticeDelete('D')">삭제</button>&nbsp;&nbsp;&nbsp;

		</c:if>
			<button type="button" onclick="location.href=noticelist.do">목록</button>
		</div>
		<div>
			<form id="frm" method="post">
				<input type="hidden" id="noticeId" name="noticeId"
					value="${n.noticeId }">
			</form>
		</div>
	</div>
	<script type="text/javascript">
function noticeUpdate(str){
	if(str =='E'){
		document.getElementById("frm").action = "noticeeditform.do";
	}else if(str=='D'){
		document.getElementById("frm").action = "noticedelete.do";
	}document.getElementById("frm").submit();
}
</script>
</body>
</html>