package com.gameland.steemstone.vos.steem;

public class ReplyVo {

	private String replyPermlink;
	private String account;
	private String parentPermlink;
	private String completed;
	
	public String getReplyPermlink() {
		return replyPermlink;
	}
	public void setReplyPermlink(String replyPermlink) {
		this.replyPermlink = replyPermlink;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getParentPermlink() {
		return parentPermlink;
	}
	public void setParentPermlink(String parentPermlink) {
		this.parentPermlink = parentPermlink;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
}
