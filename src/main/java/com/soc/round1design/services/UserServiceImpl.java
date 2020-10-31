package com.soc.round1design.services;

import com.soc.round1design.constants.GeneralConstants;
import com.soc.round1design.database.User;
import com.soc.round1design.database.UserRepository;
import com.soc.round1design.dto.request.UserRequestBean;
import com.soc.round1design.dto.response.UIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UIResponse registerUser(UserRequestBean userRequestBean) {
        try{
            if (isExistingUser(userRequestBean)){
                log.error("Error: User with email:{} already present", userRequestBean.getEmailId());

                return new UIResponse(-1,GeneralConstants.USER_SIGNUP_ERROR_MESSAGE,HttpStatus.BAD_REQUEST);
            }

            return saveUser(userRequestBean);
        }
        catch (Exception e){
            log.error("Error: while registering user:{} ",e.getMessage());

            return new UIResponse(-1,GeneralConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isExistingUser(UserRequestBean userRequestBean){
        Optional<Integer> user = userRepository.findByEmailId(userRequestBean.getEmailId());

        return user.isPresent();
    }

    private UIResponse saveUser(UserRequestBean userRequestBean){
        log.info("Saving user with email:{} ", userRequestBean.getEmailId());
        User user = new User();

        user.setFirstName(userRequestBean.getFirstName().trim());
        user.setLastName(userRequestBean.getLastName().trim());
        user.setEmailId(userRequestBean.getEmailId().trim());

        user = userRepository.save(user);

        return new UIResponse(user.getId(), HttpStatus.OK, GeneralConstants.USER_SIGNUP_SUCCESS_MESSAGE);
    }
}
