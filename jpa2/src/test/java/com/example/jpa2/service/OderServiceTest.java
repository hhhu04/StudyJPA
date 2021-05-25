package com.example.jpa2.service;

import com.example.jpa2.Dto.Address;
import com.example.jpa2.Dto.Member;
import com.example.jpa2.Dto.Order;
import com.example.jpa2.Dto.OrderStatus;
import com.example.jpa2.Dto.item.Book;
import com.example.jpa2.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    private OderService oderService;

    @Autowired
    OrderRepository repository;

    @Test
    public void 상품주문() throws Exception{
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);

        Book book = new Book();
        book.setName("시골 jps");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;

        Long orderId = oderService.order(member.getId(), book.getId(), orderCount);

        Order getOrder = repository.findOne(orderId);

//        assertEquals("wwwww", OrderStatus.ORDER, getOrder.get);
    }


    @Test
    public void 주문취소() throws Exception{

    }


    @Test
    public void 재고초과() throws Exception{

    }

}