package com.escruadronlobo.devs.parcial2.models.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID code;

    @Column(name = "username")
	private String username;

    @Column(name = "email")
	private String email;

    @Column(name = "password")
	private String password;

    @OneToMany(mappedBy = "usercode", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private List<PlayList> playLists;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

