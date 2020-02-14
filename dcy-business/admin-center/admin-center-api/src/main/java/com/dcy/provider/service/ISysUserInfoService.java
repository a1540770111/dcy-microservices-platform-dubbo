package com.dcy.provider.service;

import com.dcy.db.base.service.BaseService;
import com.dcy.provider.dto.SysUserInfoGroupDTO;
import com.dcy.provider.dto.SysUserInfoRoleDTO;
import com.dcy.provider.dto.UpdPasswordDTO;
import com.dcy.provider.exception.TestException;
import com.dcy.provider.model.SysRole;
import com.dcy.provider.model.SysUserGroup;
import com.dcy.provider.model.SysUserInfo;

import java.util.List;
import java.util.Set;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2020-02-10 11:51
 */
public interface ISysUserInfoService extends BaseService<SysUserInfo> {

    String sayHello(String name) throws TestException;

    /**
     * 根据用户id 查询已授权角色列表
     *
     * @param userId
     * @return
     */
    List<SysRole> getAuthRoleListByUserId(String userId);


    /**
     * 保存授权角色
     *
     * @param sysUserInfoRoleDTO
     * @return
     */
    boolean saveAuthRole(SysUserInfoRoleDTO sysUserInfoRoleDTO);

    /**
     * 根据用户id 查询已授权用户组列表
     *
     * @param userId
     * @return
     */
    List<SysUserGroup> getAuthGroupListByUserId(String userId);

    /**
     * 保存授权用户组
     *
     * @param sysUserInfoGroupDTO
     * @return
     */
    boolean saveAuthGroup(SysUserInfoGroupDTO sysUserInfoGroupDTO);


    /**
     * 根据用户id 查询已授权角色列表
     *
     * @param userId
     * @return
     */
    Set<String> getAuthRoleSetByUserId(String userId);


    /**
     * 根据用户id 查询已授权菜单列表
     *
     * @param userId
     * @return
     */
    Set<String> getPermissionListByUserId(String userId);


    /**
     * 根据用户id 查询已授权的模块权限
     *
     * @param userId
     * @return
     */
    Set<String> getModuleListByUserId(String userId);


    /**
     * 修改密码
     *
     * @param updPasswordDTO
     * @return
     */
    boolean updatePassword(UpdPasswordDTO updPasswordDTO);
}
