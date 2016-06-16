package com.market.services;

import com.market.models.User;
import com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        int userId = userRepository.setUserDetails(user);
        int roleId = dictionaryService.getRoleId("ROLE_USER");
        userRepository.setUserRole(roleId, userId);
    }
}
