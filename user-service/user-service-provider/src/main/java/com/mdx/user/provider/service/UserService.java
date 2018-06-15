package com.mdx.user.provider.service;

import com.mdx.user.api.pojo.dto.UserDTO;

public interface UserService {

    UserDTO getUser(Long userId);
}
