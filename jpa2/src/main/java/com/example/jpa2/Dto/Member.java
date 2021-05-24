package com.example.jpa2.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String Name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> der = new ArrayList<>();

}
