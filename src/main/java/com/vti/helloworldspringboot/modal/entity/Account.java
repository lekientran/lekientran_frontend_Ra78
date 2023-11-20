package com.vti.helloworldspringboot.modal.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name= "`Account`")
@Getter
@Setter
@ToString
@Data // Gồm cả 3 anotation là Getter, Setter, toString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "avatar", length = 500, nullable = false)
    private String avatar;

    @Column(name = "address", length = 200)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;
}
