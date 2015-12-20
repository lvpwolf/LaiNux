package com.heisenberg.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.stereotype.Component;

@Component
public class MyRealm extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
		//获取用户名
		String username = usernamePasswordToken.getUsername();
		//根据用户名从数据库中查询出来的密码
		Object credentials = "123456";
		//当前 Realm 的 name. 直接调用父类的 getName() 方法即可. 
		String realmName = getName();
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, credentials, realmName);
		return simpleAuthenticationInfo;
	}



}
