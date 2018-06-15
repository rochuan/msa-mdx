package com.mdx.user.provider.service.impl;

import com.mdx.user.api.pojo.dto.UserDTO;
import com.mdx.user.provider.dao.UserDAO;
import com.mdx.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public UserDTO getUser(Long userId) {

        UserDTO userDTO = userDAO.getUser(userId);
        return userDTO;
    }
}
