package com.example.fruit_store.service;

import com.example.fruit_store.dao.CartDAO;
import com.example.fruit_store.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartDAO cartDAO;

    public List<Cart> cartList(String id) {
        return cartDAO.findByMember_Id(id);
    }   //멤버의 장바구니 정보 가져오기

    public void insert(Cart c) {
        c.setQty(1);    // 일단 수량을 한개로 정했지만
                        // TODO : 추후 특정한 개수를 더하는 로직으로 수정
        String uid = c.getMember().getId();
        int gno = c.getGoods().getNo();
        Cart old = cartDAO.findByMember_idAndGoods_no(uid, gno);
        if (old != null) {
            c.setQty(old.getQty()+1);
            c.setNo(old.getNo()+1);
        }
        cartDAO.save(c);
    }


}
