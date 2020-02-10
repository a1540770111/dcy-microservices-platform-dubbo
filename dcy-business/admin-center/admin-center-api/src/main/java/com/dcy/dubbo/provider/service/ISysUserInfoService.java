package com.dcy.dubbo.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dcy.db.base.model.PageHelper;
import com.dcy.db.base.service.BaseService;
import com.dcy.dubbo.provider.InterfaceService;
import com.dcy.dubbo.provider.model.SysUserInfo;
import org.springframework.cloud.openfeign.FeignClient;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2020-02-10 11:51
 */
@FeignClient(value = InterfaceService.SERVICE_NAME)
public interface ISysUserInfoService extends BaseService<SysUserInfo> {


}
