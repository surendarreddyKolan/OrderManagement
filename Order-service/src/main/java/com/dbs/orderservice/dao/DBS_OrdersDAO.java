package com.dbs.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.commons.entity.DBS_OrdersEntity;

@Repository
public interface DBS_OrdersDAO extends JpaRepository<DBS_OrdersEntity, Long>{
}
