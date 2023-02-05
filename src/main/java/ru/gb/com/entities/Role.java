package ru.gb.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "type")
    String type;

    @CreationTimestamp
    @Column(name ="created_at")
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name ="updated_at" )
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name ="users_roles",
            joinColumns = @JoinColumn(name ="role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Role> role;

}
