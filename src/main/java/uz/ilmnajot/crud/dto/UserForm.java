package uz.ilmnajot.crud.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm {

    private String name;

    private String lastName;

    private String email;

    private Integer age;

    private String phoneNumber;

    private String password;
}
