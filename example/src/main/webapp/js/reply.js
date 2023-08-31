class Reply {
	notUse() {
		fetch('AjaxReplyList.do?noticeId=' + noticeId)
			.then(resolve => resolve.json())
			.then(json => {
				console.log(json);
			})
			.catch(console.log);
	}

	replyList(noticeId, callback) {
		$.getJSON('AjaxReplyList.do?noticeId=' + noticeId, function(data) {
			callback(data)
		})
	}
	//댓글등록. 파라미터:게시클번호, 댓글내용, 댓글작성자
	replyAdd(param={noticeId, reply, replyer}, callback){
		$.post('AjaxReplyAdd', reply, function(data){
			callback(data);
		})
	}
}



