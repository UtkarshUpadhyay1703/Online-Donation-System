package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.pojos.BankTransaction;
import com.app.pojos.Bidding;
import com.app.repository.BiddingRepository;

@Service
@Transactional
public class BiddingServiceImpl implements BiddingService {
	
	@Autowired
	BiddingRepository bidRepo;
	
	@Autowired
	BankTransactionService bankService;

	@Override
	public Bidding saveBid(Bidding bidding) {
		return bidRepo.save(bidding);
	}
	
	@Override
	public List<Bidding> getRecentBiddingUpToFiveBooks(){
		LocalDateTime biddingStartDate= LocalDateTime.now().minusDays(15);
		System.out.println("2 days before = "+biddingStartDate);
		return bidRepo.getTopFiveBookBidders(biddingStartDate);
	}
	@Override
	public List<Bidding> getRecentBiddingUpToFiveCloths(){
		LocalDateTime biddingStartDate= LocalDateTime.now().minusDays(2);
		System.out.println("2 days before = "+biddingStartDate);
		return bidRepo.getTopFiveClothsBidders(biddingStartDate);
	}
	@Override
	public List<Bidding> getRecentBiddingUpToFiveToys(){
		LocalDateTime biddingStartDate= LocalDateTime.now().minusDays(2);
		System.out.println("2 days before = "+biddingStartDate);
		return bidRepo.getTopFiveToyBidders(biddingStartDate);
	}
	@Override
	public List<Bidding> getRecentBiddingUpToFiveCycles(){
		LocalDateTime biddingStartDate= LocalDateTime.now().minusDays(2);
		System.out.println("2 days before = "+biddingStartDate);
		return bidRepo.getTopFiveCycleBidders(biddingStartDate);
	}
	@Override
	public boolean setBiddingStatusToSelectedBook(Long id) {
		curBalance=bankService.getBalance();
		System.out.println("Current balance = "+curBalance +"id = "+id);
		double bookAllocated=(curBalance-30000)*.3;
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
		System.out.println("Book allocated = "+bookAllocated + "low price = "+book.getLowPriceNotebook());
		int qty=(int) (bookAllocated/(book.getLowPriceNotebook()));
//		bidRepo.setBiddingQuantity(qty, id);
		System.out.println("quantity = "+qty);
		bidRepo.setBiddingStatusAndQuantity("SELECTED",qty, id);
		return true;
	}
	
	
	@Override
	public boolean setBiddingStatusToSelectedCloth(Long id) {
		curBalance=bankService.getBalance();

		double bookAllocated=(curBalance-30000)*.3;
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));

		int qty=(int) (bookAllocated/book.getLowPriceCloth());
//		bidRepo.setBiddingQuantity(qty, id);
		System.out.println("quantity = "+qty);
		bidRepo.setBiddingStatusAndQuantity("SELECTED",qty, id);
		return true;
	}
	
	
	@Override
	public boolean setBiddingStatusToSelectedToy(Long id) {
		curBalance=bankService.getBalance();
		double bookAllocated=(curBalance-30000)*.2;
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
		int qty=(int) (bookAllocated/book.getLowPriceToy());
//		bidRepo.setBiddingQuantity(qty, id);
		System.out.println("quantity = "+qty);
		bidRepo.setBiddingStatusAndQuantity("SELECTED",qty, id);
		return true;
	}
	
	@Override
	public boolean setBiddingStatusToSelectedCycle(Long id) {
		curBalance=bankService.getBalance();
		double bookAllocated=(curBalance-30000)*.2;
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
		int qty=(int) (bookAllocated/book.getLowPriceCycle());
//		bidRepo.setBiddingQuantity(qty, id);
		System.out.println("quantity = "+qty);
		bidRepo.setBiddingStatusAndQuantity("SELECTED",qty, id);
		return true;
	}
	@Override
	public List<Bidding> getAllSelectedBidders(){
		return bidRepo.getSelectedBidders(LocalDateTime.now().minusDays(15));
	}
	double curBalance;
	
	@Override
	public boolean setBiddingStatusToApproveBook(Long id) {
		bidRepo.setBiddingStatus("RECEIVED", id);
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
		double bookMoney=book.getLowPriceNotebook()*book.getQuantity();
		BankTransaction bank=new BankTransaction();
		bank.setVendor(book.getVendor());
		bank.setAmountSend(bookMoney);
		bankService.saveTransaction(bank);
		return true;
	}
	
	@Override
	public boolean setBiddingStatusToApproveCloth(Long id) {
		bidRepo.setBiddingStatus("RECEIVED", id);
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
		double bookMoney=book.getLowPriceCloth()*book.getQuantity();
		BankTransaction bank=new BankTransaction();
		bank.setVendor(book.getVendor());
		bank.setAmountSend(bookMoney);
		bankService.saveTransaction(bank);
		return true;
	}
	
	@Override
	public boolean setBiddingStatusToApproveToy(Long id) {
		bidRepo.setBiddingStatus("RECEIVED", id);
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
		double bookMoney=book.getLowPriceToy()*book.getQuantity();
		BankTransaction bank=new BankTransaction();
		bank.setVendor(book.getVendor());
		bank.setAmountSend(bookMoney);
		bankService.saveTransaction(bank);
		return true;
	}
	
	@Override
	public boolean setBiddingStatusToApproveCycle(Long id) {
		bidRepo.setBiddingStatus("RECEIVED", id);
		Bidding book= bidRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
		double bookMoney=book.getLowPriceCycle()*book.getQuantity();
		BankTransaction bank=new BankTransaction();
		bank.setVendor(book.getVendor());
		bank.setAmountSend(bookMoney);
		bankService.saveTransaction(bank);
		return true;
	}
}
