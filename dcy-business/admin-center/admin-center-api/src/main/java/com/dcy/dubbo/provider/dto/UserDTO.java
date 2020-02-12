package com.dcy.dubbo.provider.dto;

import com.dcy.db.base.binding.BindQuery;
import com.dcy.db.base.binding.Comparison;
import lombok.Data;

/**
 * @author dcy
 */
@Data
public class UserDTO {

    @BindQuery(comparison = Comparison.LIKE)
    private String username;
    private String password;

}
