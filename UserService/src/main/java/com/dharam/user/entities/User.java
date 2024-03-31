package com.dharam.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @Column(name = "id")
    private String userID;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "name")
    private String userName;
    @Column(name = "description")
    private String userDesc;

}
