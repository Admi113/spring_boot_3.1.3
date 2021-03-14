package com.nikanorov.task_3_1_1.spring_boot.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "userz")

public class User implements UserDetails {
    @Column(name = "name")
    @NotEmpty(message = "shoudnt be empty")
    @Size(min = 2, max = 30, message = "2> Name size >30")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "shoudnt be empty")
    @Size(min = 2, max = 50, message = "2> Surname >30")
    private String surname;

    @Column(name = "age")
    //    @Size(min = 0, message = "age shoul be greather than 0")
    private int age;
    //    @Email() проверяет через регулярки
    @Column(name = "email")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userz_roles"
            , joinColumns = @JoinColumn(name = "userz_id")
            , inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String name, String surname, int age, int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public void setRoles(List<Role> roles) {
        this.roles = new HashSet<Role>(roles);
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public List<Role> getRolesList() {
        List<Role> roleList = new ArrayList<>();
        roleList.addAll(getRoles());

        return roleList;
    }

    public String getRolesWithoutPrefix() {
        StringBuilder result = new StringBuilder();
        for (Role role : getRolesList()) {
            result.append(role.getRole()
                    .replaceAll("ROLE_", "") + " ");
        }
        return result.toString();
    }

    public User getFromListById(List<User> users, int id) {
        return users.stream().filter(u -> u.getId() == id).collect(Collectors.toList()).get(0);

    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
