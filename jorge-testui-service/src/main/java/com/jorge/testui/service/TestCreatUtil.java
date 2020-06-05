package com.jorge.testui.service;

import com.acooly.core.utils.Ids;
import com.acooly.core.utils.ObjectId;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.database.profit.dao.ProfitprofitActionRuleDao;
import com.jorge.testui.database.profit.dao.ProfitprofitEventDao;
import com.jorge.testui.database.profit.dao.ProfitprofitSectionDao;
import com.jorge.testui.database.profit.entity.ProfitprofitActionRule;
import com.jorge.testui.database.profit.entity.ProfitprofitEvent;
import com.jorge.testui.database.profit.entity.ProfitprofitSection;
import com.jorge.testui.utils.AssertsUtil;
import com.jorge.testui.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-11-28 14:58
 */
@Slf4j
public class TestCreatUtil {

	//创建交易
	public static JSONObject createTrade(	String sellerUserNo, String payerUserNo,
											String buyerUserNo, String payerUserName,
											String payeeUserNo, String gatewayUrl, String partnerId,
											String securityCheckKey, String accessKey) {
		
		//定义请求参数map,请求响应体，测试报告实体
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject responseEntity = new JSONObject();
		String requestNo = Ids.getDid(20);
		String merchOrderNo = Ids.getDid(20);
		map.clear();
		map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("requestNo", requestNo);
		map.put("service", "tradeCreate");
		map.put("partnerId", partnerId);
		map.put("signType", "MD5");
		map.put("version", "1.0");
		map.put("context", "test测试");
		map.put("merchOrderNo", merchOrderNo);
		map.put("tradeName", "在途资金测试 ");
		map.put("sellerUserNo", sellerUserNo);
		map.put("buyerUserNo", buyerUserNo);
		map.put("payerUserNo", payerUserNo);
		map.put("payerUserName", payerUserName);
		map.put("payeeUserNo", payeeUserNo);
		map.put("amount", "0.05");
		map.put("tradeProfitType", "AUTO");
		//            map.put("goodsInfoList", JSON.toJSONString(goodsInfoList));
		//            map.put("tradeProfitInfoList", tradeProfitInfoList);
		map.put("tradeTime", "2019-09-25 14:19:53");
		map.put("closeTime", "2020-10-25 14:19:53");
		map.put("tradeMemo", "testmemo");
		
		//		responseEntity = httpRequest("https://openapi-pay.cartechfin.com/gateway.do", map,
		//			"83b95b25056b3dcc49027403a3a2bc1e", "19102515073200010005");
		responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);
		
		AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));
		
		return responseEntity;
		
	}

	//二类户
	public static JSONObject blackholeOpenAccount(String merchOrderNo, String gatewayUrl, String partnerId,
												  String securityCheckKey, String accessKey,
												  String userNo,String bankCardNo,String mobileNo,String cardStartDate,
												  String cardEndDate,String idcardFront,String idcardBack) {

		//定义请求参数map,请求响应体，测试报告实体
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject responseEntity = new JSONObject();
		String requestNo = Ids.getDid(20);
		map.clear();
		map = new HashMap<String, Object>();
		map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("merchOrderNo", merchOrderNo);
		map.put("requestNo", requestNo);
		map.put("service", "blackholeOpenAccount");
		map.put("partnerId", partnerId);
		map.put("signType", "MD5");
		map.put("version", "1.0");
		map.put("context", "test测试二类户开户");
		map.put("userNo",userNo);
		map.put("bankCardNo",bankCardNo);
		map.put("mobileNo", mobileNo);
		map.put("cardStartDate", cardStartDate);
		map.put("cardEndDate",cardEndDate);
		map.put("nation", "汉");
		map.put("cardIssuingAuthority","重庆市公安局");
		map.put("homeAddr", "重庆市渝中区解放碑");
		map.put("job", "J_0");
		map.put("custVideoPic", idcardFront);
		map.put("idcardFront", idcardFront);
		map.put("idcardBack", idcardBack);
		map.put("publicTag", "N");
//		map.put("bankCardType","");
//		map.put("bankSubbranch","");

		responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);

		AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));

		return responseEntity;

	}
	
	//一码付
	public static JSONObject oneCodePay(String merchOrderNo, String gatewayUrl, String partnerId,
										String securityCheckKey, String accessKey,
										String payeeUserNo) {
		
		//定义请求参数map,请求响应体，测试报告实体
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject responseEntity = new JSONObject();
		String requestNo = Ids.getDid(20);
		map.clear();
		map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("merchOrderNo", merchOrderNo);
		map.put("requestNo", requestNo);
		map.put("service", "oneCodePay");
		map.put("partnerId", partnerId);
		map.put("signType", "MD5");
		map.put("version", "1.0");
		map.put("context", "test测试一码付");
		map.put("productInfo", "test测试产品");
		map.put("payeeUserNo", payeeUserNo);
		map.put("userIp", "127.0.0.1");
		
		responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);
		
		AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));
		
		return responseEntity;
		
	}
	
	//充值跳转收银台服务(不用传notifyUrl,异步通知以创建订单为准，线下充值没有异步通知)
	public static JSONObject rechargeRedirect(	String merchOrderNo, String gatewayUrl,
												String partnerId, String securityCheckKey,
												String accessKey, String userNo) {
		
		//定义请求参数map,请求响应体，测试报告实体
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject responseEntity = new JSONObject();
		String requestNo = Ids.getDid(20);
		map.clear();
		map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("operatorId", "1111111111111111");
		map.put("userNo", userNo);
		map.put("merchOrderNo", merchOrderNo);
		//      map.put("payerAccountNo",payerUserNo); 付款人账户
		map.put("recAccountName", "收款方名称");
		map.put("requestNo", requestNo);
		map.put("service", "rechargeRedirect");
		map.put("partnerId", partnerId);
		map.put("signType", "MD5");
		map.put("version", "1.0");
		map.put("context", "test测试充值跳转收银台");
		map.put("userIp", "127.0.0.1");
		
		responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);
		
		AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));
		
		return responseEntity;
		
	}
	
	//交易跳转收银台服务(不用传notifyUrl,异步通知以创建订单为准)
	public static JSONObject tradePayRedirect(	String merchOrderNo, String gatewayUrl,
												String partnerId, String securityCheckKey,
												String accessKey, String payeeUserNo) {
		
		//定义请求参数map,请求响应体，测试报告实体
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject responseEntity = new JSONObject();
		String requestNo = Ids.getDid(20);
		map.clear();
		//        map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		//        map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("merchOrderNo", merchOrderNo);
		map.put("requestNo", requestNo);
		map.put("recAccountName", "收款方名称");
		map.put("service", "tradePayRedirect");
		map.put("partnerId", partnerId);
		map.put("signType", "MD5");
		map.put("version", "1.0");
		map.put("context", "test测试交易跳转收银台");
		
		responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);
		
		AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));
		
		return responseEntity;
		
	}
	
	//转账跳转收银台服务
	public static JSONObject transferAccountRedirect(	String merchOrderNo, String gatewayUrl,
														String partnerId, String securityCheckKey,
														String accessKey, String userNo) {
		
		//定义请求参数map,请求响应体，测试报告实体
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject responseEntity = new JSONObject();
		String requestNo = Ids.getDid(20);
		map.clear();
		map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("merchOrderNo", merchOrderNo);
		map.put("requestNo", requestNo);
		map.put("service", "transferAccountRedirect");
		map.put("partnerId", partnerId);
		map.put("signType", "MD5");
		map.put("version", "1.0");
		map.put("context", "test测试转账跳转收银台服务");
		map.put("userNo", userNo);//付款方用户编码
		
		responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);
		
		AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));
		
		return responseEntity;
		
	}

	public static JSONObject memberQueryBindCard( String gatewayUrl,
                                                  String partnerId, String securityCheckKey,
                                                  String accessKey, String userNo){
        //测试过程
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject responseEntity = new JSONObject();
        String requestNo = Ids.getDid(20);
        String merchOrderNo = Ids.getDid(20);
        map.clear();
        map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
        map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
        map.put("merchOrderNo", merchOrderNo);
        map.put("requestNo", requestNo);
        map.put("service", "queryMemberBankCard");
        map.put("partnerId", partnerId);
        map.put("signType", "MD5");
        map.put("version", "1.0");
        map.put("context", "test测试转账跳转收银台服务");
        map.put("userNo",userNo);
        responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);
        AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));

        return responseEntity;

    }
	
	//提现跳转收银台服务
	public static JSONObject withdrawRedirect(	String merchOrderNo, String gatewayUrl,
												String partnerId, String securityCheckKey,
												String accessKey, String userNo) {
		
		//定义请求参数map,请求响应体，测试报告实体
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject responseEntity = new JSONObject();
		String requestNo = Ids.getDid(20);
		map.clear();
		map.put("notifyUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("returnUrl", "http://29jbqj.natappfree.cc/openApi/testApiNotify");
		map.put("merchOrderNo", merchOrderNo);
		map.put("requestNo", requestNo);
		map.put("service", "withdrawRedirect");
		map.put("partnerId", partnerId);
		map.put("signType", "MD5");
		map.put("version", "1.0");
		map.put("context", "test测试提现跳转收银台服务");
		map.put("userNo", userNo);//提现用户编码
		map.put("recAccountName", "收款方名称");
		
		responseEntity = HttpUtil.httpRequest1(gatewayUrl, map, securityCheckKey, accessKey);
		
		AssertsUtil.assertThan("SUCCESS", responseEntity.get("code"));
		
		return responseEntity;
		
	}
	
	/**
	 * @param time
	 */
	public static void sleepTime(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 以yyyy-MM-dd HH:mm:ss格式化时间
	 *
	 * @param date
	 * @return
	 */
	public static String getDateFormat(Date date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = formatter.format(date);
		
		return formatDate;
	}
	
	/**
	 * MM大写表示月，mm小写表示分钟 大写 HH 意思是二十四小时制，相反，小写hh表示十二小时制 获取对应格式的日期
	 *
	 * @param date   需要获取的日期
	 * @param format 需要的日期格式，如“YYYY-MM-dd HH:mm:ss”
	 */
	public static String getDateFormat(Date date, String format) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String formatDate = formatter.format(date);
		
		return formatDate;
	}
	
	/**
	 * 获取格式yyyy-MM-dd HH:mm:ss任意时间
	 *
	 * @param strDate 如"2012-12-12 12:12:12"
	 */
	public static Date getFormatDate(String strDate) {
		
		Date wannaDate = null;
		if (StringUtils.isBlank(strDate)) {
			return new Date();
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			wannaDate = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return wannaDate;
	}
	
	/**
	 * 字符串转化为指定时间格式
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static Date getFormatStringToDate(String strDate, String format) {
		Date wannaDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			wannaDate = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return wannaDate;
	}
	
	public static Date simpleLongStr2Date(String strDate) {
		Date wannaDate = null;
		try {
			wannaDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return wannaDate;
	}

	public static void insertProfitRule(ProfitprofitEventDao profitprofitEventDao, ProfitprofitSectionDao profitprofitSectionDao,ProfitprofitActionRuleDao profitprofitActionRuleDao,Boolean isDelete,String defaultAccountNo){
		String partnerId = "P000000000000000001";
		ProfitprofitEvent profitprofitEvent = profitprofitEventDao.selectProfitprofitEventByPartnerId(partnerId);
		if (profitprofitEvent==null){
			profitprofitEvent = new ProfitprofitEvent();
			profitprofitEvent.setPartnerId(partnerId);
			profitprofitEvent.setEventType("TRADE_TYPE");
			profitprofitEvent.setEventRoles("TRADE_PAYER|DEFAULT");
//			profitprofitEvent.setDefaultAccountNo("19120317191421320023");
			profitprofitEvent.setDefaultAccountNo(defaultAccountNo);
			profitprofitEvent.setMiddleAccountNo("");
			profitprofitEvent.setDiscount("1.0");
			profitprofitEvent.setState("EFFECTIVE");
			profitprofitEvent.setMemo("测试");
			profitprofitEventDao.insert(profitprofitEvent);
		}
		Long eventId = profitprofitEvent.getId();
		ProfitprofitSection profitprofitSection = profitprofitSectionDao.selectProfitprofitSectionByEventId(eventId);
		if (profitprofitSection == null){
			profitprofitSection = new ProfitprofitSection();
			profitprofitSection.setEventId(eventId.toString());
			profitprofitSection.setSectionName("一不小心搞事情");
			profitprofitSection.setTemplateRule("ALL_TRUE#=#TRUE");
			profitprofitSection.setExprRule("ALL_TRUE=='TRUE'");
			profitprofitSection.setPriority(0);
			profitprofitSection.setMemo("测试");
			profitprofitSectionDao.insert(profitprofitSection);
		}
		Long sectionId = profitprofitSection.getId();
		ProfitprofitActionRule profitprofitActionRule = profitprofitActionRuleDao.selectProfitprofitActionRuleBySectionId(sectionId.toString());

		if (profitprofitActionRule != null){
			Long ruleId = profitprofitActionRule.getId();
			profitprofitActionRuleDao.deleteProfitActionRuleById(ruleId);
		}
		if (isDelete && profitprofitActionRule == null){
			//只进行删除不添加数据
			profitprofitActionRule = new ProfitprofitActionRule();
			profitprofitActionRule.setSectionId(sectionId.toString());
			profitprofitActionRule.setCalType("UNFREEZE_FIXED");
			profitprofitActionRule.setCalRate("100");
			profitprofitActionRule.setPayerRole("TRADE_PAYER");
			profitprofitActionRule.setPayeeRole("DEFAULT");
			profitprofitActionRule.setMemo("测试");
			profitprofitActionRuleDao.insert(profitprofitActionRule);
		}

	}

	public static void main(String[] args) {
		createTrade("19123109144090100420", "", "", "", "",
			"https://open.cartechfin.com/gateway.do", "19102515073200010005",
			"83b95b25056b3dcc49027403a3a2bc1e", "19102515073200010005");

        memberQueryBindCard("https://open.cartechfin.com/gateway.do", "19102515073200010005",
                "83b95b25056b3dcc49027403a3a2bc1e", "19102515073200010005","20021618335109790961");
	}
	
}
