package com.dcy.dubbo.provider.impl;

import com.dcy.dubbo.provider.mapper.SysUserInfoMapper;
import com.dcy.dubbo.provider.model.SysUserInfo;
import com.dcy.dubbo.provider.service.ISysUserInfoService;
import com.dcy.web.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dcy
 * @since 2019-09-06
 */
@RestController
public class SysUserInfoServiceImpl extends BaseServiceImpl<SysUserInfoMapper, SysUserInfo> implements ISysUserInfoService {

}
