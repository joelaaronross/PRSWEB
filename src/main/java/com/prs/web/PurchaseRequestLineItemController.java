package com.prs.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.prs.business.product.Product;
import com.prs.business.purchaserequest.PurchaseRequest;
import com.prs.business.purchaserequest.PurchaseRequestLineItem;
import com.prs.business.purchaserequest.PurchaseRequestLineItemRepository;
import com.prs.business.purchaserequest.PurchaseRequestRepository;
import com.prs.util.JsonResponse;
@CrossOrigin
@Controller
@RequestMapping(path="/PurchaseRequestLineItems")

public class PurchaseRequestLineItemController {

	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
//	@Autowired
//	private PurchaseRequestRepository purchaseRequestRepository;
	
	@GetMapping("/List")
	public @ResponseBody JsonResponse getAllPurchaseRequestLineItem() {
		try {
			return JsonResponse.getInstance(purchaseRequestLineItemRepository.findAll());
		} catch (Exception e) {
			return JsonResponse.getErrorInstance("PurchaseRequestLineItem list failure:" + e.getMessage(), e);
		}
	}

	@GetMapping("/Get/{id}")
	public @ResponseBody JsonResponse getPurchaseRequestLineItem(@PathVariable int id) {
		try {
			Optional<PurchaseRequestLineItem> purchaseRequestLineItem = purchaseRequestLineItemRepository.findById(id);
			if (purchaseRequestLineItem.isPresent())
				return JsonResponse.getInstance(purchaseRequestLineItem.get());
			else
				return JsonResponse.getErrorInstance("PurchaseRequestLineItem not found for id: " + id, null);
		} catch (Exception e) {
			return JsonResponse.getErrorInstance("Error getting PurchaseRequestLineItem:  " + e.getMessage(), null);
		}
	}


	@PostMapping("/Add")
	public @ResponseBody JsonResponse addPurchaseRequestLineItem(@RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
//		try {
//			updateRequestTotal(purchaseRequestLineItem);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return savePurchaseRequestLineItem(purchaseRequestLineItem);
	}


	@PostMapping("/Change")
	public @ResponseBody JsonResponse updatePurchaseRequestLineItem(@RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
//		try {
//			updateRequestTotal(purchaseRequestLineItem);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return savePurchaseRequestLineItem(purchaseRequestLineItem);
	}

	private @ResponseBody JsonResponse savePurchaseRequestLineItem(@RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
		try {
			purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
			return JsonResponse.getInstance(purchaseRequestLineItem);
		} catch (DataIntegrityViolationException ex) {
			return JsonResponse.getErrorInstance(ex.getRootCause().toString(), ex);
		} catch (Exception ex) {
			return JsonResponse.getErrorInstance(ex.getMessage(), ex);
		}
	}

	@PostMapping("/Remove")
	public @ResponseBody JsonResponse removePurchaseRequestLineItem(@RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
		try {
			purchaseRequestLineItemRepository.delete(purchaseRequestLineItem);
			return JsonResponse.getInstance(purchaseRequestLineItem);
		} catch (Exception ex) {
			return JsonResponse.getErrorInstance(ex.getMessage(), ex);
		}
	}
}
//WORK IN PROGRESS!!!
//	private void updateRequestTotal(PurchaseRequestLineItem purchaseRequestLineItem) throws Exception {
//		Optional<PurchaseRequest> purReq = purchaseRequestRepository.findById(purchaseRequestLineItem.getPurchaseRequest().getId());
//		
//		PurchaseRequest purchaseRequest = purReq.get();
//		List<PurchaseRequestLineItem> lines = new ArrayList<>();
//		lines = purchaseRequestLineItemRepository.findAllByPurchaseRequestId(purchaseRequest.getId());
//		double total = 0;
//		for (PurchaseRequestLineItem line: lines) {
//			Product p = line.getProduct();
//			double lineTotal = line.getQuantity()*p.getPrice();
//			total += lineTotal;
//		}
//		purchaseRequest.setTotal(total);
//		purchaseRequestRepository.save(purchaseRequest);
//	}
//}





