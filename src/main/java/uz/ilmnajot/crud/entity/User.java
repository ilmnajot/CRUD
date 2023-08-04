package uz.ilmnajot.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40, name = "name")
    private String name;

    @Column(nullable = false, length = 40, name = "last_name")
    private String lastName;

    @Column(nullable = false, length = 40, name = "username")
    private String email;

    @Column(nullable = false, length = 10, name = "age")
    private Integer age;

    @Column(nullable = false, length = 20, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, length = 50, name = "password")
    private String password;

    public User(String name, String lastName, String email, Integer age, String phoneNumber, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
