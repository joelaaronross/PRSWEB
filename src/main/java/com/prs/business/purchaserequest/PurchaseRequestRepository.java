package com.prs.business.purchaserequest;

import org.springframework.data.repository.CrudRepository;



	public interface PurchaseRequestRepository extends CrudRepository<PurchaseRequest, Integer> {
		
//		Object findAllByUserIdNotAndStatus(int id, String status);

	}

