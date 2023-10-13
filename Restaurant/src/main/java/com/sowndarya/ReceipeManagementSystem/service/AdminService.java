package com.sowndarya.ReceipeManagementSystem.service;

import com.sowndarya.ReceipeManagementSystem.model.AuthenticationToken;
import com.sowndarya.ReceipeManagementSystem.model.Admin;
import com.sowndarya.ReceipeManagementSystem.repository.AdminRepo;
import com.sowndarya.ReceipeManagementSystem.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepo iRepo;


    @Autowired
    ITokenRepo tokenRepo;
    public void createIngredients(List<Admin> ingredients, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.saveAll(ingredients);
        }
    }

    public List<Admin> getIngredients(String email, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        return iRepo.findAll();
    }

    public void deleteIngredients(Long id, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.deleteById(id);
        }
    }
}
