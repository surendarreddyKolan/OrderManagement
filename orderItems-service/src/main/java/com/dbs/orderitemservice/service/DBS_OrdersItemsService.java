package com.dbs.orderitemservice.service;

import java.util.List;

import com.dbs.commons.exception.DBS_RecordNotFoundException;
import com.dbs.commons.vo.DBS_OrderItemsVO;

public interface DBS_OrdersItemsService {
	
	public DBS_OrderItemsVO create(DBS_OrderItemsVO ordersVO) ;
	public List<DBS_OrderItemsVO> getAll();
	public DBS_OrderItemsVO getById(Long id) throws DBS_RecordNotFoundException;
	
}
