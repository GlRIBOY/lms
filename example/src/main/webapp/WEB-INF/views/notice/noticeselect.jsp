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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<!-- Custom styles for this template-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

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
				<!-- 댓글. -->

				<!-- 댓글입력 -->
				<div style="margin: 10px">
					작성자<input id="repler"> 댓글<input id="reple">
					<button id="sub">작성</button>
				</div>
				<!-- end 댓글입력 -->

				<!-- 댓글목록 -->
				<table id="example" class="display" style="width: 100%">
					<thead>
						<tr>
							<th>번호</th>
							<th>댓글</th>
							<th>작성자</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>번호</th>
							<th>댓글</th>
							<th>작성자</th>
							<th>날짜</th>
						</tr>
					</tfoot>
				</table>
				<!-- end 댓글목록 -->

				<!-- end 댓글-->
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
							</div>
							<div class="modal-body">
								<div class='form-group'>
									<label>Reply</label> <input class='form-control' name='reply'
										value='New Reply!!!!'>
								</div>
								<div class='form-group'>
									<label>Replyer</label> <input class='form-control'
										name='replyer' value='replyer'>
								</div>
								<div class='form-group'>
									<label>Reply Date</label> <input class='form-control'
										name='replyDate' value='replyDate'>
								</div>
							</div>
							<div class="modal-footer">
								<button id='modalModBtn' type="button" class="btn btn-warning"
									data-dismiss="modal">Modify</button>
								<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
								<button id='modalRegisterBtn' type="button"
									class="btn btn-default">Register</button>
								<button id='modalCloseBtn' type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				
				<script src="http://code.jquery.com/jquery-latest.min.js"></script>
				<script src="jquery/bootstrap.min.js"></script>



				<script type="text/javascript">
		const table = new DataTable('#example', {
			ajax: 'jquery/AjaxDatatable.do',
			columns:[
			{data: 'replyId'},
			{data: 'reply'},
			{data: 'replyer'},
			{data: 'replyDate'}
			]
		});

	</script>


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


var reply = new Reply();
reply.replyList(noticeId, function(data){
	
for (let i=0; i<data.length; i++){
	let temp = $('.chat > li').eq(0).clone();
	temp.css('display', 'block');
	
	temp.attr('data-rno', data[i].replyId);
	temp.find('strong').text(data[i].replyer);
	temp.find('small').text(reply.displayDateTime(data[i].replyDate));
	temp.find('p').text(data[i].reply);
	
$('.chat').append(temp);
}
})

//댓ㄱㄹ등록처리
$('#sub').on('click', function(){
	var writer = $('#repler').val();
	var content = $('#reple').val();
	const reply = new Reply();
	const param = {noticeId, reply: content, replyer: writer
			}
	
	reply.replyAdd(param, function(data){
		addNewRow(data.data);
	});
})
		function addNewRow(row) {
		    table.row
		        .add({
					replyId: row.replyId,
					reply: row.reply,
					replyer: row.replyer,
					replyDate: row.replyDate
		})
		        .draw(false);
		 
		}
//수정, 삭제화면
$('.chat').on('dblclick', 'li', function(){
	$('#modalModBtn').show();
	$('#modalRemoveBtn').show();
	$('#modalRegisterBtn').hide();
	$('.modal').modal('show');
	
	var rno = $(this).attr('data-rno')
	rno = $(this).data('rno');
	
	//data-rno = 1
	reply.replySearch(rno, function(data){
		$('input[name=reply]').val(data.reply);
		$('input[name=replyer]').val(data.replyer);
		$('input[name=replyDate]').val(reply.displayDateTime(data.replyDate));
	})
})

//수정
$('#modalModBtn').on('click', function(){

	let temp = $('.form-group');
	temp.find('input[name=reply]').val();
	temp.find('input[name=replyer]').val();
	
	temp.attr('data-rno', data.data.replyId);
	temp.find('strong').text(data.data.replyer);
	temp.find('small').text(reply.displayDateTime(data.data.replyDate));
	temp.find('p').text(data.data.reply);
		
//		reply.replyEdit(,function(){
			
//		})
		
		
})

</script>
</body>
</html>