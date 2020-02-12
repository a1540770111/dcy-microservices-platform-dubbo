package com.dcy.dubbo.provider.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dcy.db.base.binding.QueryBuilder;
import com.dcy.dubbo.provider.dto.UserDTO;
import com.dcy.dubbo.provider.mapper.SysUserInfoMapper;
import com.dcy.dubbo.provider.model.SysUserInfo;
import com.dcy.dubbo.provider.service.ISysUserInfoService;
import com.dcy.web.base.service.impl.BaseServiceImpl;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

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

    @Override
    public List<SysUserInfo> findByUser(UserDTO userDTO) {
        QueryWrapper<SysUserInfo> queryWrapper = QueryBuilder.toWrapper(userDTO);
        return super.list(queryWrapper);
    }
}
