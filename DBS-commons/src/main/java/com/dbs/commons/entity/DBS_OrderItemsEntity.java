package com.dbs.commons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DBS_ORDER_ITEMS_TB")
public class DBS_OrderItemsEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@Column(name = "customer_name", nullable = false)
		private String productCode;
		@Column(name = "customer_name", nullable = false)
		private String productName;
		@Column(name = "customer_name", nullable = false)
		private Integer quantity;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getProductCode() {
			return productCode;
		}
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
	}