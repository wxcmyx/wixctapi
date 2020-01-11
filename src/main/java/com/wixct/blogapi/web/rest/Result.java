package com.wixct.blogapi.web.rest;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 返回结果
 */
public class Result extends HashMap {
    /**
     * 状态码：0，成功，1，失败
     */
    public static final int DEFAULT_SUCC_CODE = 0;
    public static final int DEFAULT_FAIL_CODE = 1;



    /**
     * 成功
     * @return
     */
    public static Result succ() {
        return new Result().success();
    }
    /**
     * 失败
     * @return
     */
    public static Result fail() {
        return new Result().failure();
    }

    /**
     * 失败
     * @return
     */
    public Result failure(){
        this.put("code",DEFAULT_FAIL_CODE);
        return this;
    }

    /**
     * 成功
     * @return
     */
    public Result success(){
        this.put("code",DEFAULT_SUCC_CODE);
        return this;
    }
    /**
     * 设置 400 错误
     * @return
     */
    public Result set400(){
        this.failure();
        this.put("message","语义或请求参数有误");
        this.put("ercode","400");
        this.put("ermessage","语义或请求参数有误");
        return this;
    }

    /**
     * 设置 401 错误
     * @return
     */
    public Result set401(){
        this.failure();
        this.put("message","未授权或ACL禁止访问资源");
        this.put("code","401");
        this.put("ermessage","未授权或ACL禁止访问资源");
        return this;
    }

    /**
     * 设置 403 错误
     * @return
     */
    public Result set403(){
        this.failure();
        this.put("message","禁止访问");
        this.put("code","403");
        this.put("ermessage","禁止访问");
        return this;
    }

    /**
     * 设置 404 错误
     * @return
     */
    public Result set404(){
        this.failure();
        this.put("message","path not found");
        this.put("code","404");
        this.put("ermessage","path not found");
        return this;
    }
    /**
     * 设置 405 错误
     * @return
     */
    public Result set405(){
        this.failure();
        this.put("message","资源被禁止");
        this.put("code","405");
        this.put("ermessage","资源被禁止");
        return this;
    }

    /**
     * 设置 406 错误
     * @return
     */
    public Result set406(){
        this.failure();
        this.put("message","请求资源不可访问");
        this.put("code","406");
        this.put("ermessage","请求资源不可访问");
        return this;
    }

    /**
     * 设置 407 错误
     * @return
     */
    public Result set407(){
        this.failure();
        this.put("message","要求进行代理身份验证");
        this.put("code","407");
        this.put("ermessage","要求进行代理身份验证");
        return this;
    }

    /**
     * 设置 408 错误
     * @return
     */
    public Result set408(){
        this.failure();
        this.put("message","请求超时");
        this.put("code","408");
        this.put("ermessage","请求超时");
        return this;
    }
    /**
     * 设置 409 错误
     * @return
     */
    public Result set409(){
        this.failure();
        this.put("message","由于和被请求的资源的当前状态之间存在冲突，请求无法完成");
        this.put("code","409");
        this.put("ermessage","由于和被请求的资源的当前状态之间存在冲突，请求无法完成");
        return this;
    }

    /**
     * 设置 410 错误
     * @return
     */
    public Result set410(){
        this.failure();
        this.put("message","该资源已经不再可用");
        this.put("code","410");
        this.put("ermessage","该资源已经不再可用");
        return this;
    }

    /**
     * 设置 411 错误
     * @return
     */
    public Result set411(){
        this.failure();
        this.put("message","服务器拒绝用户定义的Content-Length属性请求");
        this.put("code","411");
        this.put("ermessage","服务器拒绝用户定义的Content-Length属性请求");
        return this;
    }

    /**
     * 设置 412 错误
     * @return
     */
    public Result set412(){
        this.failure();
        this.put("message","服务器在验证在请求的头字段中给出先决条件时，没能满足其中的一个或多个");
        this.put("code","412");
        this.put("ermessage","服务器在验证在请求的头字段中给出先决条件时，没能满足其中的一个或多个");
        return this;
    }

    /**
     * 设置 413 错误
     * @return
     */
    public Result set413(){
        this.failure();
        this.put("message","请求的资源大于服务器允许的大小");
        this.put("code","413");
        this.put("ermessage","请求的资源大于服务器允许的大小");
        return this;
    }

    /**
     * 设置 414 错误
     * @return
     */
    public Result set414(){
        this.failure();
        this.put("message","请求的资源URL长于服务器允许的长度");
        this.put("code","414");
        this.put("ermessage","请求的资源URL长于服务器允许的长度");
        return this;
    }

    /**
     * 设置 415 错误
     * @return
     */
    public Result set415(){
        this.failure();
        this.put("message","请求资源不支持请求项目格式");
        this.put("code","415");
        this.put("ermessage","请求资源不支持请求项目格式");
        return this;
    }

    /**
     * 设置 416 错误
     * @return
     */
    public Result set416(){
        this.failure();
        this.put("message","请求中包含Range请求头字段，在当前请求资源范围内没有range指示值，请求也不包含If-Range请求头字段");
        this.put("code","416");
        this.put("ermessage","请求中包含Range请求头字段，在当前请求资源范围内没有range指示值，请求也不包含If-Range请求头字段");
        return this;
    }

    /**
     * 设置 417 错误
     * @return
     */
    public Result set417(){
        this.failure();
        this.put("message","服务器不满足请求Expect头字段指定的期望值，如果是代理服务器，可能是下一级服务器不能满足请求长");
        this.put("code","417");
        this.put("ermessage","服务器不满足请求Expect头字段指定的期望值，如果是代理服务器，可能是下一级服务器不能满足请求长");
        return this;
    }

    /**
     * 设置 421 错误
     * @return
     */
    public Result set421(){
        this.failure();
        this.put("message","从当前客户端所在的IP地址到服务器的连接数超过了服务器许可的最大范围");
        this.put("code","421");
        this.put("ermessage","从当前客户端所在的IP地址到服务器的连接数超过了服务器许可的最大范围");
        return this;
    }

    /**
     * 设置 422 错误
     * @return
     */
    public Result set422(){
        this.failure();
        this.put("message","请求格式正确，但是由于含有语义错误，无法响应");
        this.put("code","422");
        this.put("ermessage","请求格式正确，但是由于含有语义错误，无法响应");
        return this;
    }

    /**
     * 设置 423 错误
     * @return
     */
    public Result set423(){
        this.failure();
        this.put("message","当前资源被锁定");
        this.put("code","423");
        this.put("ermessage","当前资源被锁定");
        return this;
    }

    /**
     * 设置 424 错误
     * @return
     */
    public Result set424(){
        this.failure();
        this.put("message","由于之前的某个请求发生的错误，导致当前请求失败，例如 PROPPATCH");
        this.put("code","424");
        this.put("ermessage","由于之前的某个请求发生的错误，导致当前请求失败，例如 PROPPATCH");
        return this;
    }

    /**
     * 设置 426 错误
     * @return
     */
    public Result set426(){
        this.failure();
        this.put("message","客户端应当切换到TLS/1.0");
        this.put("code","426");
        this.put("ermessage","客户端应当切换到TLS/1.0");
        return this;
    }

    /**
     * 设置 449 错误
     * @return
     */
    public Result set449(){
        this.failure();
        this.put("message","请求应当在执行完适当的操作后进行重试");
        this.put("code","449");
        this.put("ermessage","请求应当在执行完适当的操作后进行重试");
        return this;
    }

    /**
     * 设置 451 错误
     * @return
     */
    public Result set451(){
        this.failure();
        this.put("message","该请求因法律原因不可用");
        this.put("code","451");
        this.put("ermessage","该请求因法律原因不可用");
        return this;
    }

    /**
     * 设置 500 错误
     * @return
     */
    public Result set500(){
        this.failure();
        this.put("message","Server Error");
        this.put("code","500");
        this.put("ermessage","Server Error");
        return this;
    }

    /**
     * 设置 501 错误
     * @return
     */
    public Result set501(){
        this.failure();
        this.put("message","服务器不支持当前请求所需要的某个功能");
        this.put("code","501");
        this.put("ermessage","服务器不支持当前请求所需要的某个功能");
        return this;
    }

    /**
     * 设置 502 错误
     * @return
     */
    public Result set502(){
        this.failure();
        this.put("message","作为网关或者代理工作的服务器尝试执行请求时，从上游服务器接收到无效的响应");
        this.put("code","502");
        this.put("ermessage","作为网关或者代理工作的服务器尝试执行请求时，从上游服务器接收到无效的响应");
        return this;
    }

    /**
     * 设置 503 错误
     * @return
     */
    public Result set503(){
        this.failure();
        this.put("message","由于超载或停机维护，服务器目前无法使用，一段时间后可能恢复正常");
        this.put("code","503");
        this.put("ermessage","由于超载或停机维护，服务器目前无法使用，一段时间后可能恢复正常");
        return this;
    }

    /**
     * 设置 504 错误
     * @return
     */
    public Result set504(){
        this.failure();
        this.put("message","作为网关或者代理工作的服务器尝试执行请求时，未能及时从上游服务器（URI标识出的服务器，例如HTTP、FTP、LDAP）或者辅助服务器（例如DNS）收到响应");
        this.put("code","504");
        this.put("ermessage","作为网关或者代理工作的服务器尝试执行请求时，未能及时从上游服务器（URI标识出的服务器，例如HTTP、FTP、LDAP）或者辅助服务器（例如DNS）收到响应");
        return this;
    }

    /**
     * 设置 505 错误
     * @return
     */
    public Result set505(){
        this.failure();
        this.put("message","服务器不支持，或者拒绝支持在请求中使用的 HTTP 版本");
        this.put("code","505");
        this.put("ermessage","服务器不支持，或者拒绝支持在请求中使用的 HTTP 版本");
        return this;
    }

    /**
     * 设置 506 错误
     * @return
     */
    public Result set506(){
        this.failure();
        this.put("message","服务器存在内部配置错误");
        this.put("code","506");
        this.put("ermessage","服务器存在内部配置错误");
        return this;
    }

    /**
     * 设置 507 错误
     * @return
     */
    public Result set507(){
        this.failure();
        this.put("message","服务器无法存储完成请求所必须的内容");
        this.put("code","507");
        this.put("ermessage","服务器无法存储完成请求所必须的内容");
        return this;
    }

    /**
     * 设置 509 错误
     * @return
     */
    public Result set509(){
        this.failure();
        this.put("message","服务器达到带宽限制");
        this.put("code","509");
        this.put("ermessage","服务器达到带宽限制");
        return this;
    }

    /**
     * 设置 510 错误
     * @return
     */
    public Result set510(){
        this.failure();
        this.put("message","获取资源所需要的策略并没有被满足");
        this.put("code","510");
        this.put("ermessage","获取资源所需要的策略并没有被满足");
        return this;
    }

    /**
     * 设置 600 错误
     * @return
     */
    public Result set600(){
        this.failure();
        this.put("message","源站没有返回响应头部，只返回实体内容");
        this.put("code","600");
        this.put("ermessage","源站没有返回响应头部，只返回实体内容");
        return this;
    }
    public int getCode() {
        return (Integer) this.get("code");
    }

    public Result setCode(int code) {
        this.put("code",code);
        return this;
    }

    public String getMessage() {
        return (String)this.get("message");
    }

    public Result setMessage(String message) {
        this.put("message",message);
        return this;
    }

    public String getErcode() {
        return (String)this.get("ercode");
    }

    public Result setErcode(String ercode) {
        this.put("ercode",ercode);
        return this;
    }

    public String getErmessage() {
        return (String)this.get("ermessage");
    }

    public Result setErmessage(String ermessage) {
        this.put("ermessage",ermessage);
        return this;
    }

    public Object getData() {
        return this.get("data");
    }

    public Result setData(Object data) {
        this.put("data",data);
        return this;
    }

    public String toJsonString(){
        return JSON.toJSONString(this);
    }

}
