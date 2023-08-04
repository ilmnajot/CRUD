package uz.ilmnajot.crud.service;

import uz.ilmnajot.crud.dto.UserDto;
import uz.ilmnajot.crud.dto.UserForm;
import uz.ilmnajot.crud.message.ApiResponse;

import java.util.List;

public interface UserService {
    UserDto addUser(UserForm form);

    UserDto getUser(Long id);

    List<UserDto> getUsers();

    UserDto editUser(Long id, UserForm form);

    ApiResponse deleteUser(Long id);
}
