package com.mdx.user.provider.dao;

import com.mdx.user.api.pojo.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    UserDTO getUser(@Param("userId") Long userId);
}
