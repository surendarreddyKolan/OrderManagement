package com.dbs.orderitemservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dbs.commons.entity.DBS_OrderItemsEntity;
import com.dbs.commons.exception.DBS_RecordNotFoundException;
import com.dbs.commons.vo.DBS_OrderItemsVO;
import com.dbs.orderitemservice.dao.DBS_OrderItemsDAO;
import com.dbs.orderitemservice.service.DBS_OrdersItemsService;

public class DBS_OrderItemsServiceImpl implements DBS_OrdersItemsService{

	@Autowired
	private DBS_OrderItemsDAO orderItemsDAO;
	
	@Override
	public DBS_OrderItemsVO create(DBS_OrderItemsVO orderItemsVO) {
		DBS_OrderItemsVO convertEntity2VO = null;
		DBS_OrderItemsEntity convertVO2Entity = convertVO2Entity(orderItemsVO);
		DBS_OrderItemsEntity orderItemsEntity = orderItemsDAO.save(convertVO2Entity);
		convertEntity2VO = convertEntity2VO(orderItemsEntity);
		return convertEntity2VO;
	}

	@Override
	public DBS_OrderItemsVO getById(Long orderItemId) throws DBS_RecordNotFoundException {
		Optional<DBS_OrderItemsEntity> orderItemsEntity = orderItemsDAO.findById(orderItemId);
		 if(orderItemsEntity.isPresent()) {
			 DBS_OrderItemsVO orderItemsVO = convertEntity2VO(orderItemsEntity.get());
	            return orderItemsVO;
	        } else {
	            throw new DBS_RecordNotFoundException("No Order Items available with Order Item Id "+orderItemId);
	        }
	}

	@Override
	public List<DBS_OrderItemsVO> getAll() {
		List<DBS_OrderItemsVO> orderItemVos = new ArrayList<DBS_OrderItemsVO>();
		List<DBS_OrderItemsEntity> orderItemsList = (List<DBS_OrderItemsEntity>)orderItemsDAO.findAll();
        
        if(!orderItemsList.isEmpty()) {
        	for (DBS_OrderItemsEntity orderEntity : orderItemsList) {
        		DBS_OrderItemsVO orderItemVo = convertEntity2VO(orderEntity);
        		orderItemVos.add(orderItemVo);
    		}
        } 
		return orderItemVos;
	}

	private DBS_OrderItemsEntity convertVO2Entity(DBS_OrderItemsVO orderItemsVO) {
		DBS_OrderItemsEntity orderItemsEntity = new DBS_OrderItemsEntity();
		BeanUtils.copyProperties(orderItemsVO, orderItemsEntity);
		return orderItemsEntity;
	}

	private DBS_OrderItemsVO convertEntity2VO(DBS_OrderItemsEntity orderItemsEntity) {
		DBS_OrderItemsVO orderItemsVO = new DBS_OrderItemsVO();
		BeanUtils.copyProperties(orderItemsEntity, orderItemsVO);
		return orderItemsVO;
	}
}
