package com.areca.springhazelcast.rest;

import com.areca.springhazelcast.domain.User;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestService {

    private IMap<String, User> userMap;

    @Autowired
    public UserRestService(HazelcastInstance hazelcastInstance){
        this.userMap = hazelcastInstance.getMap("userMap");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{username}")
    public User getUserWithUsername(@PathVariable(value = "username") final String username) {
        return userMap.get(username);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{username}")
    public void updateUserWithUsername(@PathVariable(value = "username") final String username, final User user) {
        assert username.equals(user.getUsername());
        userMap.put(username, user);
    }

}
