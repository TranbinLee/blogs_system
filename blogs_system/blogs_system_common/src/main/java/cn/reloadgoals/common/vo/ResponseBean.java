package cn.reloadgoals.common.vo;


/**
 * 前后端交互通用返回
 * @author TranbinLee
 * @date 2019/10/3
 */
public class ResponseBean<T> {
    /**
     * 响应码
     */
    private String respCode;
    /**
     * 消息码
     */
    private String msgkey;
    /**
     * 响应消息
     */
    private String respMsg;
    /**
     * 响应数据
     */
    private T data;


    /**
     * 无参构造
     */
    public ResponseBean() {
    }

    /**
     * 无 响应消息及返回数据构造
     * @param respCode 响应码
     * @param msgkey   消息码
     */
    public ResponseBean(String respCode, String msgkey) {
        this.respCode = respCode;
        this.msgkey = msgkey;
    }

    /**
     * 无 返回数据构造
     * @param respCode 响应码
     * @param msgkey   消息码
     * @param respMsg  响应消息
     */
    public ResponseBean(String respCode, String msgkey, String respMsg) {
        this.respCode = respCode;
        this.msgkey = msgkey;
        this.respMsg = respMsg;
    }

    /**
     * 全参构造
     * @param respCode  响应码
     * @param msgkey    消息码
     * @param respMsg   响应消息
     * @param data      响应数据
     */
    public ResponseBean(String respCode, String msgkey, String respMsg, T data) {
        this.respCode = respCode;
        this.msgkey = msgkey;
        this.respMsg = respMsg;
        this.data = data;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getMsgkey() {
        return msgkey;
    }

    public void setMsgkey(String msgkey) {
        this.msgkey = msgkey;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
