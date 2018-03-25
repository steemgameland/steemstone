package com.gameland.steemstone.vos;

public class UserInfoVo {
	private String db_name;
	private String factid;
    private String mac_addr;
    private String user_id;
    private String user_nm;
    private String recseq;
    
	public String getDb_name() {
		return db_name;
	}
	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}
	public String getFactid() {
		return factid;
	}
	public void setFactid(String factid) {
		this.factid = factid;
	}
	public String getMac_addr() {
		return mac_addr;
	}
	public void setMac_addr(String mac_addr) {
		this.mac_addr = mac_addr;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getRecseq() {
		return recseq;
	}
	public void setRecseq(String recseq) {
		this.recseq = recseq;
	}
}