<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Cards</title>

<!-- Custom fonts for this template-->
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<style>
.cheader .replyId {
	display: inline-block;
	width: 50px;
}

.cheader .replyer {
	float: right;
	padding-right: 50px;
}
</style>
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
	<div class="container-fluid">

		<div class="reply">
			<h3>댓글목록</h3>
			<div class="col-lg-10">
				<div class="card mb-4" style="display: none;">
					<div class="cheader">
						<div class="replyId">12</div>
						<div class="replyer">user1</div>
					</div>
					<div class="cbody">댁글</div>
				</div>
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
function noticeUpdate(str){
	if(str =='E'){
		document.getElementById("frm").action = "noticeeditform.do";
	}else if(str=='D'){
		document.getElementById("frm").action = "noticedelete.do";
	}document.getElementById("frm").submit();
}
</script>
	<script src="./js/reply.js"></script>
	<script type="text/javascript">
var noticeId = '<c:out value="${n.noticeId }"/>';
console.log('notice: ', noticeId);

var reply = new Reply();
reply.replyList(noticeId, function(data){
	
for (let i=0; i<data.length; i++){
	let temp = $('div.card.mb-4').eq(0).clone();
	temp.css('display', 'block');
	
	temp.find('div.replyId').text(data[i].replyId);
	temp.find('div.replyer').text(data[i].replyer);
	temp.find('div.card-body').text(data[i].reply);
	
$('div.col-lg-10').append(temp);
}
})
</script>

</body>
</html>