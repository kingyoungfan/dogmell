package com.yytec.dogmell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;

/**
 * 30/08/2017 22:38
 *
 * @author yangqiankun
 */
@Slf4j
@Controller
@RequestMapping("/api")
public class IndexController {

    @GetMapping
    public String index() {
        return "李影影是个小狗狗";
    }

    @GetMapping("weather/now.json")
    public String now(@PathVariable String lo) {
        return "{\"results\":[{\"location\":{\"id\":\"WS10730EM8EV\",\"name\":\"深圳\",\"country\":\"CN\",\"path\":\"深圳,深圳,广东,中国\",\"timezone\":\"Asia/Shanghai\",\"timezone_offset\":\"+08:00\"},\"now\":{\"text\":\"多云\",\"code\":\"4\",\"temperature\":\"31\"},\"last_update\":\"2017-09-01T17:20:00+08:00\"}]}";
    }

    @ResponseBody
    @GetMapping("testservlet")
    public Map<String, Object> test(HttpServletRequest request) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("scheme", request.getScheme());
        ret.put("servletPath", request.getServletPath());
        ret.put("serverPort", request.getServerPort());
        ret.put("serverName", request.getServerName());
        ret.put("protocol", request.getProtocol());
        ret.put("url", request.getRequestURL());
        ret.put("uri", request.getRequestURI());
        ret.put("contextPath", request.getContextPath());
        ret.put("queryString", request.getQueryString());
        ret.put("hostname", getHostname(request));
        ret.put("remoteAddr", request.getRemoteAddr());
        ret.put("remotePort", request.getRemotePort());
        ret.put("remoteHost", request.getRemoteHost());
        ret.put("remoteUser", request.getRemoteUser());
        ret.put("servletContext-contextPath", request.getServletContext().getContextPath());
        ret.put("isSecure", request.isSecure());
        ret.put("proto", request.getHeader("X-Forwarded-Proto"));
        Enumeration<String> headers = request.getHeaderNames();
        List<String> headerList = Collections.list(headers);
        headerList.forEach(headerName -> ret.put(headerName, request.getHeader(headerName)));
        return ret;
    }

    @GetMapping("testredirect")
    @ResponseBody
    public Map<String, Object> restredirect(HttpServletResponse response, @RequestParam Integer isSuccess) throws Exception {
        Map<String, Object> ret = new HashMap<>();
        log.info("{},{}", "12", "23");
        if (isSuccess.equals(1)) {
            response.sendRedirect("https://m.fulapay.com/jsPay?merchantNo=111222");
            return null;
        }
        log.info("******{},{}", "12", "23");
        ret.put("name", "yangyang");
        ret.put("age", 23);
        return ret;
    }


    /**
     * 获取域名
     *
     * @param request 请求对象
     * @return 域名
     */
    private static String getHostname(HttpServletRequest request) {
        return request.getHeader("X-Forwarded-Proto") + "://" + request.getServerName();
    }


    @GetMapping("openid")
    public Map<String, Object> openid(HttpServletResponse response, HttpServletRequest request,
                                      @RequestParam(required = false) String code) throws Exception {
        String weixinServer = "https://www.yangzheng.ren/api/code?redirect_uri=%s";
        Map<String, Object> ret = new HashMap<>();
        String redirectUri = URLEncoder.encode(getHostname(request) + request.getRequestURI(), "UTF-8");
        log.info("******redirectUri:{}", redirectUri);
        String redirect = String.format(weixinServer, redirectUri);
        if (Objects.isNull(code)) {
            log.info("******code is null******");
            response.sendRedirect(redirect);
            return null;
        }
        log.info("******return code ******");
        ret.put("code", code);
        return ret;

    }

}
