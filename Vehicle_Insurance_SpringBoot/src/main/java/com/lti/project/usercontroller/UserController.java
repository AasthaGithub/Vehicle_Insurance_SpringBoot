
package com.lti.project.usercontroller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.project.bean.Claims;
import com.lti.project.bean.Plan;
import com.lti.project.bean.Policy;
import com.lti.project.bean.User;
import com.lti.project.exceptions.HrExceptions;
import com.lti.project.service.AdminService;
import com.lti.project.service.ClaimsService;
import com.lti.project.service.PolicyService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private PolicyService policy_service;
	
	@Autowired
	private ClaimsService claim_service;
	
	@GetMapping(value="/plans",produces="application/json")
	public List<Plan> getPlanList(){
		List<Plan> planList = null; 
		try {
			planList =  service.getAllPlans();
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/findAmt/{vehicle}")
	public List<Long> getPlan(@PathVariable String vehicle){
		List<Long> lst = null; 
		try {
			lst =  service.findPlanByVehicle(vehicle);
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	@GetMapping(value="/users",produces="application/json")
	public List<User> getUserList(){
		List<User> userList = null; 
		try {
			userList =  service.getAllUsers();
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	@PostMapping(value="/adduser",consumes="application/json")
	public boolean adduser(@RequestBody User u) {
		boolean res = false;
		try {
			res = service.addUser(u);
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/login/{EnteredEmail}/{EnteredPassword}")
	public boolean checkLogin(@PathVariable String EnteredEmail, @PathVariable String EnteredPassword ){
		boolean loginStatus = false;
		try {
			 loginStatus = service.CheckLogin(EnteredEmail, EnteredPassword);
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginStatus;
	}
	
	@GetMapping(value="/policies",produces="application/json")
	public List<Policy> getPolicyList(){
		List<Policy> policyList = null; 
		try {
			policyList =  policy_service.getAllPolicies();
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return policyList;
	}
	
	@PostMapping(value="/addpolicy",consumes="application/json")
	public boolean addPolicy(@RequestBody Policy p) {
		boolean res = false;
		try {
			res = policy_service.addPolicy(p);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/updatepolicy/{id}/{newEndDate}")
	public int updatePolicy(@PathVariable int id,@PathVariable Date newEndDate) {
		int res = 0;
		try {
			res = policy_service.updatePolicyEndDate(id,newEndDate);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/deletepolicy/{id}")
	public boolean deletePolicy(@PathVariable int id) {
		boolean res = false;
		try {
			res = policy_service.deletePolicy(id);
		} catch (HrExceptions e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping(value="/claims",produces="application/json")
	public List<Claims> getClaimList(){
		List<Claims> claimList = null; 
		try {
			claimList =  claim_service.getClaims();
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claimList;
	}
	
	@PostMapping(value="/addClaims",consumes="application/json")
	public boolean claimPolicy(@RequestBody Claims clm) {
		boolean res = false;
		try {
			res = claim_service.claimPolicy(clm);
		} catch (HrExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
