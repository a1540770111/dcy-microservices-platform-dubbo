package com.dcy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dcy.db.base.binding.QueryBuilder;
import com.dcy.dubbo.provider.dto.UserDTO;
import com.dcy.dubbo.provider.model.SysUserInfo;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2020-02-12 09:23
 */
public class Test {

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("adddd");
        userDTO.setPassword("2222");
        QueryWrapper<SysUserInfo> queryWrapper = QueryBuilder.toWrapper(userDTO);
        System.out.println(queryWrapper.getCustomSqlSegment());
    }
}
