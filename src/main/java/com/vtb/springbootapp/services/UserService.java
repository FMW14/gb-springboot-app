package com.vtb.springbootapp.services;


import com.vtb.springbootapp.domain.User;
import com.vtb.springbootapp.exceptions.ResourceNotFoundException;
import com.vtb.springbootapp.repos.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;

    public void save(User user) {
        userRepo.save(user);
    }

    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public void removeById(Long id){
        userRepo.deleteById(id);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
}
