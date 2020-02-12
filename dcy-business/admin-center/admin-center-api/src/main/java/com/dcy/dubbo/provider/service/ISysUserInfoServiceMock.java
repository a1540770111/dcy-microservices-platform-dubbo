package com.dcy.dubbo.provider.service;

import com.dcy.db.base.service.BaseServiceMock;
import com.dcy.dubbo.provider.dto.UserDTO;
import com.dcy.dubbo.provider.model.SysUserInfo;

import java.util.List;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2020-02-10 11:51
 */
public class ISysUserInfoServiceMock extends BaseServiceMock<SysUserInfo> implements ISysUserInfoService {

    @Override
    public String sayHello(String name) {
        return null;
    }

    @Override
    public List<SysUserInfo> findByUser(UserDTO userDTO) {
        return null;
    }
}
