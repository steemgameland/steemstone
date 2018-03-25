package com.gameland.steemstone.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameland.steemstone.Constants;
import com.gameland.steemstone.SteemApi;
import com.gameland.steemstone.services.DbMapper;
import com.gameland.steemstone.services.DbService;
import com.gameland.steemstone.vos.CustomerInfoVo;
import com.gameland.steemstone.vos.SignInfoVo;
import com.gameland.steemstone.vos.UserInfoVo;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.Asset;
import eu.bittrade.libs.steemj.base.models.Authority;
import eu.bittrade.libs.steemj.base.models.ExtendedAccount;
import eu.bittrade.libs.steemj.base.models.Permlink;
import eu.bittrade.libs.steemj.configuration.SteemJConfig;
import eu.bittrade.libs.steemj.enums.PrivateKeyType;
import eu.bittrade.libs.steemj.exceptions.SteemCommunicationException;
import eu.bittrade.libs.steemj.exceptions.SteemResponseException;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private DbService dbService;
	
	@RequestMapping("/hello") 
    public String hello(Model model, 
    		@RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        
        try{
        	SteemJ steemApi = SteemApi.getInstance().getSteemJ();
            System.out.println(steemApi.getAccountCount());
            
        	model.addAttribute("result", dbService.getDual());
        }catch(SteemResponseException e){
        	logger.error("SteemResponseException.....................");
        	e.printStackTrace();
        }catch(SteemCommunicationException e){
        	logger.error("SteemCommunicationException.....................");
        	e.printStackTrace();
        }catch(Exception e){
        	logger.error("Other Exception.....................");
        	e.printStackTrace();
        }
        
        return "pages/index";
    }

	@RequestMapping("/getSignInfo")
    public @ResponseBody SignInfoVo  getSignInfo(Model model, @ModelAttribute SignInfoVo deviceInfo) {
		SignInfoVo resultSignInfo = null;

    	try{
			resultSignInfo = dbService.getSignInfo(deviceInfo);
        }catch(Exception e){
        	e.printStackTrace();
        }
    	
        return resultSignInfo;
    }
	
	@RequestMapping("/signDeviceSearch")
    public @ResponseBody UserInfoVo  signDeviceSearch(Model model, @ModelAttribute UserInfoVo deviceInfo) {
		UserInfoVo resultDeviceInfo = null;

    	try{
			System.out.println(deviceInfo.getUser_id());
			System.out.println(deviceInfo.getMac_addr());
			
			resultDeviceInfo = dbService.getDevice(deviceInfo);
        }catch(Exception e){
        	e.printStackTrace();
        }
    	
        return resultDeviceInfo;
    }
	
	@RequestMapping("/signDeviceRegisters")
    public @ResponseBody String  signDeviceRegisters(Model model, @ModelAttribute UserInfoVo deviceInfo) {
		String result = "fail";
    	try{
			System.out.println(deviceInfo.getUser_id());
			System.out.println(deviceInfo.getMac_addr());
			UserInfoVo resultUserInfo = dbService.getUserInfo(deviceInfo);
			
			if(resultUserInfo != null)
			{
				resultUserInfo.setMac_addr(deviceInfo.getMac_addr());
				dbService.putDevice(resultUserInfo);
				resultUserInfo = dbService.getDevice(deviceInfo);
				result = "success";
			}
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return result;
    }
	
	@RequestMapping("/getUserInfo")
    public @ResponseBody UserInfoVo  getUserInfo(Model model, @ModelAttribute UserInfoVo userInfo) {
		UserInfoVo resultUserInfo = null;

    	try{
			System.out.println(userInfo.getUser_id());
			System.out.println(userInfo.getMac_addr());
			
			resultUserInfo = dbService.getUserInfo(userInfo);
        }catch(Exception e){
        	e.printStackTrace();
        }
    	
        return resultUserInfo;
    }
	
	@RequestMapping("/getCustomer")
    public @ResponseBody List<CustomerInfoVo> getCustomer(Model model, @ModelAttribute UserInfoVo userInfo) {
		List<CustomerInfoVo> resultDeviceInfo = null;
		try{
//			System.out.println(userInfo.getUserId());
//			System.out.println(userInfo.getMacAddr());
			 resultDeviceInfo = dbService.getCustomer(userInfo);
//			System.out.println("Result:" + resultDeviceInfo);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return resultDeviceInfo;
    }
	
	@RequestMapping("/getConfig")
    public @ResponseBody SignInfoVo getConfig(Model model, @ModelAttribute SignInfoVo signInfo) {
		SignInfoVo resultSignInfo = null;
		try{
			resultSignInfo = dbService.getConfig(signInfo);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return resultSignInfo;
    }
	
	@RequestMapping("/signConfirm")
    public @ResponseBody String signConfirm(Model model, @ModelAttribute SignInfoVo signInfo) {
		String result = "fail";
    	try{
			dbService.crtSignInfo(signInfo);
			result = "success_confirm";
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return result;
    }
	
	@RequestMapping("/signCancel")
    public @ResponseBody String signCancel(Model model, @ModelAttribute SignInfoVo signInfo) {
		String result = "fail";
    	try{
//			dbService.chgSaveOk(signInfo);
			result = "success_cancel";
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return result;
    }
}

