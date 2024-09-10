package com.example.fruit_store.dao;

import com.example.fruit_store.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {

    // select * from cart where memberid=?
    // 멤버의 장바구니 정보를 가져온다
    public List<Cart> findByMember_Id(String id);

    // select * from cart where memeberid=? and goodsno=?
    // 멤버의 장바구니 안에 있는 특정 상품 레코드를 조회하여 가져온다.
    public Cart findByMember_idAndGoods_no(String id, int gno);
}
