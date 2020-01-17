package com.example.demo.boot.restful;

/**
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @author kwah
 * @date 2018/4/19 09:42
 */
public enum ResCode {

	SUCCESS(200,"成功"),
	TOKENCREATEFAIL(300,"生成token失败"),
	TOKENCREATEZCFAIL(301,"生成token失败,没有注册服务"),
	REFRESHTOKENFAIL(302,"刷新token失败"),
	FAIL(400,"失败"),
	UNAUTHORIZED(401,"未认证（签名错误）"),
	UNAUTHEN(4401,"未登录"),
	UNAUTHZ(4403,"未授权，拒绝访问"),
	REQUESTTIMEOUT(407,"请求超时，被降级处理"),
	INTERNAL_SERVER_ERROR(500,"服务器内部错误"),


	PARAMS_VALID_ERROR(601,"参数请求错误"),
	USER_EXITS(602,"手机号已被注册"),
	NOT_REGIN_USER(603,"用户未注册"),
	PWD_ERROR(604,"密码错误"),
	CODE_EXPIRED(605,"验证码过期"),
	CODE_ERROR(606,"验证码错误"),
	INVITATION_CODE_ERROR(607,"邀请码错误"),
	PAY_PWD_ERROR(609,"原支付密码错误"),
	LIKES_ERROR(611,"您已经点过赞了"),
	MATERIAL_ERR(612,"添加素材失败"),
	DELETE_ERR(613,"删除素材失败"),
	MATERIAL_LIST_ERR(614,"素材库查询失败"),
	BANK_CARD_MAX(615,"银行卡添加达到上限"),
	ADD_PRODCUT_ERROR(616,"添加商品失败"),
	VERIFIED_EXITS(617,"已提交实名认证"),
	NOT_VERIFIED(618,"未查询到实名认证信息"),
	NOT_USER_INFO(619,"无此账号信息"),
	UDP_PWD_ERROR(620,"修改密码失败"),
	ADD_CONTRACT_ERROR(621,"上传合同失败"),
	CONTRACT_NO_ERROR(622,"合同编号已存在"),
	CONTRACT_LIST_ERROR(623,"查询合同列表失败"),
	DELETE_CONTRACT_ERROR(624,"删除合同失败"),
	UPD_PAY_PWD_ERROR(610,"修改支付密码失败"),
	MSG_SEND_ERROR(611,"消息已发送5分钟后内有效"),
	PAY_TX_PWD_ERROR(612,"支付密码错误"),
	DELETE_CURR_TITLE_ERROR(613,"删除课题失败"),
	DISABLE_USER(614,"用户已禁用"),

	ADD_PA_ERROR(650,"添加商品轮播图失败"),
	ADD_PSV_ERROR(651,"添加规格值失败"),
	ADD_PSN_ERROR(652,"添加规格名失败"),
	ADD_PSA_ERROR(653,"添加商品的规格失败"),
	UPD_PSA_ERROR(658,"修改商品的规格失败"),
	ADD_PSS_ERROR(654,"添加商品的佣金失败"),
	UPD_PSS_ERROR(659,"修改商品的佣金失败"),
	ADD_PAI_ERROR(655,"添加商品的预约信息失败"),
	UPD_PRODCUT_ERROR(657,"添加商品的预约信息失败"),
	FIND_PSV_ERROR(656,"没有获取到对应的规格值"),
	ARGUMENTS_ERROR(660,"参数异常"),
	UPD_PAC_ERROR(661,"更新商品配置信息失败"),
	FIND_P_ERROR(662,"商品不存在"),
	ADD_PC_ERROR(663,"新增商品规格失败"),
	DEL_PC_ERROR(664,"删除商品分类失败"),
	DEL_PS_ERROR(664,"删除规格失败"),
	UPD_PS_ERROR(665,"启用/停用规格失败"),
	FIND_PSA_ERROR(666,"获取商品规格失败"),
	DEL_P_ERROR(667,"删除商品失败"),
	UPD_P_UP_DOWN_ERROR(668,"操作失败"),
	UPD_P_UP_DOWN_TOTAL_ERROR(669,"该商家上架的数量超过限制"),
	ADD_PAA_SOLE_UP(670,"该商品延迟下架时间最多7天"),
	ADD_PAA_STOCK_ERROR(671,"已提交过添加库存申请，不能再次申请"),
	ADD_PAA_SOLE_UP_ERROR(672,"已提交过延时下架申请，不能再次申请"),
	ADD_PAA_STOCK_TOTAL_ERROR(673,"增加的库存量为0,提交审核失败"),
	ADD_PAU_ERROR(674,"您已提交审核,正在审核中"),
	UPD_UP_ERROR(675,"商品上架失败,该商品不是待上架"),
	UPD_UP_TOTAL_ERROR(676,"商品上架失败,一个商家最多5个处于出售中"),
	UPD_SOLE_OUT_ERROR(677,"商品下架失败,该商品不是再售商品"),
	DEL_PT_ERROR(678,"删除商品任务记录错误"),
	DEL_P_STOCK_ERROR(679,"更新商品库存错误"),
	FIND_PSA_NULL_ERROR(680,"该商品规格不存在"),
	UPD_PSA_STOCK_ERROR(681,"更新该商品规格的库存错误"),
	ADD_P_CONTRACT_ERROR(682,"商品绑定合同错误"),
	NO_APPOINTMENT_CONFIG(683,"没有该商品的配置信息"),
	APPOINTMENT_UPDATE_ERROR(684,"预约截止日期小于当前日期"),
	APPOINTMENT_MAX_ERROR(685,"可预约数必须大于已经预约的数量"),
	APPOINTMENT_TIME_ERROR(686,"修改时间必须大于当天时间和开始时间小于结束时间"),
	UPD_APPOINTMENT_ERROR(687,"更新预约信息失败"),
	FIND_HOLIDAYS_ERROR(688,"获取节假日失败"),
	FIND_USER_ERROR(689,"获取用户信息错误"),
	FIND_USER_SELLERID_LIST_ERROR(690,"获取供应链下的商家错误"),
	STORE_PRODUCT_NOT_TOP_ERROR(691,"该商品在该会员店中未被置顶"),
	DEL_STORE_PRODUCT_TOP(692,"取消置顶失败"),
	FIND_STORE_SHOP(693,"获取会员店失败"),
	FIND_USER_STORE_SHOP(694,"当前用户没有会员店"),
	DEL_STORE_PRODUCT_ERROR(695,"该商品已经删除"),
	ADD_STORE_PRODUCT_ERROR(696,"该商品已在你的会员店中"),
	STORE_SHOP_ERROR(697, "该店铺不属于您"),
	STORE_PRODUCT_PRODUCT_TOP_ERROR(698,"该商品在该会员店中已被置顶"),
	STORE_PRODUCT_TOP_ERROR(699,"该会员店置顶商品件数最多为3"),
	PRODUCT_TOP_ERROR(700,"置顶失败"),
	SCAN_AND_VERIFICATION(701,"获取核销信息失败"),
	UPD_SCAN_AND_VERIFICATION(702,"核销失败"),
	ADD_PRODUCT_STATIONMASTER_ERROR(703,"新增推荐商品失败"),
	DEL_PRODUCT_STATIONMASTER_ERROR(704,"取消推荐商品失败"),
	ADD_PRODUCT_ERROR(705,"添加商品失败"),
	UPD_PRODUCT_ERROR(706,"修改商品失败"),
	FIND_ERROR(707,"查询失败"),
	ADD_COMMENT_ERROR(708,"添加商品评论失败"),
	ADD_RECOMMENDTION_ERROR(709,"推荐商品失败"),
	ADD_RECOMMENDTION_NUM_ERROR(710,"推荐的商品数量未满足条件"),
	FIND_RECOMMENDTION_ERROR(711,"获取推荐商品"),
	UPD_P_CANCEL_ERROR(712,"取消推荐失败"),
	UPD_PAI_CANCEL_ERROR(713,"修改最高预约量不能超过最大预约量" ),
	ADD_P_STA_ERROR(714,"商品统计增加记录错误" ),
	ADD_P_STA_AFTER_ERROR(715,"支付完成之后商品统计增加记录错误" ),
	FIND_SELLER_BASE_INFO_ERROR(716,"获取商家信息错误" ),
	SUBMIT_P_ERROR(717,"提交审核失败,请完善信息" ),
	VALID_START_ERROR(718,"电子卡券商品的有效期起止时间必填" ),
	VALID_END_ERROR(719,"电子卡券商品的有效期起止时间必填" ),
	START_END_ERROR(720,"电子卡券商品的开始时间不能大于等于结束时间" ),
    BUY_NUM_STORE_ERROR(721,"电子卡卷类商品到店消费次数必填" ),
    STOCK_ERROR(722,"商品库存必填" ),
    PRICE_ERROR(723,"请输入保留两位小数的平台售价" ),
    COST_PRICE_ERROR(724,"请输入保留两位小数的平台结算价" ),
    RECOMMEND_COMMISSION_ERROR(725,"请输入保留两位小数的推荐奖励" ),
    SELF_BUY_COMMISSION_ERROR(726,"请输入保留两位小数的自购返现" ),
    SELF_BUY_RECOMMEND_ERROR(727,"请输入与推荐奖励相等的自购返现" ),
    APPOINTMENT_INFO_ERROR(728,"预约信息不能为空" ),
    APPOINTMENT_INFO_MONEY_ERROR(729,"节假日时请输入保留两位小数的加收金额" ),
    VERIFICATION_CONFIG_ERROR(730,"预约商品的预约信息不能为空" ),
    VERIFICATION_CONFIG_MONEY_ERROR(731,"批量设置money加收金额必填且保留两位小数" ),
    VERIFICATION_CONFIG_START_END_TIME_ERROR(732,"预约起始时间不能大于等于结束时间" ),
    VERIFICATION_CONFIG_START_TIME_ERROR(733,"预约起始时间必填" ),
    VERIFICATION_CONFIG_END_TIME_ERROR(734,"预约结束时间必填" ),
    SELF_BUY_RECOMMEND_MIN_ERROR(735,"自购或推荐必须是大于平台售价的1%" ),
    SELF_BUY_RECOMMEND_MAX_ERROR(736,"自购或推荐必须是小于平台售价的60%" ),
    FIND_PRODUCT_ERROR(737,"未找到对应商品" ),
    ADD_ERROR(738,"增加失败" ),
    UPDATE_PA_ERROR(739,"修改预约失败" ),
    UPDATE_ERROR(740,"更新失败" ),
	DEL_ERROR(741,"删除失败" ),
	SUBMIT_PRODUCT_ERROR(742,"你的商品信息不全，请先完善商品信息后再提交审核。" ),
	AUDIT_PRODUCT_STATUS_ERROR(743,"当前商品非下架商品" ),
	NOT_SUBMIT_PRODUCT_STATUS_ERROR(744,"当前商品未提交" ),
	ASSESS_MATERIAL_ERROR(745,"审核素材失败" ),
	PRODUCT_MATERIAL_AND_NOT(746,"该素材没有对应的商品" ),
	PRODUCT_AUDIT_NOT(747,"该记录不存在" ),
	AUDIT_ERROR(748,"附加审核失败" ),
	ASSESS_P_ERROR(749,"该商品不是待审核或改商品已审核" ),
	ADD_P_TTA_AND_ERROR(750,"添加推荐商品记录失败"),
	P_AUDIT_MSG_ONE(751,"此商家的在售商品已达上限5，请下架商品后再上架"),
	P_AUDIT_MSG_TWO(752,"在售商品上限为5，在上架后%s在售商品达上限，您将不能继续为他上架商品"),
	P_ACT_ERROR(753,"活动商品必为实物商品"),
	P_ACT_IS_ERROR(754,"该商品不是活动商品"),
	P_ACT_ADD_ERROR(755,"该商品关联活动失败"),
	P_ACT_ADD_STATUS_ERROR(756,"该商品不是商品库的商品"),
	P_ACT_DEL_STATUS_ERROR(757,"该商品不是活动商品库的商品"),
	P_MATERIAL_DEL_ERROR(758,"取消关联失败，当前素材不存在或未与该商品关联"),
	ADD_P_MATERIAL_DEL_ERROR(759,"关联素材失败，当前素材已被关联"),
	EXPORT_ERROR(760,"导出错误"),
	MEMBER_COMMISSION_ERROR(761,"请输入保留两位小数的的会员推荐奖，且最小为0.10元" ),


	SELECT_MAX_PAFE_VALUE(800,"查询已超出分页数最大阀值"),
	ACOUNT_CENTER_CREATE(801,"钱包账户还没有创建，请联系管理员"),
	ACOUNT_YU_NO(802,"账户余额不足"),
	CASHBACK_ERROR(803,"返现管理分页数据获取异常"),
	INOUTPAGE_ERROR(804,"收入支出分页数据获取异常"),
	INOUTTJ_ERROR(805,"收入支出统计数据获取异常"),
	ADD_BANK_EEROR(806,"添加银行卡异常"),
	SELECT_BANK_LIST_EEROR(807,"查询银行卡列表出错"),
	SCMORDERGOODS_ERROR(808,"营销额列表获取异常"),
	SCMORDERGOODSTJ_ERROR(809,"营销额统计数据获取异常"),
	SCMORDERGOODS_PAGE_LIST_ERROR(810,"营销额分页数据获取异常"),
	SCMORDER_PAGE_LIST_ERROR(811,"贷款收益分页数据获取异常"),
	GETUSERINFO_ERROE(812,"获取用户身份信息失败，请稍后再试"),
	USERINFO_YES_ERROE(813,"用户信息已存在"),
	CREATE_USER_ACCOUNT_ERROE(814,"创建用户钱包失败"),
	WITHD_PAGE_LIST_ERROR(815,"提现分页数据获取异常"),
	CRETE_WITHD_ERROE(816,"申请失败，稍后再试"),
	GET_BLOCKED_LIST(817,"获取不可提现金额列表失败"),
	GET_BLOCKED_AMOUNT_LIST(817,"获取近一年的月统计金额失败"),
	GET_BLOCKED_AMOUNT(818,"获取不可提现总金额失败"),
	SCM_USERACCOUNT_GYLUSERID(819,"获取用户金额失败"),
	ACOUNT_ERROR(820,"请填写正确的金额"),
    UPD_PAI_ERROR(821,"修改预约信息次数错误"),
	ACOUNT_CENTER_DELETED(822,"钱包账户已冻结，请联系管理员"),
	WITHD_SUP_ERROR(823,"请勿重复申请提现"),
	WITHD_AG_ERROR(824,"同意驳回失败"),
	WITHD_OK_ERROR(825,"已经处理过了，请勿重复处理"),
	SCMUSERYYENUM(826,"获取营业额付款总笔数失败，请稍后再试"),
	SENDSTATUS_ERROR(827,"标记打款状态失败了,请稍后再试，或者联系管理员"),
	SENDSTATUSLIST_ERROR(828,"标记打款数据不存在"),
	REMOTE_INVOCATION_FAIL(900,"远程服务调用失败");


	;
//	LOGIN_ERROR(611,"登录失败"),
//	REGIN_ERROR(608,"注册失败");

//	/**业务错误*/
//	SERVICE_ERROR(603,"");

    public int code;

	private String msg;

	private ResCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
