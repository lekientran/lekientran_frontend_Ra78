package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`User`")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    // Đây là 1 cột trong DB, có name là address_id và có khai báo FK tới bảng Address qua trường ID
    private Address address;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", address=" + address.getId() + "]";
    }

}
