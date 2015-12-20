package com.heisenberg.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloShiro {
	
	@RequestMapping("/helloShiro")
	public String helloShiro(@RequestParam("username") String username,@RequestParam("password") String password){
		System.out.println("aaa");
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		subject.login(usernamePasswordToken);
		if(subject.isAuthenticated()){
			usernamePasswordToken.setRememberMe(true);
			System.out.println("授权成功.");
			return "success";
		}else{
			System.out.println("授权失败");
			return "redirect:/login.jsp";
		}
		
	}
}
