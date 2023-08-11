package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserProfileDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.ProfileDto;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class ProfileController {

    private UserProfileDao userProfileDao;
    private UserDao userDao;

    public ProfileController(UserProfileDao userProfileDao, UserDao userDao) {
        this.userProfileDao = userProfileDao;
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public ProfileDto getUserProfileType(@Valid Principal principal) {
        ProfileDto userProfile;
        User loggedInUser;
        try {
            loggedInUser = userDao.getUserByUsername(principal.getName());

            userProfile = userProfileDao.getUserProfileType(loggedInUser.getId());
            if (userProfile == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User Not Found.");
        }
        return userProfile;
    }
}
