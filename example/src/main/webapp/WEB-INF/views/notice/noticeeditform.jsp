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
			<h1>게시글수정</h1>
		</div>
		<div>
			<form id="frm" action="noticeedit.do" method="post"
				enctype="multipart/form-data">
				<div>
					<table border="1" style="border-radius: 20px">
						<thead>
							<tr>
								<th width="50" height="30" style="border-top-left-radius: 20px">번호</th>
								<td width="50" align="center"><input type="text"
									id="noticeId" name="noticeId" value="${n.noticeId }"
									readonly="readonly"></td>
								<th width="50">제목</th>
								<td width="250" align="center"><input type="text"
									id="noticeTitle" name="noticeTitle" value="${n.noticeTitle }"></td>
								<th width="80">작성자</th>
								<td width="120" align="center"><input type="text"
									id="noticeWriter" name="noticeWriter"
									value="${n.noticeWriter }" readonly="readonly"></td>
								<th width="80">작성일</th>
								<td width="120" align="center"
									style="border-top-right-radius: 20px"><input type="date"
									id="noticeDate" name="noticeDate" value="${n.noticeDate }"
									readonly="readonly"></td>
							</tr>
							<tr>
								<td colspan="8" height="500" width="800" valign="top"
									bgcolor="#EFF8FB"><textarea rows="20" cols="80"
										id="noticeSubject" name="noticeSubject"></textarea></td>
							</tr>
	<tr>
								<td colspan="8"
									style="border-bottom-left-radius: 20px; border-bottom-right-radius: 20px; padding:10px"><input type="file" id="file" name="file"></td>
							</tr>
						</thead>
					</table>
				</div>
				<br>
				<div>
					<input type="submit" value="수정">&nbsp;&nbsp;&nbsp; <input
						type="button" onclick="location.href='noticelist.do'" value="취소">
				</div>
				<input type="hidden" id="noticeId" name="noticeId" value=${n.noticeId }>
			</form>
		</div>
	</div>
</body>
</html>