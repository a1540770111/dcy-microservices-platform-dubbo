package com.dcy.dubbo.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dcy.db.base.model.PageHelper;
import com.dcy.db.base.service.BaseService;
import com.dcy.dubbo.provider.dto.UserDTO;
import com.dcy.dubbo.provider.model.SysUserInfo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2020-02-10 11:51
 */
public class ISysUserInfoServiceMock implements ISysUserInfoService {

    @Override
    public String sayHello(String name) {
        return null;
    }

    @Override
    public List<SysUserInfo> findByUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean save(SysUserInfo sysUserInfo) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<SysUserInfo> collection) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUserInfo> collection) {
        return false;
    }

    @Override
    public boolean removeById(Serializable serializable) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> map) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> collection) {
        return false;
    }

    @Override
    public boolean updateById(SysUserInfo sysUserInfo) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<SysUserInfo> collection) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SysUserInfo sysUserInfo) {
        return false;
    }

    @Override
    public SysUserInfo getById(Serializable serializable) {
        return null;
    }

    @Override
    public Collection<SysUserInfo> listByIds(Collection<? extends Serializable> collection) {
        return null;
    }

    @Override
    public Collection<SysUserInfo> listByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public IPage<SysUserInfo> page(IPage<SysUserInfo> iPage) {
        return null;
    }

    @Override
    public IPage<SysUserInfo> pageList(PageHelper<SysUserInfo> pageHelper, SysUserInfo sysUserInfo) {
        return null;
    }

    @Override
    public List<SysUserInfo> list() {
        return null;
    }

    @Override
    public List<SysUserInfo> list(SysUserInfo sysUserInfo) {
        return null;
    }
}
