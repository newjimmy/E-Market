package com.market.services;

import com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class DictionaryService {
    @Autowired
    private UserRepository repository;
    private Map<String, Integer> userRolesMap;

    public int getRoleId(String roleName) {
        return userRolesMap.get(roleName);
    }

    @PostConstruct
    public void init() {
        userRolesMap = repository.getAllRoles();
    }
}
