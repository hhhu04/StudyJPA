package com.example.dogram2.repository;

import com.example.dogram2.dto.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public int save(Comment comment){
        em.persist(comment);
        return 1;
    }

    public List<Comment> findList(Long num){
        return em.createQuery("select c from Comment c where c.community=:community",Comment.class)
                .setParameter("community",num)
                .getResultList();
    }


}
