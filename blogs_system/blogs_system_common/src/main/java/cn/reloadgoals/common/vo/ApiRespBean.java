package cn.reloadgoals.common.vo;

/**
 * api接口通用返回
 * @author TranbinLee
 * @date 2019/10/3
 */
public class ApiRespBean {
    /**
     * 响应码
     */
    private String respCode;
    /**
     * 响应消息
     */
    private String respMsg;
    /**
     * 响应数据
     */
    private Object data;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
