package uz.ilmnajot.crud.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.crud.dto.UserDto;
import uz.ilmnajot.crud.dto.UserForm;
import uz.ilmnajot.crud.message.ApiResponse;
import uz.ilmnajot.crud.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")    //register is done
    public HttpEntity<UserDto> registerUser(@RequestBody UserForm form){
        UserDto userDto = userService.addUser(form);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{id}") //we get user by id
    public HttpEntity<UserDto> getUser(@PathVariable("id") Long id){
        UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public HttpEntity<List<UserDto>> getAllUser(){
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public HttpEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserForm form){
        UserDto userDto = userService.editUser(id, form);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> removeUser(@PathVariable("id") Long id){
        ApiResponse apiResponse = userService.deleteUser(id);
        return ResponseEntity.ok(apiResponse);
    }
}
