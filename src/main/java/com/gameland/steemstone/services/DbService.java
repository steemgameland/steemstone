package com.gameland.steemstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameland.steemstone.vos.CustomerInfoVo;
import com.gameland.steemstone.vos.DemoVo;
import com.gameland.steemstone.vos.SignInfoVo;
import com.gameland.steemstone.vos.UserInfoVo;

@Service
public class DbService {

	@Autowired
	DbMapper dbMapper;
	
	public List<DemoVo> getDual() throws Exception{
		return dbMapper.getDual();
	}
	
	public UserInfoVo getDevice(UserInfoVo deviceInfo) throws Exception{
		return dbMapper.getDevice(deviceInfo);
	}

	public UserInfoVo getUserInfo(UserInfoVo deviceInfo) throws Exception{
		return dbMapper.getUserInfo(deviceInfo);
	}
	
	public void putDevice(UserInfoVo deviceInfo) throws Exception{
		dbMapper.putDevice(deviceInfo);
	}
	
	public List<CustomerInfoVo> getCustomer(UserInfoVo userInfo) throws Exception{
		return dbMapper.getCustomer(userInfo);
	}
	
	public List<SignInfoVo> crtSignInfo(SignInfoVo signInfo) throws Exception{
		return dbMapper.crtSignInfo(signInfo);
	}
	
	public SignInfoVo getSignInfo(SignInfoVo signInfoVo) throws Exception{
		return dbMapper.getSignInfo(signInfoVo);
	}
	
	public SignInfoVo getConfig(SignInfoVo signInfo) throws Exception{
		return dbMapper.getConfig(signInfo);
	}
}
