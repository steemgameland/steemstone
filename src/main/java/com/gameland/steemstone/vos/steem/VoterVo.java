package com.gameland.steemstone.vos.steem;

public class VoterVo {

	private String permlink;
	private String voter;
	private float voting;
	private float currGold;
	
	public String getPermlink() {
		return permlink;
	}
	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}
	public String getVoter() {
		return voter;
	}
	public void setVoter(String voter) {
		this.voter = voter;
	}
	public float getVoting() {
		return voting;
	}
	public void setVoting(float voting) {
		this.voting = voting;
	}
	public float getCurrGold() {
		return currGold;
	}
	public void setCurrGold(float currGold) {
		this.currGold = currGold;
	}
}
