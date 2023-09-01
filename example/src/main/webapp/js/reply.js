class Reply {
	notUse() {
		fetch('AjaxReplyList.do?noticeId=' + noticeId)
			.then(resolve => resolve.json())
			.then(json => {
				console.log(json);
			})
			.catch(console.log);
	}
	//댓글목록
	replyList(noticeId, callback) {
//		$.getJSON('AjaxReplyList.do?noticeId=' + noticeId, function(data) {
//			callback(data)
//		})

		$.ajax({
			url: 'AjaxReplyList.do?noticeId=' + noticeId,
			success: function(data) {
				callback(data);
			}
		})

	}
	//댓글등록. 파라미터:게시클번호, 댓글내용, 댓글작성자
	replyAdd(param = { noticeId, reply, replyer }, callback, errorcall) {
//		$.post('AjaxReplyAdd.do', param, function(data) {
//			callback(data);
//		})

		$.ajax({
			url: 'AjaxReplyAdd.do', //key: value (값이 담기면 속성, 함수가 담기면 메소드)
			data: param,
			success: function(data) {
				callback(data);
			},
			error: function(err){
				errorcall(err)
			}
		})

	}
	//단건조회. param = replyId;
	replySearch(replyId, callback) {
//		$.getJSON('AjaxReplySearch.do?rno=' + replyId, function(data) {
//			callback(data);
//		})

		$.ajax({
			url: 'AjaxReplySearch.do?rno=' + replyId,
			success: function(data) {
				callback(data);
			}
		})

	}
	
	replyEdit(param = { noticeId, reply, replyer }, callback, errorcall) {
		$.ajax({
			url: 'AjaxReplyEdit.do?rno=' + replyId, //key: value (값이 담기면 속성, 함수가 담기면 메소드)
			data: param,
			success: function(data) {
				callback(data);
			},
			error: function(err){
				errorcall(err)
			}
		})

	}


	//문자열을->날짜포맷으로 변경
	displayDateTime(dateStr) {
		var mils = Date.parse(dateStr);//'Aug 29, 2023, 9:16:27 AM'
		var today = new Date(mils);

		var yyyy = today.getFullYear();
		var MM = "0" + (today.getMonth() + 1);
		var dd = "0" + today.getDate();
		var hh = "0" + today.getHours();
		var mm = "0" + today.getMinutes();
		var ss = "0" + today.getSeconds();

		return yyyy + "/" + MM.slice(-2) + "/" + dd.slice(-2) + "	 " + hh.slice(-2) + ":" + mm.slice(-2) + ":" + ss.slice(-2);
	}
}



