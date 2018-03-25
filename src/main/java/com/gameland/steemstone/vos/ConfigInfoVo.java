package com.gameland.steemstone.vos;

public class ConfigInfoVo {
	private String db_name;
	private String fact_id;
    private String table_name;
    private String ftp_addr;
    private String ftp_id;
    private String ftp_pwd;
    
    public String getFactId() {
		return fact_id;
	}

	public void setFactId(String factId) {
		this.fact_id = factId;
	}

	public String getDbName() {
		return db_name;
	}

	public void setDbName(String dbName) {
		this.db_name = dbName;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getFtp_addr() {
		return ftp_addr;
	}

	public void setFtp_addr(String ftp_addr) {
		this.ftp_addr = ftp_addr;
	}

	public String getFtp_id() {
		return ftp_id;
	}

	public void setFtp_id(String ftp_id) {
		this.ftp_id = ftp_id;
	}

	public String getFtp_pwd() {
		return ftp_pwd;
	}

	public void setFtp_pwd(String ftp_pwd) {
		this.ftp_pwd = ftp_pwd;
	}

}
