package com.areca.springhazelcast.rest;

import com.areca.springhazelcast.dao.UserRepository;
import com.areca.springhazelcast.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestService {

    private UserRepository userRepository;

    @Autowired
    public UserRestService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{username}")
    public User getUserWithUsername(@PathVariable(value = "username") final String username) {
        return userRepository.findByUsername(username);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{username}")
    public void updateUserWithUsername(@PathVariable(value = "username") final String username,
                                       @RequestBody final User user) {
        assert username.equals(user.getUsername());
        userRepository.save(user);
    }

}
