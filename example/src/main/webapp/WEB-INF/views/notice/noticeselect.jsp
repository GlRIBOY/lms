<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="100">번호</th>
						<td width="100" align="center">${n.noticeId }</td>
						<th width="100"><h4>제목</h4></th>
						<td width="100" align="center">${n.noticeTitle }</td>
						<th width="100">작성자</th>
						<td width="100" align="center">${n.noticeWriter }</td>
						<th width="100">작성일</th>
						<td width="100" align="center">${n.noticeDate }</td>
					</tr>
					<tr>
					<td width="800">${n.noticeSubject }</td>
					</tr>
					
				</thead>
			</table>
		</div>
	</div>

</body>
</html>