/**
 * 
 */
package com.hy.security;

import com.hy.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author zhailiang
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public UserDetails loadUserByUsername(String username) {
		// 根据用户名查找用户信息
		//根据查找到的用户信息判断用户是否被冻结
//		String password = passwordEncoder.encode("123456");
		UserInfo user = getUserInfo(username);
		System.out.println("username = [" + username + "]");
		return new User(user.getName(), user.getPassword(),
				true, true, true, true,
				AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
	}

	private UserInfo getUserInfo(String username) {
		if("admin".equalsIgnoreCase(username)){
			UserInfo user = new UserInfo();
			user.setName("超管");
			user.setAge(99);
			user.setAddress("白宫");
			user.setPassword("123456");
			user.setRole("ROLE_ADMIN");
			return user;
		}else{
			UserInfo user = new UserInfo();
			user.setName("普通用户");
			user.setAge(99);
			user.setAddress("平房");
			user.setPassword("111111");
			user.setRole("ROLE_COMMON");
			return user;
		}
	}
}
