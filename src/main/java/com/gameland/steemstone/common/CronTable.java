package com.gameland.steemstone.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gameland.steemstone.services.DbService;
import com.gameland.steemstone.vos.SignInfoVo;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.Permlink;
import eu.bittrade.libs.steemj.base.models.TimePointSec;
import eu.bittrade.libs.steemj.base.models.VoteState;
import eu.bittrade.libs.steemj.configuration.SteemJConfig;

@Component
public class CronTable {
	
	private static final Logger logger = LoggerFactory.getLogger(CronTable.class);
	
	@Autowired
	private DbService dbService;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void chkVoter(){
		logger.info("chkVoter start!!************************");
		// Create a new apiWrapper with your config object.
		try{
			SteemJConfig steemJConfig = SteemJConfig.getInstance();
			SteemApi steemApi = SteemApi.getInstance();
			SteemJ api = steemApi.getSteemJ();
			
			List<VoteState> voteList = api.getActiveVotes(steemJConfig.getDefaultAccount(), new Permlink("human-20180308"));
			
			for(VoteState vote : voteList){
				int percent = vote.getPercent();
				BigInteger reputation = vote.getReputation();
				BigInteger rshares = vote.getRshares();
				TimePointSec time = vote.getTime();
				AccountName voter = vote.getVoter();
				BigInteger weight =  vote.getWeight();
				
				logger.info(voter.getName() + time.getDateTime());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
        
		logger.info("chkVoter end!!************************");
	}
}
