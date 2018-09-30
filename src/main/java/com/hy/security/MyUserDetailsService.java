/**
 * 
 */
package com.hy.security;

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
		System.out.println("username = [" + username + "]");
		return new User(username, "123456",
				true, true, true, true,
				AuthorityUtils.commaSeparatedStringToAuthorityList("role_admin"));
	}
}
