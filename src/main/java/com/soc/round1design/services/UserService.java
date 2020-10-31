package com.soc.round1design.services;

import com.soc.round1design.dto.request.UserRequestBean;
import com.soc.round1design.dto.response.UIResponse;

public interface UserService {

    UIResponse registerUser(UserRequestBean userRequestBean);
}
