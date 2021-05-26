package com.example.dogram2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "comment_num")
    private Long num;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long communityNum;

    private Long userNum;

    private String userId;

}
