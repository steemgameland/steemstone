package com.gameland.steemstone.vos.steem;

public class PostingVo {
	private String permlink;
	private String kind;
    private String closed;
    private String payment;
    private String inputDte;
    
	public String getPermlink() {
		return permlink;
	}
	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getClosed() {
		return closed;
	}
	public void setClosed(String closed) {
		this.closed = closed;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getInputDte() {
		return inputDte;
	}
	public void setInputDte(String inputDte) {
		this.inputDte = inputDte;
	}

}
