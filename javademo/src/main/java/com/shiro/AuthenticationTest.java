package com.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;


public class AuthenticationTest {


    public void authenticate() {
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("admin1", "123456", "admin", "staff");

        // 构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin1", "123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.getPrincipal());//用户名
        subject.checkRole("admin");
        subject.logout();
        System.out.println(subject.isAuthenticated());

    }

    public void iniRealmTest() {

        IniRealm realm = new IniRealm("classpath:user.ini");

        // 构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.getPrincipal());//用户名
        subject.checkRole("admin");
        subject.checkPermission("user:add");

    }

    @Test
    public void customRealmTest() {

        CustomRealm realm = new CustomRealm();

        // 构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("cat", "123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.getPrincipal());//用户名
        subject.checkRole("admin");
        subject.checkPermission("user:add");

    }


}
