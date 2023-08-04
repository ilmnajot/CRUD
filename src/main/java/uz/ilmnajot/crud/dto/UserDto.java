package uz.ilmnajot.crud.dto;

import lombok.Getter;
import lombok.Setter;
import uz.ilmnajot.crud.entity.User;

@Setter
@Getter
public class UserDto {

    //this class is returing class, so we should not return password

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private Integer age;


    public static UserDto userToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());

        return dto;
    }

}
