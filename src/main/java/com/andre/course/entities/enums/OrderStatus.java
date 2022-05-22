package com.andre.course.entities.enums;

public enum OrderStatus {

	//No banco de dados aparece como Int pois o Java associa um ID automaticamente
	//Isso traz um problema de manutenção pois no futuro caso uma modificação seja feita 
	//no banco de dados ficará errado
	WAITING_PAYMENT(1),
	PAID(2), 
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(Integer code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus os : OrderStatus.values()) {
			if (os.getCode() == code) {
				return os;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
