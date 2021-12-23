package com.example.demo.boot.restful;


public class RestResponse {

  public static RestResult<String> ok() {
    return new RestResult<String>().setCode(RestCode.SUCCESS).setMsg(RestCode.SUCCESS.getMsg());
  }

  public static <T> RestResult<T> ok(T data) {
    return new RestResult<T>().setCode(RestCode.SUCCESS).setMsg(RestCode.SUCCESS.getMsg()).setData(data);
  }

  public static <T> RestResult<T> error(String message) {
    return new RestResult<T>().setCode(RestCode.FAIL).setMsg(message);
  }

  public static <T> RestResult<T> error(RestCode restCode, T data) {
    return new RestResult<T>().setCode(restCode.getCode()).setMsg(restCode.getMsg()).setData(data);
  }

  public static <T> RestResult<T> error(RestCode restCode) {
    return new RestResult<T>().setCode(restCode.getCode()).setMsg(restCode.getMsg());
  }

  public static <T> RestResult<T> error(RestCode restCode, String error) {
    return new RestResult<T>().setCode(restCode.getCode()).setMsg(restCode.getMsg()).setError(error);
  }

  public static <T> RestResult<T> error(int code, String msg, String error) {
    return new RestResult<T>().setCode(code).setMsg(msg).setError(error);
  }

  public static <T> RestResult<T> build(int code, String msg) {
    return new RestResult<T>().setCode(code).setMsg(msg);
  }

  public static <T> RestResult<T> build(int code, String msg, T data) {
    return new RestResult<T>().setCode(code).setMsg(msg).setData(data);
  }

  public static <T> T verifyRestResult(RestResult<T> restResult) {
    if (restResult == null) {
      throw new ServiceException(RestCode.SERVICE_UNAVAILABLE);
    }
    if (restResult.getCode() != RestCode.SUCCESS.getCode()) {
      throw new ServiceException(restResult.getCode(), restResult.getMsg());
    }
    return restResult.getData();
  }
}
