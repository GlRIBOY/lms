package kr.giri.example.notice.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class NoticeVO {
	int noticeId;
	String noticeWriter;
	String noticeTitle;
	String noticeSubject;
	LocalDate noticeDate; 
	String noticeAttech;
	String noticeAttechDir;
	int noticeHit;
}
