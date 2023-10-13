package com.cursoSpringBoot.course.Entity.pk;

import java.io.Serializable;

import com.cursoSpringBoot.course.Entity.OrderEntity;
import com.cursoSpringBoot.course.Entity.ProductEntity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderItemPK implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    
    public OrderEntity getOrderEntity() {
        return orderEntity;
    }
    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
    public ProductEntity getProductEntity() {
        return productEntity;
    }
    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderEntity == null) ? 0 : orderEntity.hashCode());
        result = prime * result + ((productEntity == null) ? 0 : productEntity.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItemPK other = (OrderItemPK) obj;
        if (orderEntity == null) {
            if (other.orderEntity != null)
                return false;
        } else if (!orderEntity.equals(other.orderEntity))
            return false;
        if (productEntity == null) {
            if (other.productEntity != null)
                return false;
        } else if (!productEntity.equals(other.productEntity))
            return false;
        return true;
    }

    
}
