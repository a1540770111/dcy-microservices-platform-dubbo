package com.dcy.security.auth.service;

import cn.hutool.core.collection.CollUtil;
import com.dcy.provider.model.SysUserInfo;
import com.dcy.provider.service.ISysUserInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author dcy
 * @Date: 2019/3/19 16:31
 * @Description:
 */
@Service
public class UserServiceDetailImpl implements UserDetailsService {

    @Reference
    private ISysUserInfoService iSysUserInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        // Basic ZGN5X2FkbWluX2NsaWVudDoxMjM0NTY=
        SysUserInfo entity = new SysUserInfo();
        entity.setUsername(username);
        SysUserInfo sysUserInfo = iSysUserInfoService.getOne(entity);
        if (sysUserInfo != null) {
            // 查询权限
            Set<String> permissionSet = iSysUserInfoService.getPermissionListByUserId(sysUserInfo.getUserId());
            Set<String> roleSet = iSysUserInfoService.getAuthRoleSetByUserId(sysUserInfo.getUserId());
            Set<String> moduleSet = iSysUserInfoService.getModuleListByUserId(sysUserInfo.getUserId());
            // 合并一起
            CollUtil.addAll(permissionSet, roleSet);
            CollUtil.addAll(permissionSet, moduleSet);
            sysUserInfo.setAllPermissionSet(permissionSet);
            return sysUserInfo;
        }
        return null;
    }
}
