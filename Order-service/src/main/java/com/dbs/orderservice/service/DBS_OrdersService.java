package com.dbs.orderservice.service;

import java.util.List;

import com.dbs.commons.exception.DBS_RecordNotFoundException;
import com.dbs.commons.vo.DBS_OrdersVO;

public interface DBS_OrdersService {
	
	public DBS_OrdersVO create(DBS_OrdersVO ordersVO) ;
	public DBS_OrdersVO getById(Long orderBYId) throws DBS_RecordNotFoundException;
	public List<DBS_OrdersVO> getAll();
	
}
