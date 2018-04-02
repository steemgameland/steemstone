package com.gameland.steemstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameland.steemstone.vos.game.DeckVo;
import com.gameland.steemstone.vos.game.UnitVo;
import com.gameland.steemstone.vos.steem.PostingVo;
import com.gameland.steemstone.vos.steem.VoterVo;

@Service
public class DbService {

	@Autowired
	DbMapper dbMapper;
	
	public List<UnitVo> getDual() throws Exception{
		return dbMapper.getDual();
	}
	
	public PostingVo getPosting(PostingVo vo) throws Exception{
		return dbMapper.getPosting(vo);
	}

	public List<UnitVo> getUserInfo(UnitVo vo) throws Exception{
		return dbMapper.lstUnit(vo);
	}
	
	public void putVoterVo(VoterVo vo) throws Exception{
		dbMapper.putVoterVo(vo);
	}
	
	public void crtDeck(DeckVo vo) throws Exception{
		dbMapper.crtDeck(vo);
	}
	
	public void crtPosting(PostingVo vo) throws Exception{
		dbMapper.crtPosting(vo);
	}
}
