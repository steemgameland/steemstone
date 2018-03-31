package com.gameland.steemstone.common;

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

	private static final Logger logger = LoggerFactory.getLogger(SteemApi.class);
	
	// default response timeout
	private final int RESPONSE_TIMEOUT = 60000;
	
	// Global SteemJ Class
	private static SteemJ steemj;
	
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
	 * Set Default SteemJ Config
	 */
	private void setConfig(){
		logger.info("setconfig....");
		
		SteemAccount account = new SteemAccount();
		
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
		logger.info("create steemj instance... ");
		return Singleton.steemApi;
	}
}
