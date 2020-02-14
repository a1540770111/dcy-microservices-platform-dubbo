package com.dcy.consumer.service;

import com.dcy.common.model.ResponseData;
import com.dcy.common.utils.BPwdEncoderUtil;
import com.dcy.db.base.model.PageData;
import com.dcy.db.base.model.PageHelper;
import com.dcy.provider.dto.SysUserInfoGroupDTO;
import com.dcy.provider.dto.SysUserInfoRoleDTO;
import com.dcy.provider.dto.UpdPasswordDTO;
import com.dcy.provider.exception.TestException;
import com.dcy.provider.model.SysRole;
import com.dcy.provider.model.SysUserGroup;
import com.dcy.provider.model.SysUserInfo;
import com.dcy.provider.service.ISysUserInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author dcy
 * @since 2019-09-06
 */
@RestController
@RequestMapping("/user")
@Api(value = "SysUserInfoController", tags = {"用户操作接口"})
public class SysUserInfoController {


    @Reference
    private ISysUserInfoService iSysUserInfoService;


    @ApiOperation(value = "重置密码", notes = "重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "SysUserInfo", name = "sysUserInfo", value = "对象参数", required = true)
    })
    @PostMapping(value = "/resetPassword")
    public ResponseData<Boolean> resetPassword(@RequestBody SysUserInfo sysUserInfo) {
        sysUserInfo.setPassword("{bcrypt}" + BPwdEncoderUtil.BCryptPassword(sysUserInfo.getPassword()));
        return ResponseData.success(iSysUserInfoService.updateById(sysUserInfo));
    }

    @ApiOperation(value = "获取已授权的角色列表", notes = "根据用户id查询已授权的角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "String", paramType = "query", required = true)
    })
    @GetMapping(value = "/getAuthRoleListByUserId")
    public ResponseData<List<SysRole>> getAuthRoleListByUserId(String userId) {
        return ResponseData.success(iSysUserInfoService.getAuthRoleListByUserId(userId));
    }


    @ApiOperation(value = "保存授权角色", notes = "保存授权角色")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "SysUserInfoRoleDTO", name = "sysUserInfoRoleDTO", value = "对象参数", required = true)
    })
    @PostMapping(value = "/saveAuthRole")
    public ResponseData<Boolean> saveAuthRole(@RequestBody SysUserInfoRoleDTO sysUserInfoRoleDTO) {
        return ResponseData.success(iSysUserInfoService.saveAuthRole(sysUserInfoRoleDTO));
    }

    @ApiOperation(value = "获取已授权的用户组列表", notes = "根据用户id查询已授权的用户组列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "String", paramType = "query", required = true)
    })
    @GetMapping(value = "/getAuthGroupListByUserId")
    public ResponseData<List<SysUserGroup>> getAuthGroupListByUserId(String userId) {
        return ResponseData.success(iSysUserInfoService.getAuthGroupListByUserId(userId));
    }


    @ApiOperation(value = "保存授权用户组", notes = "保存授权用户组")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "SysUserInfoGroupDTO", name = "sysUserInfoGroupDTO", value = "对象参数", required = true)
    })
    @PostMapping(value = "/saveAuthGroup")
    public ResponseData<Boolean> resetPassword(@RequestBody SysUserInfoGroupDTO sysUserInfoGroupDTO) {
        return ResponseData.success(iSysUserInfoService.saveAuthGroup(sysUserInfoGroupDTO));
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "UpdPasswordDTO", name = "updPasswordDTO", value = "对象参数", required = true)
    })
    @PostMapping(value = "/updatePassword")
    public ResponseData<Boolean> resetPassword(@RequestBody UpdPasswordDTO updPasswordDTO) {
        return ResponseData.success(iSysUserInfoService.updatePassword(updPasswordDTO));
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageHelper", value = "分页信息", dataType = "PageHelper", paramType = "query"),
            @ApiImplicitParam(name = "sysUserInfo", value = "查询对象", dataType = "SysUserInfo", paramType = "query")
    })
    @GetMapping(value = "/page")
    public ResponseData<PageData<SysUserInfo>> page(PageHelper<SysUserInfo> pageHelper, SysUserInfo sysUserInfo) {
        return ResponseData.success(iSysUserInfoService.pageList(pageHelper, sysUserInfo));
    }

    @ApiOperation(value = "获取全部信息", notes = "获取全部信息")
    @GetMapping(value = "/all")
    public ResponseData<List<SysUserInfo>> all() {
        return ResponseData.success(iSysUserInfoService.list());
    }

    @ApiOperation(value = "根据对象id，查询详细信息", notes = "根据对象id，查询详细信息")
    @GetMapping(value = "/getDetailById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "实体类Id", dataType = "String", paramType = "query")
    })
    public ResponseData<SysUserInfo> getSysUserInfoById(@RequestParam String id) {
        return ResponseData.success(iSysUserInfoService.getById(id));
    }

    @ApiOperation(value = "添加", notes = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "SysUserInfo", name = "sysUserInfo", value = "对象参数", required = true)
    })
    @PostMapping(value = "/save")
    public ResponseData<Boolean> save(@RequestBody SysUserInfo sysUserInfo) {
        // 赋值加密密码
        sysUserInfo.setPassword("{bcrypt}" + BPwdEncoderUtil.BCryptPassword(sysUserInfo.getPassword()));
        return ResponseData.success(iSysUserInfoService.save(sysUserInfo));
    }

    @ApiOperation(value = "修改", notes = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "SysUserInfo", name = "sysUserInfo", value = "对象参数", required = true)
    })
    @PostMapping(value = "/update")
    public ResponseData<Boolean> update(@RequestBody SysUserInfo sysUserInfo) {
        return ResponseData.success(iSysUserInfoService.updateById(sysUserInfo));
    }

    @ApiOperation(value = "删除", notes = "删除")
    @PostMapping(value = "/delete")
    public ResponseData<Boolean> delete(@RequestParam Serializable id) {
        return ResponseData.success(iSysUserInfoService.removeById(id));
    }

    @ApiOperation(value = "根据list删除", notes = "根据list删除")
    @PostMapping(value = "/deleteBatch")
    public ResponseData<Boolean> deleteBatch(@RequestBody Collection<? extends Serializable> idList) {
        return ResponseData.success(iSysUserInfoService.removeByIds(idList));
    }

    /**
     * 当设置ignoreExceptions参数时，
     * 抛出对应的异常就不会触发降级(也就是不会调用failMethod()方法).
     *
     * @param name
     * @return
     * @HystrixCommand(fallbackMethod = "sayHelloError",ignoreExceptions = TestException.class)
     */
    @HystrixCommand(fallbackMethod = "sayHelloError")
    @GetMapping("/sayHello")
    public ResponseData<String> sayHello(String name) throws TestException {
        String hello = iSysUserInfoService.sayHello(name);
        return ResponseData.success(hello);
    }

    public ResponseData<String> sayHelloError(String name, Throwable e) {
        e.printStackTrace();
        return ResponseData.error("服务器错误");
    }
}
