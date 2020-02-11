package com.dcy.dubbo.provider.impl;

import com.dcy.dubbo.provider.mapper.SysUserInfoMapper;
import com.dcy.dubbo.provider.model.SysUserInfo;
import com.dcy.dubbo.provider.service.ISysUserInfoService;
import com.dcy.web.base.service.impl.BaseServiceImpl;
import org.apache.dubbo.config.annotation.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dcy
 * @since 2019-09-06
 */
@Service
public class SysUserInfoServiceImpl extends BaseServiceImpl<SysUserInfoMapper, SysUserInfo> implements ISysUserInfoService {

    @Override
    public String sayHello(String name) {
        return "Hello Dubbo 1.0.0 " + name;
    }
}
