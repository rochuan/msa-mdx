package com.mdx.user.provider.controller;

import com.mdx.common.ObjectResp;
import com.mdx.user.api.UserApi;
import com.mdx.user.api.pojo.dto.UserDTO;
import com.mdx.user.provider.dao.UserDAO;
import com.mdx.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    @Override
    public ObjectResp<UserDTO> userLogin() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1L);
        userDTO.setMobile("13800138000");
        return new ObjectResp<UserDTO>(userDTO);
    }

    @RequestMapping("/profile/getUser")
    @Override
    public ObjectResp<UserDTO> getUser() {
        Long userId = 1L;
        UserDTO userDTO = userService.getUser(userId);

        return new ObjectResp<UserDTO>(userDTO);
    }
}
