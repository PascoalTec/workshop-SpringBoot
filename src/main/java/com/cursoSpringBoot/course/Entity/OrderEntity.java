package com.cursoSpringBoot.course.Entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import com.cursoSpringBoot.course.Enums.OrderEnums;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT" )
    private Instant moment;

    private Integer orderEnums;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderEntity> items = new HashSet<>();

    public OrderEntity(){
        
    }

    public OrderEntity(Long id, Instant moment, OrderEnums orderEnums, UserEntity client) {
        this.id = id;
        this.moment = moment;
        setOrderEnums(orderEnums);
        this.client = client;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Instant getMoment() {
        return moment;
    }
    
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    
    public OrderEnums getOrderEnums() {
        return OrderEnums.valueOf(orderEnums);
    }

    public void setOrderEnums(OrderEnums orderEnums) {
        if(orderEnums != null){
        this.orderEnums = orderEnums.getCode();
        }
    }
    
    public UserEntity getClient() {
        return client;
    }
    
    public void setClient(UserEntity client) {
        this.client = client;
    }
    
    public Set<OrderEntity> getItems(){
        return items;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        OrderEntity other = (OrderEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    

}
