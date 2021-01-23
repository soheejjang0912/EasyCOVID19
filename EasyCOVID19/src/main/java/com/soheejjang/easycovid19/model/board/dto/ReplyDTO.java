package com.soheejjang.easycovid19.model.board.dto;

import java.util.Date;

public class ReplyDTO {
	private int rno;
	private int bno;
	private String replytext;
	private String replyer;
	private Date regdate;
	private String writer;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", regdate=" + regdate + ", writer=" + writer + "]";
	}
	
}
