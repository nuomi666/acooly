//package com.jorge.testui.service;
//
//import com.acooly.core.utils.Ids;
//import com.acooly.core.utils.Money;
//import com.cartechfin.cheyunpay.profit.facade.enums.event.ProfitEventTypeEnum;
//import com.cartechfin.cheyunpay.profit.facade.enums.rule.ProfitCalTypeEnum;
//import com.cartechfin.cheyunpay.profit.facade.enums.rule.ProfitRoleEnum;
//import com.jorge.testui.database.member.dao.*;
//import com.jorge.testui.database.member.entity.*;
//import com.jorge.testui.database.paycore.dao.PaycoreactAccountDao;
//import com.jorge.testui.database.paycore.entity.PaycoreactAccount;
//import com.jorge.testui.database.profit.dao.ProfitprofitActionRuleDao;
//import com.jorge.testui.database.profit.dao.ProfitprofitEventDao;
//import com.jorge.testui.database.profit.dao.ProfitprofitSectionDao;
//import com.jorge.testui.database.profit.entity.ProfitprofitActionRule;
//import com.jorge.testui.database.profit.entity.ProfitprofitEvent;
//import com.jorge.testui.database.profit.entity.ProfitprofitSection;
//import com.jorge.testui.database.trade.dao.*;
//import com.jorge.testui.database.trade.entity.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
///**
// * @author zhoudl
// * @email 280932756@qq.com
// * @date 2019-11-28 14:58
// */
//@Slf4j
//@Service
//public class TestInsertUtil {
//
//	@Resource
//	MembermemberDao				membermemberDao;
//
//	@Resource
//	MembermemberAccountDao		membermemberAccountDao;
//
//	@Resource
//	MembermemberBankCardDao		membermemberBankCardDao;
//
//	@Resource
//	MembermemberEnterpriseDao	membermemberEnterpriseDao;
//
//	@Resource
//	MembermemberIndividualDao	membermemberIndividualDao;
//
//	@Resource
//	MembermemberPersonalDao		membermemberPersonalDao;
//
//	@Resource
//	MemberIncomingDataDao		memberIncomingDataDao;
//
//	@Resource
//	MembermemberOpenApplyDao	membermemberOpenApplyDao;
//
//	@Resource
//	MembermemberOpenPaymentDao	membermemberOpenPaymentDao;
//
//	@Resource
//	MembermemberAuthAuditDao	membermemberAuthAuditDao;
//
//	@Resource
//	PaycoreactAccountDao		paycoreactAccountDao;
//
//	@Resource
//	TradetraTradeDao			tradetraTradeDao;
//
//	@Resource
//	TradetraPaymentDao			tradetraPaymentDao;
//
//	@Resource
//	TradetraTradeProfitDao		tradetraTradeProfitDao;
//
//	@Resource
//	TradetraTradeProfitOrderDao	tradetraTradeProfitOrderDao;
//
//	@Resource
//	TradefunFundDao				tradefunFundDao;
//
//	@Resource
//	MemberTwoaccountDao			memberTwoaccountDao;
//
//	@Resource
//	ProfitprofitActionRuleDao	profitprofitActionRuleDao;
//
//	@Resource
//	ProfitprofitEventDao		profitprofitEventDao;
//
//	@Resource
//	ProfitprofitSectionDao		profitprofitSectionDao;
//
//	/**
//	 * 插入member表数据
//	 *
//	 * @param userNo             用户编码
//	 * @param memberType         类型{PERSON:个人,BUSINESS:企业,INDIVIDUAL:个体户,MIDDLE_ACCOUNT:中间账户,OPERATOR:运营商}
//	 * @param memberStatus       状态 {REGISTER:注册,ENABLE:正常,DISABLE:禁用,FREEZE:冻结}
//	 * @param realNameAuth       实名认证{AUTH_NO:未认证,AUTH_ING:认证中,AUTH_OK:已认证,AUTH_FAIL:认证失败,AUTH_OVER:认证过期}
//	 * @param merchantOpenStatus 开户状态{OPEN_NO:未开通,OPEN_OK:开户成功}
//	 * @param partnerId          所属运营商id
//	 */
//	public String insertMember(	String userNo, String memberType, String memberStatus,
//								String realNameAuth, String merchantOpenStatus, String partnerId,
//								String mobile) {
//		Membermember DO = new Membermember();
//		DO.setUserNo(userNo);
//		DO.setMerchUserNo("zdl" + Ids.getDid());
//		if (mobile == null) {
//			if ("BUSINESS".equals(memberType)) {
//				DO.setMobileNo("13800138010");
//				DO.setEmail("test_bussiness@126.com");
//			}
//			if ("PERSON".equals(memberType)) {
//				DO.setMobileNo("13800138011");
//				DO.setEmail("test_person@126.com");
//			}
//			if ("INDIVIDUAL".equals(memberType)) {
//				DO.setMobileNo("13800138012");
//				DO.setEmail("test_individual@126.com");
//			}
//		} else {
//			DO.setMobileNo(mobile);
//			DO.setEmail("test_person@126.com");
//		}
//		DO.setMemberType(memberType);
//		DO.setMemberStatus(memberStatus);
//		DO.setRealNameAuth(realNameAuth);
//		DO.setMobileNoAuth("AUTH_OK");
//		DO.setEmailAuth("AUTH_NO");
//		DO.setMerchantOpenStatus(merchantOpenStatus);
//		DO.setAggregatePayStatus("OPEN_NO");
//		DO.setPosPayStatus("OPEN_NO");
//		DO.setCardPayStatus("OPEN_NO");
//		DO.setOperatorAddStatus("NO");
//		DO.setAgentId("TestAgent11111");
//		DO.setSalesmanId("TestSales1111");
//		DO.setComments("Test");
//		DO.setGid(Ids.gid());
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setBizOrderNo("bon" + Ids.getDid(20));
//		DO.setRegisterClient("PC");
//		DO.setRegisterSource("PAGE");
//		DO.setPartnerId(partnerId);
//		DO.setUserIp("127.0.0.1");
//		membermemberDao.insert(DO);
//		return DO.getMerchUserNo();
//	}
//
//	/**
//	 *
//	 * @param userNo
//	 * @param partnerId
//	 * @param memberType
//	 */
//	public void insertMemberAuthAudit(
//			String userNo,
//			String partnerId,
//			String memberType){
//		MembermemberAuthAudit DO = new MembermemberAuthAudit();
//		DO.setAddress("经营地址");
//		DO.setLegalPersonCertBackPath("http://172.17.100.40:8082/media/2020/03/20/202003201414444413386.jpg");
//		DO.setLegalPersonCertFrontPath("http://172.17.100.40:8082/media/2020/03/20/202003201414401175236.jpg");
//		DO.setCity("重庆");
//		if ("ENABLE".equals(memberType)){
//			DO.setGrade("LV_1");
//		}else {
//			DO.setGrade("NO_GRADE");
//		}
//		DO.setGid(Ids.gid());
//		DO.setProv("重庆");
//		DO.setUploadResultMessage("成功");
//		DO.setLegalPersonMobile("13800138000");
//		DO.setLegalPersonName("周六");
//		DO.setRegisterStatus("success");
//		DO.setLegalPersonCertType("ID");
//		DO.setLegalPersonCertNo("110101199001070798");
//		DO.setDistrict("沙坪坝区");
//		DO.setBankCardType("DEBIT_CARD");
//		DO.setPublicTag("Y");
//		DO.setMemberType(memberType);
//		DO.setContactMobile("18723070001");
//		DO.setValidStatus("VALID_NO");
//		DO.setBizOrderNo(Ids.oid());
//		DO.setMerchOrderNo(Ids.getDid());
//		DO.setUploadStatus("success");
//		DO.setIsBossVerify("NO");
//		DO.setLicencePath("http://172.17.100.40:8086/media/20200320/79e37223-9807-42d4-b680-6181a7abe264.jpg");
//		DO.setPartnerId(partnerId);
//		DO.setBankCode("ICBC");
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		DO.setContactName("周一");
//		DO.setUserNo(userNo);
//		DO.setContactEmail("zhou@126.com");
//		DO.setLicenceNo("911101086669245414");
//		DO.setBankCardNo("6226097551647778");
//		DO.setHoldingEnum("BUSINESS");
//		DO.setBankMobileNo("13800138000");
//		membermemberAuthAuditDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_account表数据
//	 *
//	 * @param userNo      用户编码
//	 * @param accountNo   用户账务号
//	 * @param memberType  类型{PERSON:个人,BUSINESS:企业,INDIVIDUAL:个体户MIDDLE_ACCOUNT:中间账户,OPERATOR:运营商}',
//	 * @param accountType 账务类型{NORMAL:普通账户,ADVANCE:垫付账户,INCOME:收益账户,BAIL:保证金账户,INACCOUNT:入金账户,OUTACCOUNT,出金账户}',
//	 * @param openStatus  账务状态
//	 * @param partnerId   所属运营商id
//	 */
//	public void insertMemberAccount(String userNo, String accountNo, String memberType,
//									String accountType, String openStatus, String partnerId,
//									String bankAccountCoreNo, String bankAccountNo) {
//		MembermemberAccount DO = new MembermemberAccount();
//		DO.setUserNo(userNo);
//		DO.setAccountNo(accountNo);
//		DO.setBankAccountNo(bankAccountNo);//银行账户号
//		DO.setBankAccountCoreNo(bankAccountCoreNo);//渠道二级账户
//		DO.setMemberType(memberType);
//		DO.setAccountType(accountType);
//		DO.setOpenStatus(openStatus);
//		DO.setComments("Test");
//		DO.setBizOrderNo("bon" + Ids.getDid(20));
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setGid(Ids.gid());
//		DO.setPartnerId(partnerId);
//		membermemberAccountDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_bank_code表数据
//	 *
//	 * @param bindNo     绑卡信息
//	 * @param userNo     用户编码
//	 * @param memberType 类型{PERSON:个人,BUSINESS:企业,INDIVIDUAL:个体户,MIDDLE_ACCOUNT:中间账户,OPERATOR:运营商}
//	 * @param bindType   绑卡类型 {STANDARD:标准,ENTRUST:委托，DEDUCT 代扣}
//	 * @param partnerId  所属运营商id
//	 */
//	public void insertMemberBankCard(	String bindNo, String userNo, String memberType,
//										String bindType, String cardStatus, String partnerId) {
//		MembermemberBankCard DO = new MembermemberBankCard();
//		DO.setBindNo(bindNo);
//		DO.setUserNo(userNo);
//		if (memberType.equals("PERSON")) {
//			DO.setMobileNo("18723070004");
//			DO.setRealName("东二");
//			DO.setCertNo("110101199001075695");
//			DO.setBankCardNo("6226097551647780");
//			DO.setBankCode("CMB");
//			DO.setBankCardType("DEBIT_CARD");
//			DO.setPublicTag("N");
//		} else {
//			DO.setMobileNo("18723070000");
//			DO.setRealName("深圳市亿诚电子科技有限公司");
//			DO.setCertNo("911101086669245415");
//			DO.setBankCardNo("6226097551647878");
//			DO.setBankCode("CMB");
//			DO.setBankCardType("DEBIT_CARD");
//			DO.setPublicTag("Y");
//		}
//		DO.setBindType(bindType);
//		if (bindType.equals("STANDARD")) {
//			DO.setIsValidateSms("NO");
//			DO.setPurpose("WITHDRAW");
//			DO.setValidStatus("VALID_NO");
//		} else if (bindType.equals("DEDUCT")) {
//			DO.setIsValidateSms("YES");
//			DO.setPurpose("DEDUCT");
//			DO.setValidStatus("VALID_NO");
//		} else if (bindType.equals("ENTRUST")) {
//			DO.setIsValidateSms("NO");
//			DO.setPurpose("WITHDRAW");
//			DO.setValidStatus("VALID_SUCCESS");
//			DO.setValidMessage("复审通过");
//		}
//		DO.setPartnerId(partnerId);
//		DO.setCardStatus(cardStatus);
//		membermemberBankCardDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_enterprise数据
//	 *
//	 * @param userNo    用户编号
//	 * @param partnerId 运营商ID
//	 */
//	public void insertMemberEnterprise(String userNo, String partnerId) {
//		MembermemberEnterprise DO = new MembermemberEnterprise();
//		DO.setUserNo(userNo);
//		DO.setContactName("云云");
//		DO.setContactMobile("18723070003");
//		DO.setContactEmail("test_enterprise@126.com");
//		DO.setAuthStatus("AUTH_OK");
//		DO.setGrade("LV_1");
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		DO.setLegalPersonName("周一");
//		DO.setLegalPersonMobile("13800138001");
//		DO.setLegalPersonCertType("ID");
//		DO.setLegalPersonCertNo("50010119900125272X");
//		DO.setLegalPersonCertFrontPath(
//			"http://jicheng3.ihunlizhe.net/media/2019/11/12/201911121634071776463.jpg");
//		DO.setLegalPersonCertBackPath(
//			"http://jicheng3.ihunlizhe.net/media/2019/11/12/201911121021293676443.jpg");
//		DO.setLegalPersonGender("FEMALE");
//		DO.setLegalPersonNation("中国");
//		DO.setAddress("address测试");
//		DO.setProv("内蒙古自治区  ");
//		DO.setCity("呼和浩特市");
//		DO.setDistrict("新城区");
//		DO.setLicenceNo("911101086669245415");
//		DO.setLicencePath("http://pic31.nipic.com/20130802/12116339_101826481000_2.jpg");
//		DO.setHoldingEnum("BUSINESS");
//		DO.setValidStatusEnum("VALID_NO");
//		DO.setValidStatus("VALID_SUCCESS");
//		DO.setIsBossVerify("YES");
//		DO.setComments("Test");
//		DO.setGid(Ids.gid());
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setPartnerId(partnerId);
//		membermemberEnterpriseDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_individual表数据
//	 *
//	 * @param userNo
//	 * @param partnerId
//	 */
//	public void insertMemberIndividual(String userNo, String partnerId) {
//		MembermemberIndividual DO = new MembermemberIndividual();
//		DO.setUserNo(userNo);
//		DO.setAuthStatus("AUTH_OK");
//		DO.setGrade("LV_1");
//		DO.setRealName("周二");
//		DO.setMobileNo("13800138002");
//		DO.setGender("MALE");
//		DO.setNation("中国");
//		DO.setCertType("ID");
//		DO.setCertNo("50010119900125272X");
//		DO.setBirthDay("1990-01-25");
//		DO.setCertFront("http://jicheng3.ihunlizhe.net/media/2019/11/08/201911081124318984622.jpg");
//		DO.setCertBack("http://jicheng3.ihunlizhe.net/media/2019/11/08/201911081124372873381.jpg");
//		DO.setProv("内蒙古自治区  ");
//		DO.setCity("呼和浩特市");
//		DO.setDistrict("新城区");
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		DO.setContactName("云云");
//		DO.setContactMobile("18723070002");
//		DO.setIndividualCertificate("911101086669245415");
//		DO.setIndividualCertificatePhoto(
//			"http://pic31.nipic.com/20130802/12116339_101826481000_2.jpg");
//		DO.setValidStatusEnum("VALID_NO");
//		DO.setValidStatus("VALID_SUCCESS");
//		DO.setIsBossVerify("YES");
//		DO.setComments("Test");
//		DO.setGid(Ids.gid());
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setPartnerId(partnerId);
//		membermemberIndividualDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_personal表数据
//	 *
//	 * @param userNo
//	 * @param partnerId
//	 */
//	public void insertMemberPersonal(	String userNo, String partnerId, String realName,
//										String certNo) {
//		MembermemberPersonal DO = new MembermemberPersonal();
//		DO.setUserNo(userNo);
//		if (realName == null) {
//			DO.setRealName("周似");
//		} else {
//			DO.setRealName(realName);
//		}
//		DO.setAuthStatus("AUTH_OK");
//		DO.setGrade("LV_1");
//		DO.setGender("MALE");
//		DO.setNation("中国");
//		DO.setCertType("ID");
//		if (certNo == null) {
//			DO.setCertNo("110101199003217634");
//		} else {
//			DO.setCertNo(certNo);
//		}
//		DO.setBirthProvince("重庆");
//		DO.setCertFront("http://jicheng3.ihunlizhe.net/media/2019/11/08/201911081124318984622.jpg");
//		DO.setCertBack("http://jicheng3.ihunlizhe.net/media/2019/11/08/201911081124372873381.jpg");
//		DO.setBirthDay("1990-01-25");
//		DO.setValidStatusEnum("VALID_NO");
//		DO.setValidStatus("VALID_NO");
//		DO.setIsBossVerify("NO");
//		DO.setComments("Test个人");
//		DO.setGid(Ids.gid());
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setPartnerId(partnerId);
//		membermemberPersonalDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_imcoming_data数据
//	 *
//	 * @param userNo      用户编号
//	 * @param partnerId   运营商ID
//	 * @param memberType  用户类型
//	 * @param auditStatus 进件状态
//	 */
//	public void insertMemberIncomingData(	String userNo, String partnerId, String memberType,
//											String auditStatus) {
//		MemberIncomingData DO = new MemberIncomingData();
//		DO.setUserNo(userNo);
//		DO.setMemberType(memberType);
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		DO.setLegalPersonName("周一");
//		if ("BUSINESS".equals(memberType)) {
//			DO.setShopName("企业商铺名称");
//			DO.setIsHolderLegal("NO");
//			DO.setHoldingCertFrontPath(
//				"http://b-ssl.duitang.com/uploads/item/201311/08/20131108162842_d4L2d.jpeg");
//			DO.setHoldingCertBackPath(
//				"http://b-ssl.duitang.com/uploads/item/201502/14/20150214015646_wxQxy.thumb.700_0.jpeg");
//			DO.setIsBeneficiaryLegal("NO");
//			DO.setBeneficiaryCertFrontPath("http://dmimg.5054399.com/allimg/pkm/pk/17.jpg");
//			DO.setBeneficiaryCertBackPath("http://dmimg.5054399.com/allimg/pkm/pk/13.jpg");
//			DO.setOpenAccountPath("http://dmimg.5054399.com/allimg/pkm/pk/13.jpg");
//		}
//		if ("INDIVIDUAL".equals(memberType)) {
//			DO.setShopName("个体户商铺名称");
//			DO.setBustPhotoBankCard(
//				"http://a0.att.hudong.com/16/12/01300535031999137270128786964.jpg");
//		}
//		DO.setProv("重庆市");
//		DO.setCity("重庆市");
//		DO.setDistrict("沙坪坝区");
//		DO.setShopAddress("烈士墓XXX");
//		DO.setIsOpen("YES");
//		DO.setAuditStatus(auditStatus);
//		DO.setBusinessPlaceIndoorPhoto(
//			"http://pic.rmb.bd.com/f5eee444a99ee3371b12def494d9e1ea.jpeg");
//		DO.setIndividualCertificate("911101086669245415");
//		DO.setIndividualCertificatePhoto(
//			"http://pic31.nipic.com/20130802/12116339_101826481000_2.jpg");
//		DO.setLegalPersonMobile("13800138003");
//		DO.setLegalPersonCertNo("50010119900125272X");
//		DO.setLegalPersonCertFrontPath(
//			"http://jicheng3.ihunlizhe.net/media/2019/11/12/201911121634071776463.jpg");
//		DO.setLegalPersonCertBackPath(
//			"http://jicheng3.ihunlizhe.net/media/2019/11/12/201911121021293676443.jpg");
//		DO.setLegalPersonGender("MALE");
//		DO.setContactName("周五");
//		DO.setContactMobile("18723070001");
//		DO.setContactEmail("test_enterprise@126.com");
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		DO.setShopDoorPhoto(
//			"http://jicheng3.ihunlizhe.net/media/2019/11/12/201911121021293676443.jpg");
//		DO.setGid(Ids.gid());
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setBizOrderNo("biz" + Ids.getDid(20));
//		DO.setPartnerId(partnerId);
//		memberIncomingDataDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_open_apply数据
//	 *
//	 * @param userNo
//	 * @param partnerId
//	 * @param memberType  INDIVIDUAL，BUSINESS
//	 * @param validStatus VALID_ING,VALID_SUCCESS,VALID_FAIL
//	 * @param applyModel  "ATTACH_MODE", "大账户模式"，"STANDARD_MODE", "单独模式"
//	 * @param paymentType
//	 */
//	public void insertMemberOpenApply(	String userNo, String partnerId, String memberType,
//										String validStatus, String applyModel, String paymentType) {
//		MembermemberOpenApply DO = new MembermemberOpenApply();
//		DO.setUserNo(userNo);
//		DO.setMemberType(memberType);
//		DO.setApplyModel(applyModel);
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		DO.setRealName("周一");
//		DO.setPaymentType(paymentType);
//		DO.setIndoorImagePath("http://pic.rmb.bd.com/f5eee444a99ee3371b12def494d9e1ea.jpeg");
//		DO.setOutdoorImagePath(
//			"http://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/838ba61ea8d3fd1fb34857ba314e251f94ca5fe9.jpg");
//		if ("BUSINESS".equals(memberType)) {
//			DO.setHoldCertFrontPath(
//				"http://b-ssl.duitang.com/uploads/item/201311/08/20131108162842_d4L2d.jpeg");
//			DO.setHoldCertBackPath(
//				"http://b-ssl.duitang.com/uploads/item/201502/14/20150214015646_wxQxy.thumb.700_0.jpeg");
//			DO.setBeneficiaryCertFrontPath("http://dmimg.5054399.com/allimg/pkm/pk/17.jpg");
//			DO.setBeneficiaryCertBackPath("http://dmimg.5054399.com/allimg/pkm/pk/13.jpg");
//		}
//		DO.setShopInfo(
//			"{\"shopAddress\":\"comAddress\",\"shopCity\":\"太原市\",\"shopDistrict\":\"迎泽区\",\"shopName\":\"菜鸟驿站\",\"shopProvice\":\"山西省\"}");
//		DO.setValidStatus(validStatus);
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		if ("CARD_PAY".equals(paymentType) || "ONE_CODE_PAY".equals(paymentType)
//			|| "WECHAT_PUBLIC_PAY".equals(paymentType)) {
//			DO.setPublicAppId("111111");
//			DO.setPublicAuthDir("11111111;D:\\zdl\\VPN安装文件及配置说明");
//		}
//		if ("WECHAT_WEB_PAY".equals(paymentType)) {
//			DO.setSmallProgramAppId("111111111111");
//		}
//		if ("WECHAT_APP_PAY".equals(paymentType)) {
//			DO.setWeChatAppId("111111111111");
//		}
//		if ("ALI_APP_PAY".equals(paymentType)) {
//			DO.setZfbAppId("111111111111");
//		}
//		if ("CARD_PAY".equals(paymentType) || "ONE_CODE_PAY".equals(paymentType)
//			|| "ALI_LIFE_PAY".equals(paymentType)) {
//			DO.setZfbLifeAppId("111111111111");
//		}
//		DO.setGid(Ids.gid());
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setBizOrderNo("biz" + Ids.getDid(20));
//		DO.setPartnerId(partnerId);
//		membermemberOpenApplyDao.insert(DO);
//	}
//
//	/**
//	 * 插入member_open_apply数据
//	 *
//	 * @param userNo
//	 * @param partnerId
//	 * @param memberType  INDIVIDUAL，BUSINESS
//	 * @param applyModel  "ATTACH_MODE", "大账户模式"，"STANDARD_MODE", "单独模式"
//	 * @param paymentType
//	 */
//	public void insertMemberOpenPayment(String userNo, String partnerId, String memberType,
//										String applyModel, String paymentType,
//										String parentAccountNo) {
//		MembermemberOpenPayment DO = new MembermemberOpenPayment();
//		DO.setUserNo(userNo);
//		DO.setMemberType(memberType);
//		DO.setApplyModel(applyModel);
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		DO.setRealName("周一");
//		DO.setPaymentType(paymentType);
//		DO.setIndoorImagePath("http://pic.rmb.bd.com/f5eee444a99ee3371b12def494d9e1ea.jpeg");
//		DO.setOutdoorImagePath(
//			"http://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/838ba61ea8d3fd1fb34857ba314e251f94ca5fe9.jpg");
//		if ("BUSINESS".equals(memberType)) {
//			DO.setHoldCertFrontPath(
//				"http://b-ssl.duitang.com/uploads/item/201311/08/20131108162842_d4L2d.jpeg");
//			DO.setHoldCertBackPath(
//				"http://b-ssl.duitang.com/uploads/item/201502/14/20150214015646_wxQxy.thumb.700_0.jpeg");
//			DO.setBeneficiaryCertFrontPath("http://dmimg.5054399.com/allimg/pkm/pk/17.jpg");
//			DO.setBeneficiaryCertBackPath("http://dmimg.5054399.com/allimg/pkm/pk/13.jpg");
//		}
//		DO.setShopInfo(
//			"{\"shopAddress\":\"comAddress\",\"shopCity\":\"太原市\",\"shopDistrict\":\"迎泽区\",\"shopName\":\"菜鸟驿站\",\"shopProvice\":\"山西省\"}");
//		DO.setOpenStatus("enable");
//		DO.setComName("深圳市亿诚电子科技有限公司");
//		if ("CARD_PAY".equals(paymentType) || "ONE_CODE_PAY".equals(paymentType)
//			|| "WECHAT_PUBLIC_PAY".equals(paymentType)) {
//			DO.setPublicAppId("111111");
//			DO.setPublicAuthDir("11111111;D:\\zdl\\VPN安装文件及配置说明");
//		}
//		if ("WECHAT_WEB_PAY".equals(paymentType)) {
//			DO.setSmallProgramAppId("111111111111");
//		}
//		if ("WECHAT_APP_PAY".equals(paymentType)) {
//			DO.setWeChatAppId("111111111111");
//		}
//		if ("ALI_APP_PAY".equals(paymentType)) {
//			DO.setZfbAppId("111111111111");
//		}
//		if ("CARD_PAY".equals(paymentType) || "ONE_CODE_PAY".equals(paymentType)
//			|| "ALI_LIFE_PAY".equals(paymentType)) {
//			DO.setZfbLifeAppId("111111111111");
//		}
//		DO.setParentUserNo(parentAccountNo);
//		DO.setParentAccountNo(parentAccountNo);
//		DO.setGid(Ids.gid());
//		DO.setMerchOrderNo("mor" + Ids.getDid(20));
//		DO.setBizOrderNo("biz" + Ids.getDid(20));
//		DO.setPartnerId(partnerId);
//		membermemberOpenPaymentDao.insert(DO);
//	}
//
//	/**
//	 * 插入paycore系统act_account表数据
//	 *
//	 * @param partnerId   运营商
//	 * @param userNo      会员ID
//	 * @param userName    现在存的是会员表的merchUserNo
//	 * @param accountType 账务类型{NORMAL:普通账户,ADVANCE:垫付账户,INCOME:收益账户,BAIL:保证金账户,INACCOUNT:入金账户,OUTACCOUNT,出金账户}',
//	 * @param accountNo   账户号
//	 * @param balance     余额，包括冻结金额
//	 * @param freeze      冻结金额
//	 */
//	public void insertPaycoreactAccount(String partnerId, String userNo, String userName,
//										String accountType, String accountNo, Money balance,
//										Money freeze) {
//		PaycoreactAccount DO = new PaycoreactAccount();
//		DO.setAccountChannel(null);
//		DO.setAccountNo(accountNo);
//		DO.setFreeze(freeze.getCent());
//		DO.setUserNo(userNo);
//		DO.setStatus("ENABLE");
//		DO.setAccountType(accountType);
//		DO.setBalance(balance.getCent());
//		DO.setPartnerId(partnerId);
//		DO.setUserName(userName);
//		paycoreactAccountDao.insert(DO);
//	}
//
//	/**
//	 * @param userNo       20011409454214830042
//	 * @param memberStatus 状态 {REGISTER:注册,ENABLE:正常,DISABLE:禁用,FREEZE:冻结}
//	 * @param realNameAuth 实名认证{AUTH_NO:未认证,AUTH_ING:认证中,AUTH_OK:已认证,AUTH_FAIL:认证失败,AUTH_OVER:认证过期}
//	 * @param cardStatus   状态 {APPLY:申请,UNACTIVATED:未激活,ENABLE:有效,DISABLE:无效}
//	 * @param bindType     绑卡类型 {STANDARD:标准,ENTRUST:委托,DEDUCT:签约代扣}
//	 */
//	public String initPersonInfo(	String userNo, String memberStatus, String realNameAuth,
//								String cardStatus, String bindType) {
//		//userNo = 20011409454214830042
//		membermemberDao.deleteMembermemberByUserNo(userNo);
//		membermemberAccountDao.deleteMembermemberAccountByUserNo(userNo);
//		membermemberPersonalDao.deleteMembermemberPersonalByUserNo(userNo);
//		membermemberBankCardDao.deleteMembermemberBankCardByUserNo(userNo);
//		membermemberAuthAuditDao.deleteMemberAuthAuditByUserNo(userNo);
//		paycoreactAccountDao.deletePaycoreactAccountByUserNo(userNo);
//		String merchUserNo = insertMember(userNo, "PERSON", memberStatus, realNameAuth, "OPEN_OK",
//			"19092311080520110003", null);
//		insertMemberAuthAudit(userNo,"19092311080520110003","PERSON");
//		if("ENABLE".equals(memberStatus)) {
//			insertMemberAccount(userNo, userNo, "PERSON", "NORMAL", "success", "19092311080520110003",
//					"55006201000074120", "3000001002601351000010");
//			insertMemberAccount(userNo, "20011409454247200006", "PERSON", "INACCOUNT", "success",
//					"19092311080520110003", "55006201000074121", "3000001002627505000010");
//			insertMemberBankCard("O20011409454784780046", userNo, "PERSON", bindType, cardStatus,
//					"19092311080520110003");
//			insertMemberPersonal(userNo, "19092311080520110003", null, null);
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "NORMAL", userNo,
//					new Money(0), new Money(0));
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "INACCOUNT",
//					"20011409454247200006", new Money(0), new Money(0));
//		}
//		return  merchUserNo;
//	}
//
//	/**
//	 * @param userNo        20011409454214830042
//	 * @param memberStatus  状态 {REGISTER:注册,ENABLE:正常,DISABLE:禁用,FREEZE:冻结}
//	 * @param realNameAuth  实名认证{AUTH_NO:未认证,AUTH_ING:认证中,AUTH_OK:已认证,AUTH_FAIL:认证失败,AUTH_OVER:认证过期}
//	 * @param cardStatus    状态 {APPLY:申请,UNACTIVATED:未激活,ENABLE:有效,DISABLE:无效}
//	 * @param bindType      绑卡类型 {STANDARD:标准,ENTRUST:委托,DEDUCT:签约代扣}
//	 * @param mobile        电话号码
//	 * @param realName      真实名字
//	 * @param certNo        身份证信息
//	 */
//	public String initPersonInfoRealNameAndAccountNo(	String userNo, String memberStatus,
//													String realNameAuth, String cardStatus,
//													String bindType, String mobile, String realName,
//													String certNo, String accountNo,
//													String bindNo) {
//		//        userNo = 20011409454214830042
//		//        membermemberDao.deleteMembermemberByUserNo(userNo);
//		//        membermemberAccountDao.deleteMembermemberAccountByUserNo(userNo);
//		//        membermemberPersonalDao.deleteMembermemberPersonalByUserNo(userNo);
//		//        membermemberBankCardDao.deleteMembermemberBankCardByUserNo(userNo);
//		//		  membermemberAuthAuditDao.deleteMemberAuthAuditByUserNo(userNo);
//		//        paycoreactAccountDao.deletePaycoreactAccountByUserNo(userNo);
//
//
//		String merchUserNo = insertMember(userNo, "PERSON", memberStatus, realNameAuth, "OPEN_OK",
//			"19092311080520110003", mobile);
//		insertMemberAuthAudit(userNo,"19092311080520110003","PERSON");
//		if("ENABLE".equals(memberStatus)) {
//			insertMemberAccount(userNo, userNo, "PERSON", "NORMAL", "success", "19092311080520110003",
//					"55006201000074120", "3000001002601351000010");
//			insertMemberAccount(userNo, accountNo, "PERSON", "INACCOUNT", "success",
//					"19092311080520110003", "55006201000074121", "3000001002627505000010");
//			insertMemberBankCard(bindNo, userNo, "PERSON", bindType, cardStatus,
//					"19092311080520110003");
//			insertMemberPersonal(userNo, "19092311080520110003", realName, certNo);
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "NORMAL", userNo,
//					new Money(0), new Money(0));
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "INACCOUNT", accountNo,
//					new Money(0), new Money(0));
//		}
//		return merchUserNo;
//	}
//
//	/**
//	 * @param userNo        20011409454214830042
//	 * @param memberStatus  状态 {REGISTER:注册,ENABLE:正常,DISABLE:禁用,FREEZE:冻结}
//	 * @param realNameAuth  实名认证{AUTH_NO:未认证,AUTH_ING:认证中,AUTH_OK:已认证,AUTH_FAIL:认证失败,AUTH_OVER:认证过期}
//	 * @param cardStatus    状态 {APPLY:申请,UNACTIVATED:未激活,ENABLE:有效,DISABLE:无效}
//	 * @param bindType      绑卡类型 {STANDARD:标准,ENTRUST:委托,DEDUCT:签约代扣}
//	 * @param mobile        电话号码
//	 * @param realName      真实名字
//	 * @param certNo        身份证信息
//	 */
//	public String initPersonInfoRealName(	String userNo, String memberStatus, String realNameAuth,
//										String cardStatus, String bindType, String mobile,
//										String realName, String certNo) {
//		//        userNo = 20011409454214830042
//		membermemberDao.deleteMembermemberByUserNo(userNo);
//		membermemberAccountDao.deleteMembermemberAccountByUserNo(userNo);
//		membermemberPersonalDao.deleteMembermemberPersonalByUserNo(userNo);
//		membermemberBankCardDao.deleteMembermemberBankCardByUserNo(userNo);
//		membermemberAuthAuditDao.deleteMemberAuthAuditByUserNo(userNo);
//		paycoreactAccountDao.deletePaycoreactAccountByUserNo(userNo);
//
//		String merchUserNo = insertMember(userNo, "PERSON", memberStatus, realNameAuth, "OPEN_OK",
//			"19092311080520110003", mobile);
//		insertMemberAuthAudit(userNo,"19092311080520110003","PERSON");
//		if("ENABLE".equals(memberStatus)) {
//			insertMemberAccount(userNo, userNo, "PERSON", "NORMAL", "success", "19092311080520110003",
//					"55006201000074120", "3000001002601351000010");
//			insertMemberAccount(userNo, "20011409454247200006", "PERSON", "INACCOUNT", "success",
//					"19092311080520110003", "55006201000074121", "3000001002627505000010");
//			insertMemberBankCard("O20011409454784780046", userNo, "PERSON", bindType, cardStatus,
//					"19092311080520110003");
//			insertMemberPersonal(userNo, "19092311080520110003", realName, certNo);
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "NORMAL", userNo,
//					new Money(0), new Money(0));
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "INACCOUNT",
//					"20011409454247200006", new Money(0), new Money(0));
//		}
//		return merchUserNo;
//	}
//
//	/**
//	 * @param userNo       1912241446101CBC00014
//	 * @param memberStatus 状态 {REGISTER:注册,ENABLE:正常,DISABLE:禁用,FREEZE:冻结}
//	 * @param realNameAuth 实名认证{AUTH_NO:未认证,AUTH_ING:认证中,AUTH_OK:已认证,AUTH_FAIL:认证失败,AUTH_OVER:认证过期}
//	 * @param cardStatus   状态 {APPLY:申请,UNACTIVATED:未激活,ENABLE:有效,DISABLE:无效}
//	 * @param bindType     绑卡类型 {STANDARD:标准,ENTRUST:委托,DEDUCT:签约代扣}
//	 */
//	public String initEnterpiseInfo(	String userNo, String memberStatus, String realNameAuth,
//									String cardStatus, String bindType) {
//		//userNo=1912241446101CBC00014
//		membermemberDao.deleteMembermemberByUserNo(userNo);
//		membermemberAccountDao.deleteMembermemberAccountByUserNo(userNo);
//		membermemberEnterpriseDao.deleteMemberEnterpriseByUserNo(userNo);
//		membermemberBankCardDao.deleteMembermemberBankCardByUserNo(userNo);
//		membermemberAuthAuditDao.deleteMemberAuthAuditByUserNo(userNo);
//		paycoreactAccountDao.deletePaycoreactAccountByUserNo(userNo);
//		String merchUserNo = insertMember(userNo, "BUSINESS", memberStatus, realNameAuth, "OPEN_OK",
//			"19092311080520110003", null);
//		insertMemberAuthAudit(userNo,"19092311080520110003","BUSINESS");
//		if("ENABLE".equals(memberStatus)) {
//			insertMemberAccount(userNo, userNo, "BUSINESS", "NORMAL", "success", "19092311080520110003",
//					"55006201000060505", "3008001002621013000010");
//			insertMemberAccount(userNo, "19122414461008520007", "BUSINESS", "INACCOUNT", "success",
//					"19092311080520110003", "55006201000060506", "3008001002586851000010");
//			insertMemberBankCard("O1912241446521CBC00018", userNo, "BUSINESS", bindType, cardStatus,
//					"19092311080520110003");
//			insertMemberEnterprise(userNo, "19092311080520110003");
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "NORMAL", userNo,
//					new Money(0), new Money(0));
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "INACCOUNT",
//					"19122414461008520007", new Money(0), new Money(0));
//		}
//		return merchUserNo;
//	}
//
//	/**
//	 * @param userNo       1912230937254F4800001
//	 * @param memberStatus 状态 {REGISTER:注册,ENABLE:正常,DISABLE:禁用,FREEZE:冻结}
//	 * @param realNameAuth 实名认证{AUTH_NO:未认证,AUTH_ING:认证中,AUTH_OK:已认证,AUTH_FAIL:认证失败,AUTH_OVER:认证过期}
//	 * @param cardStatus   状态 {APPLY:申请,UNACTIVATED:未激活,ENABLE:有效,DISABLE:无效}
//	 * @param bindType     绑卡类型 {STANDARD:标准,ENTRUST:委托,DEDUCT:签约代扣}
//	 */
//	public String initIndividualInfo(	String userNo, String memberStatus, String realNameAuth,
//									String cardStatus, String bindType) {
//		//userNo=1912230937254F4800001
//		membermemberDao.deleteMembermemberByUserNo(userNo);
//		membermemberAccountDao.deleteMembermemberAccountByUserNo(userNo);
//		membermemberIndividualDao.deleteMemberIndividualByUserNo(userNo);
//		membermemberBankCardDao.deleteMembermemberBankCardByUserNo(userNo);
//		membermemberAuthAuditDao.deleteMemberAuthAuditByUserNo(userNo);
//		paycoreactAccountDao.deletePaycoreactAccountByUserNo(userNo);
//		String merchUserNo = insertMember(userNo, "INDIVIDUAL", memberStatus, realNameAuth, "OPEN_OK",
//			"19092311080520110003", null);
//		insertMemberAuthAudit(userNo,"19092311080520110003","INDIVIDUAL");
//		if("ENABLE".equals(memberStatus)) {
//			insertMemberAccount(userNo, userNo, "INDIVIDUAL", "NORMAL", "success",
//					"19092311080520110003", "55006201000060107", "3008001002620262000010");
//			insertMemberAccount(userNo, "19122309372642520002", "INDIVIDUAL", "INACCOUNT", "success",
//					"19092311080520110003", "55006201000060108", "3008001002620295000010");
//			insertMemberBankCard("O1912230941104F4800011", userNo, "INDIVIDUAL", bindType, cardStatus,
//					"19092311080520110003");
//			insertMemberIndividual(userNo, "19092311080520110003");
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "NORMAL", userNo,
//					new Money(0), new Money(0));
//			insertPaycoreactAccount("19092311080520110003", userNo, merchUserNo, "INACCOUNT",
//					"19122309372642520002", new Money(0), new Money(0));
//		}
//		return merchUserNo;
//	}
//
//	public void initOpenPayment(String userNo, String paymentType) {
//		String[] paymentTypes = paymentType.split("\\|");
//		for (String payment : paymentTypes) {
//			membermemberOpenApplyDao.deleteMemberOpenApplyByUserNoAndPaymentType(userNo, payment);
//			insertMemberOpenApply(userNo, "19092311080520110003", "BUSINESS", "VALID_SUCCESS",
//				"STANDARD_MODE", payment);
//			membermemberOpenPaymentDao.deleteMemberOpenPaymentByUserNoAndPaymentType(userNo,
//				payment);
//			insertMemberOpenPayment(userNo, "19092311080520110003", "BUSINESS", "STANDARD_MODE",
//				payment, userNo);
//		}
//	}
//
//	public void initIncomingData(	String userNo, String partnerId, String memberType,
//									String auditStatus) {
//		memberIncomingDataDao.deleteMemberIncomingDataByUserNo(userNo);
//		insertMemberIncomingData(userNo, partnerId, memberType, auditStatus);
//	}
//
//	/**
//	 * 插入tra_trade表数据
//	 * @param gid
//	 * @param merchOrderNo
//	 * @param tradeNo
//	 * @param type 支付方式：BALANCE_PAY，WECHAT_APP_PAY，ALI_ZHU_SCAN_PAY等
//	 * @param status   状态：INIT，PROCESSING，SUCCESS，FAIL
//	 * @param profitType 清分类型：MANUAL-手动,AUTO-自动
//	 * @param profitStatus 清分状态：CLEAR_INIT-未清分,NO_CLEAR-无清分,CLEAR_SUCCESS-清分成功,CLEAR_FAIL-清分失败,CLEAR_FROZEN-清分已冻结}
//	 * @param reconStatus 对账状态：RECON_INIT-未对账,NO_RECON-无对账,RECON_SUCCESS-对账成功,RECON_FAIL-对账失败}
//	 * @param clearStatus 清分状态： CLEAR_INIT，CLEAR_SUCCESS，CLEAR_SYNCH
//	 */
//	public void insertTraTrade(	String gid, String merchOrderNo, String tradeNo, String type,
//								String status, String profitType, String profitStatus,
//								String reconStatus, String clearStatus) {
//		TradetraTrade tradetraTrade = new TradetraTrade();
//		tradetraTrade.setPayOrderNo(tradeNo);
//		tradetraTrade.setAmount(1000l);
//		tradetraTrade.setClearAmount(10l);
//		tradetraTrade.setTradeNo(tradeNo);
//		tradetraTrade.setMerchOrderNo(merchOrderNo);
//		tradetraTrade.setFinishTime(new Date());
//		tradetraTrade.setGid(gid);
//		tradetraTrade.setTradeTime(new Date());
//		tradetraTrade.setBankFee(0l);
//		tradetraTrade.setPlatformType("OPENAPI");
//		tradetraTrade.setMacAddress("255.255.255.0");
//		tradetraTrade.setRefundAmount(0l);
//		tradetraTrade.setType(type);
//		tradetraTrade.setBuyerUserNo("19092311160674110075");
//		tradetraTrade.setMemo("结果备注");
//		tradetraTrade.setProfitType(profitType);
//		tradetraTrade.setReconStatus(reconStatus);
//		tradetraTrade.setNotifyGid(gid);
//		tradetraTrade.setTradeMemo("交易备注");
//		tradetraTrade.setPayerUserName("test");
//		tradetraTrade.setProfitStatus(profitStatus);
//		tradetraTrade.setStatus(status);
//		tradetraTrade.setPartnerId("19092311080520110003");
//		tradetraTrade.setPayeeUserNo("19092311100076110018");
//		tradetraTrade.setTradeName("交易名称");
//		tradetraTrade.setClearStatus(clearStatus);
//		tradetraTrade.setProfitAmount(0l);
//		tradetraTrade.setTradeSource("ATOMIC_POWER");
//		tradetraTrade.setPayerUserNo("19092311160674110075");
//		tradetraTrade.setSellerUserNo("19092311100076110018");
//		tradetraTrade.setPayerAccountNo("19092311160674110075");
//		tradetraTrade.setRealPayeeUserNo("19092311100076110018");
//		tradetraTrade.setRealPayeeAccountNo("19092311100076110018");
//		tradetraTrade.setRefundFeeAmount(0l);
//		tradetraTrade.setRefundBankFeeAmount(0l);
//		tradetraTrade.setServiceBankType("CHINAUMS");
//		tradetraTrade.setClearFinishTime(new Date());
//		tradetraTrade.setRealPayeeUserName("test");
//		tradetraTrade.setPayeeAccountNo("19092311100076110018");
//		tradetraTradeDao.insert(tradetraTrade);
//	}
//
//	/**
//	 * 插入tra_payment表数据
//	 * @param gid
//	 * @param tradeNo
//	 * @param merchOrderNo
//	 * @param type 支付方式：BALANCE_PAY，WECHAT_APP_PAY，ALI_ZHU_SCAN_PAY等
//	 * @param status 状态：INIT，PROCESSING，SUCCESS，FAIL
//	 * @param reconStatus 对账状态：RECON_INIT-未对账,NO_RECON-无对账,RECON_SUCCESS-对账成功,RECON_FAIL-对账失败}
//	 * @param flowNode 执行节点 PAYMENT-收单,REPAIR_FEES-填补手续费，SPLIT_ACCOUNT-结算分账(转冻结码),TRADE_FEE-交易收费，TRADE_PROFIT-交易清分
//	 *                 CHARGE-收费，FUND_DEPOSIT-充值，FUND_WITHDRAW-提现，TRADE_TRANSFER-交易转账，
//	 *                 REFUND-支付退款，REFUND_RECON-支付退款对账，REFUND_REPAIR_FEES-回退填补手续费，
//	 *                 REFUND_TRADE_FEE-回退交易收费，REFUND_BALANCEPAY-支付退款（余额支付）,REFUND_BALANCEPAY_PRO-支付退款（余额支付），
//	 *                 REFUND_BALANCEPAY_TRADE_FEE-回退交易收费（余额支付）,CANCEL-支付撤销
//	 */
//	public void insertTraPayment(	String gid, String merchOrderNo, String tradeNo, String type,
//									String status, String reconStatus, String flowNode) {
//		TradetraPayment tradetraPayment = new TradetraPayment();
//		tradetraPayment.setPayeeUserNo("19092311100076110018");
//		tradetraPayment.setGid(gid);
//		tradetraPayment.setMerchOrderNo(merchOrderNo);
//		tradetraPayment.setReconStatus(reconStatus);
//		tradetraPayment.setTradeNo(tradeNo);
//		tradetraPayment.setPayOrderNo(tradeNo);
//		tradetraPayment.setType(type);
//		tradetraPayment.setPartnerId("19092311080520110003");
//		tradetraPayment.setMemo("结果备注");
//		tradetraPayment.setAmount(1000l);
//		tradetraPayment.setBankFee(0);
//		tradetraPayment.setFlowNode(flowNode);
//		tradetraPayment.setStatus(status);
//		tradetraPayment.setPayerUserNo("19101814151226110005");
//		tradetraPayment.setTradeMemo("交易订单");
//		tradetraPayment.setRealPayeeAccountNo("19092311100076110018");
//		tradetraPayment.setServiceBankType("FBANK");
//		tradetraPayment.setPayeeAccountNo("19092311100076110018");
//		tradetraPayment.setPayerAccountNo("19092311160674110075");
//		tradetraPayment.setRealPayeeUserNo("19092311100076110018");
//		tradetraPaymentDao.insert(tradetraPayment);
//	}
//
//	/**
//	 * 插入tra_trade_profit数据
//	 * @param gid
//	 * @param merchOrderNo
//	 * @param tradeNo
//	 * @param status 状态{PROCESSING:交易中,SUCCESS:交易成功,FAIL:交易失败}
//	 * @param profitType 清分类型{MANUAL:手动,AUTO:自动}
//	 * @param chargeType 收费类型{CHARGE:清分,PROFIT:分润}
//	 */
//	public void insertTradetraTradeProfit(	String gid, String merchOrderNo, String tradeNo,
//											String status, String profitType, String chargeType) {
//		TradetraTradeProfit tradetraTradeProfit = new TradetraTradeProfit();
//		tradetraTradeProfit.setChargeType(chargeType);
//		tradetraTradeProfit.setGid(gid);
//		tradetraTradeProfit.setMerchOrderNo(merchOrderNo);
//		tradetraTradeProfit.setPayerUserNo("19092311100076110018");
//		tradetraTradeProfit.setPartnerId("19092311080520110003");
//		tradetraTradeProfit.setPayOrderNo(tradeNo);
//		tradetraTradeProfit.setStatus(status);
//		tradetraTradeProfit.setAmount(1000l);
//		tradetraTradeProfit.setTradeNo(tradeNo);
//		tradetraTradeProfit.setProfitType(profitType);
//		tradetraTradeProfit.setProfitMerchOrderNo(merchOrderNo);
//		tradetraTradeProfit.setPayerAccountNo("19092311100076110018");
//		tradetraTradeProfitDao.insert(tradetraTradeProfit);
//	}
//
//	/**
//	 *
//	 * @param gid
//	 * @param merchOrderNo
//	 * @param tradeNo
//	 * @param chargeType
//	 * @param status
//	 * @param profitType
//	 */
//	public void insertTradetraTradeProfitOrder(	String gid, String merchOrderNo, String tradeNo,
//												String chargeType, String status,
//												String profitType) {
//		TradetraTradeProfitOrder tradetraTradeProfitOrder = new TradetraTradeProfitOrder();
//		tradetraTradeProfitOrder.setPayerAccountNo("19092311100076110018");
//		tradetraTradeProfitOrder.setProfitMerchOrderNo(Ids.getDid());
//		tradetraTradeProfitOrder.setPayeeAccountNo("19092311124346110039");
//		tradetraTradeProfitOrder.setMerchOrderNo(merchOrderNo);
//		tradetraTradeProfitOrder.setPayOrderNo(Ids.getDid());
//		tradetraTradeProfitOrder.setChargeType(chargeType);
//		tradetraTradeProfitOrder.setAmount(1000l);
//		tradetraTradeProfitOrder.setStatus(status);
//		tradetraTradeProfitOrder.setPartnerId("19092311080520110003");
//		tradetraTradeProfitOrder.setGid(gid);
//		tradetraTradeProfitOrder.setProfitType(profitType);
//		tradetraTradeProfitOrder.setTradeNo(tradeNo);
//		tradetraTradeProfitOrder.setPayerUserNo("19092311100076110018");
//		tradetraTradeProfitOrder.setPayeeUserNo("19092311124346110039");
//		tradetraTradeProfitOrderDao.insert(tradetraTradeProfitOrder);
//	}
//
//	/**
//	 * 插入fun_fund的数据
//	 * @param gid
//	 * @param merchOrderNo
//	 * @param tradeNo
//	 * @param payOrderNo
//	 * @param type
//	 * @param status
//	 * @param isCharge
//	 */
//	public void insertTradefunFund(	String gid, String merchOrderNo, String tradeNo,
//									String payOrderNo, String type, String status,
//									String isCharge) {
//		TradefunFund tradefunFund = new TradefunFund();
//		tradefunFund.setUserNo("19092311160674110075");
//		tradefunFund.setActualAmount(999l);
//		tradefunFund.setBindNo("o19092311160604110083");
//		tradefunFund.setPlatformType("OPENAPI");
//		tradefunFund.setUserName("test8");
//		tradefunFund.setMobileNo("13800138000");
//		tradefunFund.setChargeAmount(1l);
//		tradefunFund.setTradeNo(tradeNo);
//		tradefunFund.setBankCnapsNo("0000000000");
//		tradefunFund.setPublicTag("ALL");
//		tradefunFund.setFinishTime(new Date());
//		tradefunFund.setBankCardNo("65280100000000000000");
//		tradefunFund.setIsCharge(isCharge);
//		tradefunFund.setBankName("建设银行");
//		tradefunFund.setStatus(status);
//		tradefunFund.setBankRealName("test");
//		tradefunFund.setTradeMemo("交易备注");
//		tradefunFund.setRealName("test");
//		tradefunFund.setBankCode("IBCB");
//		tradefunFund.setMemo("memo备注");
//		tradefunFund.setBalance(0l);
//		tradefunFund.setPartnerId("19092311080520110003");
//		tradefunFund.setBankCardType("ALL");
//		tradefunFund.setTradeTime(new Date());
//		tradefunFund.setType(type);
//		tradefunFund.setGid(gid);
//		tradefunFund.setAmount(1000l);
//		tradefunFund.setMerchOrderNo(merchOrderNo);
//		tradefunFund.setPayOrderNo(payOrderNo);
//		tradefunFund.setAccountNo("19110811224716210009");
//		tradefunFund.setActualChargeAmount(1);
//		tradefunFund.setChargePayeeUserNo("19092311124346110039");
//		tradefunFund.setChargePayerUserNo("19092311160674110075");
//		tradefunFundDao.insert(tradefunFund);
//	}
//
//	public void initProfitDataSyn(	String gid, String merchOrderNo, String tradeNo, String type,
//									String status, String profitType, String profitStatus,
//									String reconStatus, String clearStatus, String chargeType) {
//		tradetraTradeDao.deleteTraTradeByMerchOrderNo(merchOrderNo);
//		insertTraTrade(gid, merchOrderNo, tradeNo, type, status, profitType, profitStatus,
//			reconStatus, clearStatus);
//		tradetraTradeProfitDao.deleteTradetraTradeProfitByMerchOrderNo(merchOrderNo);
//		insertTradetraTradeProfit(gid, merchOrderNo, tradeNo, profitStatus, profitType, chargeType);
//		tradetraTradeProfitOrderDao.deleteTradetraTradeProfitOrderByMerchOrderNo(merchOrderNo);
//		insertTradetraTradeProfitOrder(gid, merchOrderNo, tradeNo, chargeType, profitStatus,
//			profitType);
//	}
//
//	public void initTradeDataSyn(	String gid, String merchOrderNo, String tradeNo, String type,
//									String status, String profitType, String profitStatus,
//									String reconStatus, String clearStatus, String chargeType) {
//		tradetraTradeDao.deleteTraTradeByMerchOrderNo(merchOrderNo);
//		insertTraTrade(gid, merchOrderNo, tradeNo, type, status, profitType, profitStatus,
//			reconStatus, clearStatus);
//		tradetraTradeProfitOrderDao.deleteTradetraTradeProfitOrderByMerchOrderNo(merchOrderNo);
//		insertTradetraTradeProfitOrder(gid, merchOrderNo, tradeNo, chargeType, profitStatus,
//			profitType);
//	}
//
//	public void initFundDataSyn(String gid, String merchOrderNo, String tradeNo, String payOrderNo,
//								String type, String status, String isCharge) {
//		tradefunFundDao.deleteTradefunFundByMerchOrderNo(merchOrderNo);
//		insertTradefunFund(gid, merchOrderNo, tradeNo, payOrderNo, type, status, isCharge);
//	}
//
//	/**
//	 * 添加收费规则
//     * @param partnerId 可指定商户号生效
//     * @param defaultAccountNo 收费收款账号
//     * @param profitEventTypeEnum 收费事件类型
//     * @param payerRole 收费角色
//     * @param profitCalTypeEnum 收费方式
//     * @param rateAmount 收费金额（固定金额时单位为分）
//     */
//	public void insertProfitRules(String partnerId, String defaultAccountNo, ProfitEventTypeEnum profitEventTypeEnum,
//									ProfitRoleEnum payerRole, ProfitCalTypeEnum profitCalTypeEnum,
//                                  String rateAmount) {
//		deleteProfitRules();
//
//		ProfitprofitEvent profitprofitEvent = new ProfitprofitEvent();
//		profitprofitEvent.setPartnerId(partnerId);
//		profitprofitEvent.setEventType(profitEventTypeEnum.code());
//		profitprofitEvent.setEventRoles("TRADE_ACTOR|TRADE_PAYER|DEFAULT");
//		//			profitprofitEvent.setDefaultAccountNo("19120317191421320023");
//		profitprofitEvent.setDefaultAccountNo(defaultAccountNo);
//		profitprofitEvent.setMiddleAccountNo("");
//		profitprofitEvent.setDiscount("1.0");
//		profitprofitEvent.setState("EFFECTIVE");
//		profitprofitEvent.setMemo("测试");
//		profitprofitEventDao.insert(profitprofitEvent);
//
//		ProfitprofitSection profitprofitSection = new ProfitprofitSection();
//		profitprofitSection.setEventId(profitprofitEvent.getId().toString());
//		profitprofitSection.setSectionName("一不小心搞事情");
//		profitprofitSection.setTemplateRule("ALL_TRUE#=#TRUE");
//		profitprofitSection.setExprRule("ALL_TRUE=='TRUE'");
//		profitprofitSection.setPriority(0);
//		profitprofitSection.setMemo("测试");
//		profitprofitSectionDao.insert(profitprofitSection);
//
//		ProfitprofitActionRule profitprofitActionRule = new ProfitprofitActionRule();
//		profitprofitActionRule.setSectionId(profitprofitSection.getId().toString());
//		profitprofitActionRule.setCalType(profitCalTypeEnum.code());
//		profitprofitActionRule.setCalRate(rateAmount);
//		profitprofitActionRule.setPayerRole(payerRole.code());
//		profitprofitActionRule.setPayeeRole("DEFAULT");
//		profitprofitActionRule.setMemo("测试");
//		profitprofitActionRuleDao.insert(profitprofitActionRule);
//
//	}
//
//	/**
//	 * 删除清分规则
//	 */
//	public void deleteProfitRules() {
//		profitprofitActionRuleDao.deleteProfitActionRuleByAll();
//		profitprofitEventDao.deleteProfitprofitEventByAll();
//		profitprofitSectionDao.deleteProfitprofitSectionByAll();
//	}
//
//
//
//	public static void main(String[] args) {
//		int i = 4;
//		String a = "a";
//		if (i == 4) {
//			System.out.println("aaaaaaa");
//			a = "b";
//		} else if (i == 3) {
//			System.out.println("bbbbbbb");
//			a = "c";
//		} else {
//			a = "d";
//			System.out.println("cccccc");
//		}
//	}
//}
