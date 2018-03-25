package com.gameland.steemstone;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.configuration.SteemJConfig;
import eu.bittrade.libs.steemj.enums.PrivateKeyType;

public class SteemApi {

	private static final Logger logger = LoggerFactory.getLogger(Constants.class);
	
	// Steem Properties
//	private Properties properties;
	// default response timeout
	private final int RESPONSE_TIMEOUT = 60000;
	
	// default account
	private static String accountName;
	// Default Account
	private static AccountName defaultAccount;
	// Global SteemJ Class
	private static SteemJ steemj;
	
	public static String getName(){
		return accountName;
	}
	public static AccountName getAccount(){
		return defaultAccount;
	}
	public static SteemJ getSteemJ(){
		return steemj;
	}
	
	/**
	 * Private Constructor
	 */
	private SteemApi(){
	    try{
	    	setConfig();
	    	steemj = new SteemJ();
		}catch(Exception e){
			logger.error("Constants Singletone contruction error...");
			e.printStackTrace();
		}
	}
	
	/**
	 * Load Properties
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private Properties loadProp(String path) throws IOException {
	    InputStream inputStream = getClass().getResourceAsStream(path);
	    Properties properties = new Properties();
	    properties.load(inputStream);
	    inputStream.close();
	    return properties;
	}
	
	/**
	 * Set Default SteemJ Config
	 */
	private void setConfig(){
		logger.info("setconfig....");
		
		Properties properties = new Properties();
		
		try{
			properties = loadProp("/steem.properties");
			properties.list(System.out);
			
		}catch(IOException e){
			logger.error("fail to load properties file...");
			e.printStackTrace();
			return;
		}
		
		accountName = properties.getProperty("gameland.name");
		defaultAccount = new AccountName(accountName);
		
		SteemJConfig steemJConfig = SteemJConfig.getInstance();
		steemJConfig.setResponseTimeout(RESPONSE_TIMEOUT);
		steemJConfig.setDefaultAccount(defaultAccount);
		
	    List<ImmutablePair<PrivateKeyType, String>> privateKeys = new ArrayList<>();
	    privateKeys.add(new ImmutablePair<>(PrivateKeyType.POSTING, (String)properties.get("gameland.posting")));
	    privateKeys.add(new ImmutablePair<>(PrivateKeyType.ACTIVE, (String)properties.get("gameland.active")));
	    privateKeys.add(new ImmutablePair<>(PrivateKeyType.MEMO, (String)properties.get("gameland.memo")));
	
	    steemJConfig.getPrivateKeyStorage().addAccount(steemJConfig.getDefaultAccount(), privateKeys);
	}
	
	/**
	 * Set Singleton
	 */
	private static class Singleton{
		private static final SteemApi steemApi = new SteemApi();
	}
	
	/**
	 * Get Singleton instance
	 */
	public static SteemApi getInstance(){
		logger.info("create steemj instance... ");
		return Singleton.steemApi;
	}
}
