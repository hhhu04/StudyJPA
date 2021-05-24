package com.example.jpa2.Dto.item;

import com.example.jpa2.Dto.Item;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Data
public class Album extends Item {

    private String artist;

    private String etc;

}
