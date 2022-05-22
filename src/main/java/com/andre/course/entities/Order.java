package com.andre.course.entities;

import java.io.Serializable;
//a partir do java 8 maneira melhor para tratar tempo
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andre.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//para evitar conflitos com nomenclatura SQL
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = -6300838794227815083L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	//Para manter enum atrelado diretamente com o DB
	private Integer orderStatus;
	
	//associações muitos para um com o usuário
	@ManyToOne
	//para gerar a chave estrangeira
	@JoinColumn(name = "client_id")
	private User client;
	
	public Order() { }
	
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
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

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", client=" + client + "]";
	}
	
	
	
	
	
}
