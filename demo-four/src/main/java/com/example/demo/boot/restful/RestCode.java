package com.example.demo.boot.restful;


public enum RestCode {

    SUCCESS(200, "成功！"),
    FAIL(400, "失败！"),
    UNAUTHORIZED(401, "未授权！"),
    FORBIDDEN(403, "禁止访问该资源！"),
    NOT_FOUND(404, "未发现该资源！"),
    REQUEST_TIMEOUT(408, "请求超时!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误！"),
    SERVICE_UNAVAILABLE(503, "服务无法获得！"),
    GATEWAY_TIMEOUT(504, "网关超时！"),
    REMOTE_INVOCATION_FAIL(900, "远程服务调用失败！"),
    SYSTEM_BUSY(800, "系统繁忙，请稍后重试！");

    private int code;
    private String msg;

    RestCode(int code, String msg) {
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
