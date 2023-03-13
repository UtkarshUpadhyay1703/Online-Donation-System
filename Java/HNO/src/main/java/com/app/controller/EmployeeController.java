package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Employee.EmployeeDto;
import com.app.dto.Employee.EmployeeLoginDto;
import com.app.pojos.Bidding;
import com.app.pojos.Employee;
import com.app.pojos.ItemDonation;
import com.app.repository.BankTransactionRepository;
import com.app.repository.ItemDonationRepository;
import com.app.service.BiddingService;
import com.app.service.EmployeeService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private BiddingService bidService;

	@Autowired
	private BankTransactionRepository bankRepo;
//	@Autowired
//	private BankTransactionService bankService;

	@Autowired
	private ItemDonationRepository itemRepo;
	
	@Autowired
	private EmployeeService empServ;

	public EmployeeController() {
		System.out.println("def cons" + getClass());
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		System.out.println("in all dono");
		return empServ.getAllEmployees();
	}

	@PostMapping
	public Employee addEmployee(@RequestBody EmployeeDto employee) {
		System.out.println("Employee add " + employee);
		Employee empno = mapper.map(employee, Employee.class);
		empno.setEmployeeStatus(true);
		return empServ.addEmployee(empno);
	}

	@DeleteMapping("/{empId}")
	public String deleteDonor(@PathVariable Long empId) {
		System.out.println("in del id = " + empId);
		return empServ.deleteEmployee(empId);
	}

	@GetMapping("/{empId}")
	public Employee getOneEmployee(@PathVariable Long empId) {
		return empServ.getOneEmployee(empId);
	}

	@PutMapping("/update/{empId}")
	public Employee updateEmployee(@PathVariable Long empId,@RequestBody Employee emp) {
		emp.setId(empId);
		return empServ.updateEmployee(emp);
	}

	@PostMapping("/signIn")
	public Employee validateEmployee(@RequestBody EmployeeLoginDto empLogIn) {
		System.out.println("login" + empLogIn);
		return empServ.validateEmp(empLogIn);
	}

	@GetMapping("/Employeetrue")
	public List<Employee> getAllTrueEmployee() {
		System.out.println("inside true");
		return empServ.getAllTrueEmployees();
	}

	// delete
	@PutMapping("/{empId}")
	public String deleteFalseEmployee(@PathVariable Long empId) {
		System.out.println("inside false");
		return empServ.deleteFalseEmployee(empId);
	}

	@GetMapping("/balance")
	public double findBalance() {
		return bankRepo.findLatestBalance().getBalance();
	}

//	@PostMapping("/Transaction/withdraw/Employee")
//	public BankTransaction withdrawBankTransaction(@RequestBody EmployeeSendDto send) {
//		System.out.println("inside Trax in Employee send");
//		BankTransaction transaction = mapper.map(send, BankTransaction.class);
//		
//		//Not right but check how to do with jwt 
//		if(bankService.validateEmployee(transaction.getEmployee().getId())){
//			System.out.println("after validating inside transaction");
//		return empServ.withdrawBankTransaction(transaction);
//		}
//		return null;
//	}

//	@PostMapping("/Transaction/withdraw/{empId}")
//	public BankTransaction withdrawBankTransaction(@PathVariable String empId) {
//		System.out.println("inside addTrax in Employee empId"+empId);
////		BankTransaction transaction = mapper.map(send, BankTransaction.class);
//		
//		//Not right but check how to do with jwt 
//		if(bankService.validateEmployee(empId)){
//		return empServ.withdrawBankTransaction(transaction);
//		}
//		return null;
//	}
	@GetMapping("/books")
	public List<Bidding> getAllTopFiveBooks() {
		System.out.println("inside getAllFiveBooks");
		return bidService.getRecentBiddingUpToFiveBooks();
	}

	@GetMapping("/Cloths")
	public List<Bidding> getAllTopFiveCloths() {
		System.out.println("inside getAllFiveBooks");
		return bidService.getRecentBiddingUpToFiveCloths();
	}

	@GetMapping("/toys")
	public List<Bidding> getAllTopFiveToys() {
		System.out.println("inside getAllFiveBooks");
		return bidService.getRecentBiddingUpToFiveToys();
	}

	@GetMapping("/cycles")
	public List<Bidding> getAllTopFiveCycles() {
		System.out.println("inside getAllFiveBooks");
		return bidService.getRecentBiddingUpToFiveCycles();
	}

	@PutMapping("/setSelectedBook/{bidId}")
	public boolean setStatusToSelectedBook(@PathVariable Long bidId) {
		System.out.println("inside book set status");
		return bidService.setBiddingStatusToSelectedBook(bidId);
	}

	@PutMapping("/setSelectedCloth/{bidId}")
	public boolean setStatusToSelectedCloth(@PathVariable Long bidId) {
		System.out.println("inside set status");
		return bidService.setBiddingStatusToSelectedCloth(bidId);
	}

	@PutMapping("/setSelectedToy/{bidId}")
	public boolean setStatusToSelectedToy(@PathVariable Long bidId) {
		System.out.println("inside set status");
		return bidService.setBiddingStatusToSelectedToy(bidId);
	}

	@PutMapping("/setSelectedCycle/{bidId}")
	public boolean setStatusToSelectedCycle(@PathVariable Long bidId) {
		System.out.println("inside set status");
		return bidService.setBiddingStatusToSelectedCycle(bidId);
	}

	@GetMapping("/getSelected")
	public List<Bidding> getAllSelected() {
		return bidService.getAllSelectedBidders();
	}

	@PutMapping("/setReceived/Books/{bidId}")
	public boolean setStatusToReceivedBook(@PathVariable Long bidId) {
		System.out.println("inside set status to approve");
		return bidService.setBiddingStatusToApproveBook(bidId);
	}

	@PutMapping("/setReceived/Cloths/{bidId}")
	public boolean setStatusToReceivedCloth(@PathVariable Long bidId) {
		System.out.println("inside set status to approve");
		return bidService.setBiddingStatusToApproveCloth(bidId);
	}

	@PutMapping("/setReceived/Toys/{bidId}")
	public boolean setStatusToReceivedToy(@PathVariable Long bidId) {
		System.out.println("inside set status to approve");
		return bidService.setBiddingStatusToApproveToy(bidId);
	}

	@PutMapping("/setReceived/Cycles/{bidId}")
	public boolean setStatusToReceivedCycle(@PathVariable Long bidId) {
		System.out.println("inside set status to approve");
		return bidService.setBiddingStatusToApproveCycle(bidId);
	}
	
	@GetMapping("/ItemDonation")
	public List<ItemDonation> getAllItems(){
		System.out.println("inside Get All Itemdonation");
		return itemRepo.findAll();
	}

}
