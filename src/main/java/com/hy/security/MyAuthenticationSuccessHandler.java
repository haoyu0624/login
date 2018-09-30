package com.hy.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hy.model.LoginResponseType;
import com.hy.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");
        if(LoginResponseType.JSON.equals(securityProperties.getLoginType())){
            response.setContentType("application/json;charset=UTF-8");
//		response.getWriter().write(objectMapper.writeValueAsString(authentication));
            Object principal = authentication.getPrincipal();
//        Result result = new Result();
//        result.put("admin",principal);
//        result.put("proxyHost", "127.0.0.1");
//        result.put("triggerHost", "127.0.0.1");
//        result.put("versionCode", "1.0.0");
//        String token = Md5Util.encode("fsdfsdfsdfsddf");
//        result.put("token", token);
            String string = objectMapper.writeValueAsString(principal);
            response.getWriter().write(string);
        }else{
//            response.encodeURL("inxex.html");
//            super.onAuthenticationSuccess(request, response, authentication);
            response.sendRedirect(request.getContextPath() + "/index.html");
        }

    }
}
