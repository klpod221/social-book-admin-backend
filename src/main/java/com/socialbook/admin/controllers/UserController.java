package com.socialbook.admin.controllers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.socialbook.admin.models.UserModel;
import com.socialbook.admin.payload.request.UserCreateRequest;
import com.socialbook.admin.payload.request.UserUpdateRequest;
import com.socialbook.admin.payload.response.MessageResponse;
import com.socialbook.admin.repository.UserAccountRepository;
import com.socialbook.admin.services.UUID_handing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin/api/app")
public class UserController {

    @Autowired
    UserAccountRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    String defaultPassword = "socialbook";

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUser(@RequestParam(required = false) String search,
            @RequestParam(required = false) Integer activeStatus) {
        try {
            List<UserModel> users = new ArrayList<UserModel>();

            if (search == null || search.trim().isEmpty())
                if (activeStatus == null)
                    userRepository.findAll().forEach(users::add);
                else
                    userRepository.findByIsActive(activeStatus).forEach(users::add);
            else {
                if (activeStatus == null)
                    userRepository.searchUser(search).forEach(users::add);
                else
                    userRepository.searchUserWithStatus(search, activeStatus).forEach(users::add);
            }

            if (users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) {
        Optional<UserModel> userData = userRepository.findById(id);

        if (userData.isPresent())
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateRequest request) throws ParseException {
        if (userRepository.existsByUsername(request.getUsername()))
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));

        if (userRepository.existsByEmail(request.getEmail()))
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));

        Timestamp getTimestamp = new Timestamp(System.currentTimeMillis());
        String timestamp = getTimestamp.toString();

        UserModel user = new UserModel(
                UUID_handing.UUID_Generator(),
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getUsername(),
                encoder.encode(defaultPassword),
                request.getAvatarUrl(),
                timestamp,
                request.getIsActive());

        userRepository.save(user);

        return ResponseEntity.ok().body(new MessageResponse("User created successfully!"));
    }

    @PutMapping("/users/update_account/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateRequest request) {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isPresent()) {
            UserModel _user = user.get();
            _user.setFirstName(request.getFirstName());
            _user.setLastName(request.getLastName());
            _user.setEmail(request.getEmail());
            _user.setUsername(request.getUsername());
            _user.setAvatarUrl(request.getAvatarUrl()); //
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/set_default_password/{id}")
    public ResponseEntity<UserModel> setDefaultPassword(@PathVariable("id") Long id) throws ParseException {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isPresent()) {
            UserModel _user = user.get();
            _user.setPassword(encoder.encode(defaultPassword));
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/change_active_status/{id}")
    public ResponseEntity<UserModel> changeActiveStatus(@PathVariable("id") Long id) {

        Optional<UserModel> user = userRepository.findById(id);

        if (user.isPresent()) {
            UserModel _user = user.get();

            if (_user.getIsActive() == 1)
                _user.setIsActive(0);
            else
                _user.setIsActive(1);

            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
