
package com.lti.project.usercontroller;

import java.sql.Date;
import java.util.List;

import javax.xml.ws.Holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;
import com.lti.project.bean.Policy;
import com.lti.project.bean.User;
import com.lti.project.bean.Vehicle;
import com.lti.project.exceptions.HrExceptions;
import com.lti.project.service.AdminService;
import com.lti.project.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private UserService user_service;
	
	@GetMapping(value="/plans",produces="application/json")
	public List<Plan> getPlanList(){
		List<Plan> planList = null; 
		try {
			planList =  service.getAllPlans();
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return planList;
	}
	
	@PostMapping(value="/addplan",consumes="application/json")
	public boolean addPlan(@RequestBody Plan p) {
		boolean res = false;
		try {
			res = service.addPlan(p);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/updateplan/{id}/{amt}")
	public int updatePlan(@PathVariable int id,@PathVariable Long amt) {
		int res = 0;
		try {
			res = service.updatePlan(id,amt);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/deleteplan/{id}")
	public boolean deletePlan(@PathVariable int id) {
		boolean res = false;
		try {
			res = service.deletePlan(id);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/findAmt/{vehicle}")
	public List<Long> getPlan(@PathVariable String vehicle){
		List<Long> lst = null; 
		try {
			lst =  service.estimatePlan(vehicle);
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	@GetMapping(value="/findAmt/{vehicle}/{plan}")
	public Long getPlanAmt(@PathVariable String vehicle,@PathVariable String plan){
		Long res = null; 
		try {
			res =  service.PlanAmount(vehicle,plan);
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/users",produces="application/json")
	public List<User> getUserList(){
		List<User> userList = null; 
		try {
			userList =  user_service.getAllUsers();
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@PostMapping(value="/adduser",consumes="application/json")
	public boolean adduser(@RequestBody User u) {
		boolean res = false;
		try {
			res = user_service.addUser(u);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	//updated checkLogin
	@RequestMapping(value="/checklogin/{EnteredEmail}/{EnteredPassword}",method= RequestMethod.GET)
	public User checkLogin(@PathVariable String EnteredEmail,@PathVariable String EnteredPassword){
		User usr = null;
		try {
			 usr = user_service.CheckLogin(EnteredEmail, EnteredPassword);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return usr;
	}
	
	@GetMapping(value="/policies",produces="application/json")
	public List<Policy> getPolicyList(){
		List<Policy> policyList = null; 
		try {
			policyList =  user_service.getAllPolicies();
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return policyList;
	}
	
	
	@GetMapping(value="/policies/{uemail}",produces="application/json")
	public List<Policy> getPolicyByUser(@PathVariable String uemail){
		List<Policy> policyList = null; 
		try {
			policyList =  user_service.getPolicyByUser(uemail);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return policyList;
	}
	
	@GetMapping(value="/vehicles",produces="application/json")
	public List<Vehicle> getvehicleList(){
		List<Vehicle> vehicleList = null; 
		try {
			vehicleList =  user_service.getAllVehicle();
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return vehicleList;
	}
	
	
	@RequestMapping(value="/addpolicy/{userId}/{regNum}/{planId}",consumes="application/json")
	public boolean addPolicy(@RequestBody Policy p,@PathVariable int userId,@PathVariable String regNum,@PathVariable int planId) {
		boolean res = false;
		try {
			res = user_service.addPolicy(p,userId,regNum,planId);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping(value="/addvehicle/{userId}",consumes="application/json")
	public boolean addVehicle(@RequestBody Vehicle v,@PathVariable int userId) {
		boolean res = false;
		try {
			res = user_service.addVehicle(v,userId);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/updatepolicy/{id}/{newEndDate}")
	public int updatePolicy(@PathVariable int id,@PathVariable Date newEndDate) {
		int res = 0;
		try {
			res = user_service.updatePolicyEndDate(id,newEndDate);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/deletepolicy/{id}")
	public boolean deletePolicy(@PathVariable int id) {
		boolean res = false;
		try {
			res = user_service.deletePolicy(id);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//user
	@GetMapping(value="/userclaims/{userEmail}")
	public List<Claims> getClaimsById(@PathVariable String userEmail)
	{
		 List<Claims> res=null;
		try {
			res= user_service.getClaimsById(userEmail);
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	//user
		@RequestMapping(value="/addclaims/{policyNum}",consumes="application/json")
		public boolean claimPolicy(@RequestBody Claims clm,@PathVariable long policyNum) {
			boolean res = false;
			try {
				res = user_service.claimPolicy(clm,policyNum);
			} catch (HrExceptions e) {
				e.printStackTrace();
			}
			return res;
		}
		
	//admin
	@GetMapping(value="/claims",produces="application/json")
	public List<Claims> viewClaims(){
		List<Claims> claimList = null; 
		claimList =  service.viewClaims();
		return claimList;
	}
	
	//admin
	@GetMapping(value="/approvclaim/{reqNum}")
   public int approveClaim(@PathVariable long reqNum) {
	 return service.approveClaim(reqNum);
	}
	
	//admin
	@GetMapping(value="/declineclaim/{reqNum}")
	public int declineClaim(@PathVariable long reqNum) {
		return service.declineClaim(reqNum);
	}
	
	
}
