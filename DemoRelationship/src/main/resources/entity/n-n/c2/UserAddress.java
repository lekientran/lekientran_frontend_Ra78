package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "UserAddress")
public class UserAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserAddressKey id;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("address_id")
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "registered_at")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date registeredAt;

	public UserAddress() {
	}

	public UserAddressKey getId() {
		return id;
	}

	public void setId(UserAddressKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	@Embeddable
	public static class UserAddressKey implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "user_id", nullable = false)
		private int userId;

		@Column(name = "address_id", nullable = false)
		private int addressId;

		public UserAddressKey() {
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

	}
}
