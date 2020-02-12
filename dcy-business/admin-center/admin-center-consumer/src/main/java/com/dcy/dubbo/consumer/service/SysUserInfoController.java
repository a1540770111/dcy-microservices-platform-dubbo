package com.dcy.dubbo.consumer.service;

import com.dcy.common.model.ResponseData;
import com.dcy.db.base.controller.BaseController;
import com.dcy.dubbo.provider.dto.UserDTO;
import com.dcy.dubbo.provider.exception.TestException;
import com.dcy.dubbo.provider.model.SysUserInfo;
import com.dcy.dubbo.provider.service.ISysUserInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.dromara.soul.client.common.annotation.SoulClient;
import org.springframework.web.bind.annotation.*;

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
public class SysUserInfoController extends BaseController<ISysUserInfoService, SysUserInfo> {


    @Reference
    private ISysUserInfoService iSysUserInfoService;

    /**
     * 当设置ignoreExceptions参数时，
     * 抛出对应的异常就不会触发降级(也就是不会调用failMethod()方法).
     *
     * @param name
     * @return
     * @HystrixCommand(fallbackMethod = "sayHelloError",ignoreExceptions = TestException.class)
     */
    @SoulClient(path = "/user/sayHello", desc = "测试")
    @HystrixCommand(fallbackMethod = "sayHelloError")
    @GetMapping("/sayHello")
    public ResponseData<String> sayHello(String name) throws TestException {
        String hello = iSysUserInfoService.sayHello(name);
        return ResponseData.success(hello);
    }

    @GetMapping("/list")
    public List<SysUserInfo> list() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("adddd");
        userDTO.setPassword("2222");
        return iSysUserInfoService.findByUser(userDTO);
    }

    public ResponseData<String> sayHelloError(String name, Throwable e) {
        e.printStackTrace();
        return ResponseData.error("服务器错误");
    }
}
