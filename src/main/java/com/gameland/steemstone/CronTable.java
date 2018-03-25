package com.gameland.steemstone;

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
			SteemApi steemApi = SteemApi.getInstance();
			SteemJ api = steemApi.getSteemJ();
			
			List<VoteState> voteList = api.getActiveVotes(steemApi.getAccount(), new Permlink("human-20180308"));
			
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
        
//		try{
//			List<SignInfoVo> lstSignInfo = dbService.getReqSign();
//			System.out.println("List Count : " + lstSignInfo.size());
//			if(lstSignInfo.size() == 0) return;
//			
//			for(int i = 0 ; i < lstSignInfo.size() ; i++)
//			{
//				SignInfoVo signInfoVo = lstSignInfo.get(i);
//				makeSendFcmMessage(signInfoVo);
//			}
//			// firebase
//		}catch(Exception e){
//			System.out.println("Scheduler error..!!");
//		}
		logger.info("chkVoter start!!************************");
	}
	
	private void makeSendFcmMessage(SignInfoVo signInfoVo){
		String url="http://fcm.googleapis.com/fcm/send";
		try {
			URL object = new URL(url);
			HttpURLConnection con = (HttpURLConnection) object.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
//			con.setRequestProperty("Authorization", "key=AAAAK2L4kls:APA91bGtudfR6cORYxicBYkh2bLE0GzlZz5iOQAbbd0bjHi3qxG0m5CwKZrDWk6e9f1Z_lYAnriLaDKPGUkPLsaoYmA7rnyf-jl46crKlWRtFGjeoM58KfaI7Ic9yADVEEIpYBL6dK4u");
			con.setRequestProperty("Authorization", "key=AAAAK2L4kls:APA91bGJicVuYwVXRPvBIuL7Cf11l54X3ddjTtYhfII36vnuLRuUvCvyJA1X3sPIY54vQW0omqKRMb9VWlSiLUQlS-nyaJwQX4Yc6IZX2sC7W5E0Pd1OKuwiZBbXalkzeiH5gnEaSvKp");
			con.setRequestMethod("POST");
			
			JSONObject data   = new JSONObject();
			data.put("title", URLEncoder.encode("Sign", "euc-kr"));
			data.put("body",  URLEncoder.encode(signInfoVo.getRecseq() + " ", "euc-kr"));

			JSONObject firebaseMessage   = new JSONObject();
//			firebaseMessage.put("to", signInfoVo.getTokenId());
			firebaseMessage.put("priority", "high");
//			firebaseMessage.put("notification", notification);
			firebaseMessage.put("data", data);

			OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
			wr.write(firebaseMessage.toString());
			wr.flush();

			//display what returns the POST request

			StringBuilder sb = new StringBuilder();  
			int HttpResult = con.getResponseCode(); 
			if (HttpResult == HttpURLConnection.HTTP_OK) {
			    BufferedReader br = new BufferedReader(
			            new InputStreamReader(con.getInputStream(), "utf-8"));
			    String line = null;  
			    while ((line = br.readLine()) != null) {  
			        sb.append(line + "\n");  
			    }
			    br.close();
			    System.out.println("" + sb.toString());  
//			    signInfoVo.setSaveOk("2");
//			    dbService.chgSaveOk(signInfoVo);
			} else {
			    System.out.println(con.getResponseMessage());  
			}  
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch(Exception e){
			System.out.println("!!!Exception..");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
