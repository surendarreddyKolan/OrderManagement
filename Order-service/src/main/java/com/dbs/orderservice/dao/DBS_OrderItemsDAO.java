package com.dbs.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.commons.entity.DBS_OrderItemsEntity;

public interface DBS_OrderItemsDAO extends JpaRepository<DBS_OrderItemsEntity, Long>{
}
