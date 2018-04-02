package com.gameland.steemstone.services;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gameland.steemstone.vos.game.DeckVo;
import com.gameland.steemstone.vos.game.UnitVo;
import com.gameland.steemstone.vos.steem.PostingVo;
import com.gameland.steemstone.vos.steem.VoterVo;

@Mapper
@Repository
public interface DbMapper {

	public List<UnitVo> getDual() throws Exception;
	public PostingVo getPosting(PostingVo vo) throws Exception;
	public List<UnitVo> lstUnit(UnitVo vo) throws Exception;
	public void putVoterVo(VoterVo vo) throws Exception;
	public void crtDeck(DeckVo vo) throws Exception;
	public void crtPosting(PostingVo vo) throws Exception;
}
