package com.gameland.steemstone.services;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gameland.steemstone.vos.CustomerInfoVo;
import com.gameland.steemstone.vos.DemoVo;
import com.gameland.steemstone.vos.SignInfoVo;
import com.gameland.steemstone.vos.UserInfoVo;


@Mapper
@Repository
public interface DbMapper {

	public List<DemoVo> getDual() throws Exception;
	public UserInfoVo getDevice(UserInfoVo deviceInfo) throws Exception;
	public UserInfoVo getUserInfo(UserInfoVo deviceInfo) throws Exception;
	public void putDevice(UserInfoVo deviceInfo) throws Exception;
	public List<CustomerInfoVo> getCustomer(UserInfoVo userInfo) throws Exception;
	public List<SignInfoVo> getReqSign() throws Exception;
	public SignInfoVo getSignInfo(SignInfoVo signInfoVo) throws Exception;
	public SignInfoVo getConfig(SignInfoVo signInfo) throws Exception;
	public List<SignInfoVo> crtSignInfo(SignInfoVo signInfo);
}
