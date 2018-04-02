package com.gameland.steemstone.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.configuration.SteemJConfig;

public class SteemApi {

	private static final Logger logger = LoggerFactory.getLogger(SteemApi.class);
	
	// default response timeout
	private final int RESPONSE_TIMEOUT = 60000;
	
	// Global SteemJ Class
	private SteemJ steemj;
	
	public SteemJ getSteemJ(){
		return steemj;
	}
	
	/**
	 * Private Constructor
	 */
	private SteemApi(){
	    try{
	    	setConfig();
	    	logger.info("create steemj instance... ");
	    	steemj = new SteemJ();
		}catch(Exception e){
			logger.error("Constants Singletone contruction error...");
			e.printStackTrace();
		}
	}
	
	/**
	 * Set Default SteemJ Config
	 */
	private void setConfig(){
		logger.info("setconfig....");
		
		SteemAccount account = SteemAccount.getInstance();
		
		SteemJConfig steemJConfig = SteemJConfig.getInstance();
		steemJConfig.setResponseTimeout(RESPONSE_TIMEOUT);
		steemJConfig.setDefaultAccount(account.getAccount());
	    steemJConfig.getPrivateKeyStorage().addAccount(steemJConfig.getDefaultAccount(), account.getPrivateKeys());
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
		return Singleton.steemApi;
	}
}
