package com.gameland.steemstone.interfaces;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gameland.steemstone.common.SteemAccount;
import com.gameland.steemstone.common.SteemApi;
import com.gameland.steemstone.enums.Camp;
import com.gameland.steemstone.schedulers.SteemScheduler;
import com.gameland.steemstone.services.DbService;
import com.gameland.steemstone.vos.steem.PostingVo;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.Permlink;
import eu.bittrade.libs.steemj.base.models.TimePointSec;
import eu.bittrade.libs.steemj.base.models.VoteState;
import eu.bittrade.libs.steemj.exceptions.SteemCommunicationException;
import eu.bittrade.libs.steemj.exceptions.SteemResponseException;

public class SteemOrder implements IOrder{

	private static final Logger logger = LoggerFactory.getLogger(SteemScheduler.class);
	
	@Autowired
	private DbService dbService;
	
	private SteemJ steemj;
	private AccountName account;
	
	public SteemOrder(){
		steemj = SteemApi.getInstance().getSteemJ();
		account = SteemAccount.getInstance().getAccount();
	}
	
	public void gamePosting(Camp camp){
		PostingVo vo = new PostingVo();
		vo.setClosed("N");
		vo.setPayment("N");
		vo.setInputDte("");
		
		if(camp == Camp.ORC){
			// ORC Camp
			vo.setPermlink("O20180401");
			vo.setKind("O");
		}else if(camp == Camp.HUMAN){
			// Human Camp
			vo.setPermlink("H20180401");
			vo.setKind("H");
		}
		
		try{
			dbService.crtPosting(vo);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void buyUnit(){
		// TODO Auto-generated method stub
	}

	@Override
	public void buyMagic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendGold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDeck() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEnemyDeck() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTeamGold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEnemyGold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDeckPosition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGold() {
		// TODO Auto-generated method stub
		try{
			List<VoteState> voteList = this.steemj.getActiveVotes(this.account, new Permlink("human-20180308"));
			
			for(VoteState vote : voteList){
				int percent = vote.getPercent();
				BigInteger reputation = vote.getReputation();
				BigInteger rshares = vote.getRshares();
				TimePointSec time = vote.getTime();
				AccountName voter = vote.getVoter();
				BigInteger weight =  vote.getWeight();
				
				logger.info(voter.getName() + time.getDateTime());
			}
		}catch(SteemCommunicationException e){
			logger.error("addGold() SteemCommunicationException....");
			e.printStackTrace();
		}catch(SteemResponseException e){
			
		}catch(Exception e){
			
		}
	}

	@Override
	public void removeGold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferGold() {
		// TODO Auto-generated method stub
		
	}
}
