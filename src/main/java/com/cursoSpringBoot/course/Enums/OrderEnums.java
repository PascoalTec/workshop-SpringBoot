package com.cursoSpringBoot.course.Enums;

public enum OrderEnums {
    
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderEnums(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderEnums valueOf(int code){
        for (OrderEnums value : OrderEnums.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderEnum code");
    }
}
