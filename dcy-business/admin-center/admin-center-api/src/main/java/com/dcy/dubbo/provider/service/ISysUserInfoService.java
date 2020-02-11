package com.dcy.dubbo.provider.service;

import com.dcy.db.base.service.BaseService;
import com.dcy.dubbo.provider.model.SysUserInfo;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2020-02-10 11:51
 */
public interface ISysUserInfoService extends BaseService<SysUserInfo> {

    String sayHello(String name);
}
