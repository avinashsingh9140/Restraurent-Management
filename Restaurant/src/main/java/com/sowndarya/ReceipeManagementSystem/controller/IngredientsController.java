package com.sowndarya.ReceipeManagementSystem.controller;

import com.sowndarya.ReceipeManagementSystem.model.Admin;
import com.sowndarya.ReceipeManagementSystem.service.AdminService;
import com.sowndarya.ReceipeManagementSystem.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientsController {
    @Autowired
    AdminService iService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/ingredients")
    public ResponseEntity<String> createRecipe(@RequestBody List<Admin> ingredients, @RequestParam String email, @RequestParam String token) {
        HttpStatus status;
        String message;
        if (tokenService.authenticate(email, token)) {
            iService.createIngredients(ingredients, token);
            message = "Ingredients created successfully";
            status = HttpStatus.OK;
        } else {
            message = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<>(message, status);
    }
    @GetMapping("/ingredients")
    public ResponseEntity<String>  getIngredients(@RequestParam String token, @RequestParam String email) {

        if (tokenService.authenticate(email, token)) {
            List<Admin> i1 =  iService.getIngredients(email, token);
        }
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/ingredients")
    public ResponseEntity<String> deleteRecipe (@RequestParam Long id , @RequestParam String token , @RequestParam String email){
        HttpStatus status;
        String message;
        if (tokenService.authenticate(email, token)) {
            iService.deleteIngredients(id, token);
            message = "Ingredients removed successfully";
            status = HttpStatus.OK;
        } else {
            message = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<>(message, status);
    }
}
