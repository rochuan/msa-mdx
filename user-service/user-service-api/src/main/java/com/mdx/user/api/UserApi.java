package com.mdx.user.api;

import com.mdx.common.ObjectResp;
import com.mdx.user.api.pojo.dto.UserDTO;

public interface UserApi {

    public ObjectResp<UserDTO> userLogin();

    public ObjectResp<UserDTO> getUser();
}
