package com.backend.osahaneat.Entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable

public class KeyOrderItem implements Serializable {
    @Column(name="order_id")
    private int orderId;

    @Column(name="res_id")
    private int resId;

    public KeyOrderItem() {}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public KeyOrderItem(int orderId, int resId) {
        this.orderId = orderId;
        this.resId = resId;
    }
}
