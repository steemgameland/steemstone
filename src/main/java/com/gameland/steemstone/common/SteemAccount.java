package com.gameland.steemstone.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.enums.PrivateKeyType;

public class SteemAccount {

	private static final Logger logger = LoggerFactory.getLogger(SteemAccount.class);
	
	private AccountName account;
	private List<ImmutablePair<PrivateKeyType, String>> privateKeys;
	
	public AccountName getAccount() {
		return account;
	}

	private void setAccount(AccountName account) {
		this.account = account;
	}

	public List<ImmutablePair<PrivateKeyType, String>> getPrivateKeys() {
		return privateKeys;
	}

	private void setPrivateKeys(List<ImmutablePair<PrivateKeyType, String>> privateKeys) {
		this.privateKeys = privateKeys;
	}

	public SteemAccount(){
		logger.info("create accountname instance... ");
		setSteemAccount();
	}
	
	/**
	 * Set Singleton
	 */
	private static class Singleton{
		private static final SteemAccount account = new SteemAccount();
	}
	
	/**
	 * Get Singleton instance
	 */
	public static SteemAccount getInstance(){
		return Singleton.account;
	}
	
	private void setSteemAccount(){
		CommFunc commfunc = new CommFunc();
		
		try{
			// Load Steem Properties
			Properties properties = commfunc.loadProp(Constants.STEEM_PROPERTIES);
			if(properties == null) throw new IOException();
			
//			properties.list(System.out);
			
			// Get Private Keys
			List<ImmutablePair<PrivateKeyType, String>> keys = new ArrayList<>();
			keys.add(new ImmutablePair<>(PrivateKeyType.POSTING, (String)properties.get("account.posting")));
			keys.add(new ImmutablePair<>(PrivateKeyType.ACTIVE, (String)properties.get("account.active")));
			keys.add(new ImmutablePair<>(PrivateKeyType.MEMO, (String)properties.get("account.memo")));
			
			// Set Account Info
			setAccount(new AccountName(properties.getProperty("account.name")));
			setPrivateKeys(keys);
			
		}catch(IOException e){
			logger.error("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+==+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
			logger.error("fail to load steem.properties file...!!!");
			logger.error("1. Please read Readme.txt file in src/main/resources/properties/");
			logger.error("2. Please make steem.properties file in src/main/resources/properties/");
			logger.error("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+==+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
			e.printStackTrace();
		}catch(Exception e){
			logger.error("setConfig Exception..");
			e.printStackTrace();
		}
	}
}
