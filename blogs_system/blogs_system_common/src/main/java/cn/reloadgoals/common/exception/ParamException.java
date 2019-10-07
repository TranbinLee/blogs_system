package cn.reloadgoals.common.exception;

import cn.reloadgoals.common.constants.SystemConstants;
import cn.reloadgoals.common.constants.TipsConstants;

/**
 * 系统自定义异常
 * @author TranbinLee
 * @date 2019/10/4
 */
public class ParamException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String respCode;
    private String msgKey;

    public String getRespCode() {
        return respCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    public String getMsgKey() {
        return msgKey;
    }
    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public ParamException(String respCode, String msgKey) {
        super();
        this.respCode = respCode;
        this.msgKey = msgKey;
    }
    public static ParamException error() {
        return new ParamException(SystemConstants.RESPONSE_FAIL, TipsConstants.OPERATE_FAIL);
    }


}
