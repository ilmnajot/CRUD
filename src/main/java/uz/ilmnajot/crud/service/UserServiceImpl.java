package uz.ilmnajot.crud.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.crud.dto.UserDto;
import uz.ilmnajot.crud.dto.UserForm;
import uz.ilmnajot.crud.entity.User;
import uz.ilmnajot.crud.message.ApiResponse;
import uz.ilmnajot.crud.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto addUser(UserForm form) {
        if (userRepository.existsUserByEmail(form.getEmail())) {
            return null;
        } else {
            User user = new User(
                    form.getName(),
                    form.getLastName(),
                    form.getEmail(),
                    form.getAge(),
                    form.getPhoneNumber(),
                    form.getPassword()
            );
            User savedUser = userRepository.save(user);
            UserDto userDto = UserDto.userToUserDto(savedUser);
            return userDto;
        }

    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        } else {
            User user = optionalUser.get();
            UserDto userDto = UserDto.userToUserDto(user);
            return userDto;
        }
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = UserDto.userToUserDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public UserDto editUser(Long id, UserForm form) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        } else {
            User user = optionalUser.get();
            user.setId(id);
            user.setName(form.getName());
            user.setLastName(form.getLastName());
            user.setEmail(form.getEmail());
            user.setAge(form.getAge());
            user.setPhoneNumber(form.getPhoneNumber());
            user.setPassword(form.getPassword());
            User savedUser = userRepository.save(user);
            UserDto userDto = UserDto.userToUserDto(savedUser);
            return userDto;
        }
    }


    @Override
    public ApiResponse deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return new ApiResponse("user successfully deleted", true);
        } else {
            return new ApiResponse("user not found", false);
        }
    } //THANK YOU
}
