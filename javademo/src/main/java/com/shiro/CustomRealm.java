package com.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomRealm extends AuthorizingRealm {

    Map<String, String> map = new HashMap<>();

    {
        map.put("tom", "123456");
        map.put("cat", "1234");
        super.setName("customRealm");
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(getRolesByUsername(username));//设置角色
        authorizationInfo.addStringPermissions(getPermissionsByUsername(username));//设置权限
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从主体传过来的认证信息中获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //从数据库获取用户密码
        String password = getPasswordByUsername(username);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "customRealm");
        return simpleAuthenticationInfo;
    }

    /**
     * 模拟从数据库获取密码
     *
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        return map.get(username);
    }

    private List<String> getRolesByUsername(String username) {
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("staff");
        return list;
    }

    private List<String> getPermissionsByUsername(String username) {
        List<String> list = new ArrayList<>();
        list.add("user:add");
        list.add("user:update");
        return list;
    }
}
