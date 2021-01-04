package com.soheejjang.easycovid19.model.selfDiagnosis.dto;

import java.util.Date;

public class SelfDiagnosisDTO {
	private int bno;  
	private String writer;
	private String fever;
	private String cough;
	private String soreThroat;
	private String bodyAche;
	private String etc;
	private String etcDetails;  
	private Date regdate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFever() {
		return fever;
	}
	public void setFever(String fever) {
		this.fever = fever;
	}
	public String getCough() {
		return cough;
	}
	public void setCough(String cough) {
		this.cough = cough;
	}
	public String getSoreThroat() {
		return soreThroat;
	}
	public void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}
	public String getBodyAche() {
		return bodyAche;
	}
	public void setBodyAche(String bodyAche) {
		this.bodyAche = bodyAche;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getEtcDetails() {
		return etcDetails;
	}
	public void setEtcDetails(String etcDetails) {
		this.etcDetails = etcDetails;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "SelfDiagnosisDTO [bno=" + bno + ", writer=" + writer + ", fever=" + fever + ", cough=" + cough
				+ ", soreThroat=" + soreThroat + ", bodyAche=" + bodyAche + ", etc=" + etc + ", etcDetails="
				+ etcDetails + ", regdate=" + regdate + "]";
	}
	 
	
}
