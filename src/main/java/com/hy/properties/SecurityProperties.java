package com.hy.properties;

import com.hy.model.LoginResponseType;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hy.security")
public class SecurityProperties {
    /**
     * 登录类型
     */
    private LoginResponseType loginType = LoginResponseType.JSON;

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }
}
