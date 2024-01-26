package com.m2ouazar.Sport.QCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.m2ouazar.Sport.QCM.service.userService;
import com.m2ouazar.Sport.QCM.model.user;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {



        private final userService userService;

        @Autowired
        public userController(userService userService) {
            this.userService = userService;
        }

        @GetMapping
        public ResponseEntity<List<user>> getAllusers(){
            List<user> users= userService.getAllusers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        //GET user BY ID
        @GetMapping("/{id}")
        public ResponseEntity<user> userById(@PathVariable String id){
            user user= userService.userById(id);

            if (user != null){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<user>(user, HttpStatus.NOT_FOUND);
            }
        }

        //POST user
        @PostMapping
        public ResponseEntity<user> postuser(@RequestBody user userBody){
            user user= userService.saveuser(userBody);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }


        //PUT user
        @PutMapping("/{id}")
        public ResponseEntity<user> putuser(@RequestBody user userBody, @PathVariable String id){
            user user= userService.updateuser(id, userBody);
            if (user != null){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }

            else return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<user> putuser(@PathVariable String id){
            userService.deleteuser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
