package com.prs.web;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prs.business.purchaserequest.PurchaseRequest;

import com.prs.business.purchaserequest.PurchaseRequestRepository;

import com.prs.util.JsonResponse;


@CrossOrigin
@Controller
@RequestMapping(path="/PurchaseRequests")

public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;

	@GetMapping("/List")
	public @ResponseBody JsonResponse getAllUsers() {
		try {
			return JsonResponse.getInstance(purchaseRequestRepository.findAll());
		} catch (Exception e) {
			return JsonResponse.getErrorInstance("Purchase Request list failure:" + e.getMessage(), e);
		}
	}
	
//	@GetMapping("/ListReview")
//	public @ResponseBody JsonResponse getAllPurchaseRequestsForReview(@RequestParam int id) {
//		try {
//			return JsonResponse.getInstance(purchaseRequestRepository.findAllByUserIdNotAndStatus(id, "Review"));
//		} catch (Exception e) {
//			return JsonResponse.getErrorInstance("Purchase Request list failure:" + e.getMessage(), e);
//		}
//	}
	
	@GetMapping("/Get/{id}")
	public @ResponseBody JsonResponse getPurchaseRequest(@PathVariable int id) {
		try {
			Optional<PurchaseRequest> purchaseRequest = purchaseRequestRepository.findById(id);
			if (purchaseRequest.isPresent())
				return JsonResponse.getInstance(purchaseRequest.get());
			else
				return JsonResponse.getErrorInstance("Purchase Request not found for id: " + id, null);
		} catch (Exception e) {
			return JsonResponse.getErrorInstance("Error getting Purchase Request:  " + e.getMessage(), null);
		}
	}

	@PostMapping("/Add")
	public @ResponseBody JsonResponse addPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		return savePurchaseRequest(purchaseRequest);
	}

	@PostMapping("/Change")
	public @ResponseBody JsonResponse updatePurchaseRequestLineItem(@RequestBody PurchaseRequest purchaseRequest) {
		return savePurchaseRequest(purchaseRequest);
	}

	private @ResponseBody JsonResponse savePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		try {
			purchaseRequestRepository.save(purchaseRequest);
			return JsonResponse.getInstance(purchaseRequest);
		} catch (DataIntegrityViolationException ex) {
			return JsonResponse.getErrorInstance(ex.getRootCause().toString(), ex);
		} catch (Exception ex) {
			return JsonResponse.getErrorInstance(ex.getMessage(), ex);
		}
	}
	@PostMapping("/Remove")
	public @ResponseBody JsonResponse removePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		try {
			purchaseRequestRepository.delete(purchaseRequest);
			return JsonResponse.getInstance(purchaseRequest);
		} catch (Exception ex) {
			return JsonResponse.getErrorInstance(ex.getMessage(), ex);
		}
	}
	}

//	//WORK IN PROGRESS
//	@PostMapping("/SubmitForReview")
//	public @ResponseBody String submitForReviewPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
//		purchaseRequestRepository.submitForReview(purchaseRequest);
//		return "purchaseRequest submitForReview";
//	}
//
//	@PostMapping("/ApprovePR")
//	public @ResponseBody String ApprovePR(@RequestBody PurchaseRequest purchaseRequest) {
//		purchaseRequestRepository.submitForReview(purchaseRequest);
//		return "purchaseRequest ApprovePR";
//	}
//	
//	@PostMapping(path="/RejectPR") 
//	public @ResponseBody JsonResponse rejectPR (@RequestBody PurchaseRequest purchaseRequest) {
//		pr.setStatus(PurchaseRequest.STATUS_REJECTED);
//		return savePurchaseRequest(purchaseRequest);
//	}
//}
