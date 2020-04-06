package com.sekolahbackend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "cart_detail")
@Where(clause = "status = 'ACTIVE'")
public class CartDetail extends Persistence {

    private static final long serialVersionUID = 1L;

    public enum CartDetailStatus {
        CARTED, TRANSACTED
    }

    @JoinColumn(name = "book_id")
    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    private Book book;

    @JoinColumn(name = "cart_id")
    @ManyToOne(targetEntity = Cart.class, fetch = FetchType.LAZY)
    private Cart cart;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private CartDetailStatus cartDetailStatus;
}
