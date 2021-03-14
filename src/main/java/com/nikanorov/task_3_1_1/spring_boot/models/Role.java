package com.nikanorov.task_3_1_1.spring_boot.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role
        implements GrantedAuthority
{

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY);
//    @Column(name = "id");
    private Long id;

    @Column
    private String role;

    public Role() {
    }
    @Transient
    @ManyToMany
    @JoinTable(name = "userz_roles"
            ,joinColumns =@JoinColumn(name = "roles_id")
            ,inverseJoinColumns = @JoinColumn(name = "userz_id")
    )
    private Set<User> users;

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
//        return (role.replaceAll("ROLE_","")+ " ");
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return role ;
    }
}
