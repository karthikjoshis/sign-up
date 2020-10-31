package com.soc.round1design.controller;

import com.soc.round1design.constants.GeneralConstants;
import com.soc.round1design.dto.request.UserRequestBean;
import com.soc.round1design.dto.response.UIResponse;
import com.soc.round1design.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            value = "/sign-up",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UIResponse registerUser(@RequestBody UserRequestBean userRequestBean){
        try{
            if (isValidInput(userRequestBean)){
                return userService.registerUser(userRequestBean);
            }
            else {
                log.error("ERROR: Invalid input please check the entered details");

                return new UIResponse(-1, GeneralConstants.INVALID_INPUT, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            log.error("ERROR in user registration controller,cause is:{} ",e.getMessage());

            return new UIResponse(-1, GeneralConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isValidInput(UserRequestBean userRequestBean){
        return userRequestBean.getFirstName() != null && userRequestBean.getLastName() != null
                && userRequestBean.getEmailId() != null && userRequestBean.getFirstName().length() > 0
                && userRequestBean.getLastName().length() > 0 && userRequestBean.getEmailId().length() > 0;
    }
}
