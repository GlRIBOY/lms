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
			<h1>로그인</h1>
		</div>
		<div>
			<form id="frm" action="memberlogin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">아이디</th>
							<td width="200"><input type="text" id="memberId" name="memberId" autofocus></td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td>
							<input type="password" id="memberPassword" name="memberPassword">
							</td>
						</tr> <!-- 서밋하면 폼에 각 네임들 실어간다 -->
					</table>
				</div>
<br>
<div>
<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
<input type="reset" value="취소">
</div>
			</form>
		</div>
	</div>
</body>
</html>