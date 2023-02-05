package ru.gb.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @CreationTimestamp
    @Column(name ="created_at")
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name ="updated_at" )
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name ="users_roles",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;



}
