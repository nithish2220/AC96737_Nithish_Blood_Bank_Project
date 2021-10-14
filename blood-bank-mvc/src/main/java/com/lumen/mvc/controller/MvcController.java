package com.lumen.mvc.controller;

import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.lumen.mvc.pojo.Camp;
import com.lumen.mvc.pojo.Donar;

import reactor.core.publisher.Mono;

@Controller
public class MvcController {
	
	String Base_URI1 = "http://DONAR-SERVICE/";
	String Base_URI2 = "http://CAMP-SERVICE/";
	
	private Donar donor = null;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private Donar donar; 
	
	@Autowired
	private Camp camp;
	
	@Autowired
	WebClient client;
	
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	/*
	 * This is regarding all the operation done on the 
	 * Donar side like registering
	 * Updating
	 * Deleting
	 * Registering for Donation camp
	 * Finding Donation camps 
	 */
	
	// This mapping provides the Donar the Registration Form
	@GetMapping("/registerDonar")
	public String donarForm(Model model) {
		model.addAttribute("donarObj", donar);
		model.addAttribute("errorMsg", "");
		return "registerDonar";
	}
	
	//This mapping checks the validations and registers the user with the provided details
	@PostMapping("/registerDonar")
	public String registerDonar(@Valid Model model, Donar donar, BindingResult result) {
//		@ModelAttribute("donarObj")
		String page = "success";
		if(result.hasErrors()) {
			page = "registerDonar";
		}
		else {
			try { 
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Donar> requestBody = new HttpEntity<>(donar,headers); 
			
//			Mono<Donar> bodyToMono = client.post().uri(Base_URI1).retrieve().bodyToMono(Donar.class);
//			model.addAttribute("donarObj",bodyToMono);
//			System.out.println(bodyToMono);
			Donar postForObject = template.postForObject("http://localhost:8001/api/v1/donars", requestBody, Donar.class);
			model.addAttribute("donarObj",postForObject);
			System.out.println(postForObject);
			}
			catch(Exception e) {
				String errorMsg = "Error occured During Registration! Please check you Details";
				return "redirect:/registerError?errorMsg="+errorMsg;
			}
		}
		return page;
	}
	
	//This mapping handles if any excetions or Erros occured
	@GetMapping("/registerError")
	public String registerError(@RequestParam("errorMsg") String errorMsg, Model model) {
		model.addAttribute("donarObj",donar);
		model.addAttribute("errorMsg",errorMsg);
		return "registerDonar";
	}
	
	
	/*
	 * This Mapping provides the updation form for the Donar
	 */
	@GetMapping("/update")
	public String donarUpdateForm(Model model, Donar donar) {
		model.addAttribute("donarObj", donar);
		model.addAttribute("errorMsg", "");
		return "updateDonarIdForm";
	}
	
	
	@GetMapping("/updateGotId")
	public String updateGotId(@RequestParam("donarId") int donarId,Model model) {
		try {
			Donar forObject = template.getForObject("http://localhost:8001/api/v1/donars/id/"+donarId, Donar.class);
			model.addAttribute("donarObj", forObject);
		}
		catch(Exception e) {
			String errorMsg = "No Records Found or Not Given ID";
			return "redirect:/updateError?errorMsg="+errorMsg;
		}
		model.addAttribute("errorMsg", "");
		return "updateForm";
	}
	

	@GetMapping("/updateError")
	public String updateError(@RequestParam("errorMsg") String errorMsg, Model model) {
		model.addAttribute("errorMsg",errorMsg);
		model.addAttribute("donarObj",donar);
		return "updateDonarIdForm";
	}
	
	/*
	 * This method updates the user details and provides the Updated details in a new page
	 * and handles the validations or errors
	 */

	
	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("donarObj") Donar donar,BindingResult result){
		donor = donar;
		String page = "updateSuccess";
		String errorMsg = "";
		if(result.hasErrors())
			page = "updateForm";
		else {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Donar> requestBody = new HttpEntity<>(donar,headers); 
		
			try {
				template.put("http://localhost:8001/api/v1/donars/update/", requestBody, Donar.class);
			}
			catch(RuntimeException ex) {
				errorMsg = "Error occured During Updation! Please check you Details";
				return "redirect:/updateFormError?errorMsg="+errorMsg;
			}
			donor = null;
			}
			
		return page;
	}
	
	/*
	 * This method raises the errors if any validation is incorrect and provides 
	 * the error message
	 */
	@GetMapping("/updateFormError")
	public String updateFromError(@RequestParam("errorMsg") String errorMsg, Model model) {
		donar = donor;
		model.addAttribute("errorMsg",errorMsg);
		model.addAttribute("donarObj",donar);
		return "updateForm";
	}
	
	
	
	/*
	 * This mapping provides the Camp Location form for selecting the camp location
	 * and redirects to camps details page
	 */
	@GetMapping("/findByCampLocation")
	public String findByCampLocation(Model model) {
		Camp[] camps = template.getForObject("http://localhost:8002/api/v1/camps", Camp[].class);
		model.addAttribute("camps",camps);
		model.addAttribute("campObj", camp);
		
		return "findByCampLocationForm";
	}
	
	/*
	 * Gets the camp location and provides the camp organized in a particular location
	 */
	@GetMapping("/campGroup")
	public String campByLocation(@RequestParam String campLocation, Model model) {
		Camp[] forObject = template.getForObject("http://localhost:8002/api/v1/camps/"+campLocation, Camp[].class);
		model.addAttribute("campObj",forObject);
		return "campsByLocation";
	}
	
	
	/*
	 * This mapping provides the Donar a Form for registering for a camp and gets the camp 
	 * Location and donation date by the Donar
	 */
	@GetMapping("/registerCamp")
	public String registerForm(Model model) {
		
		model.addAttribute("donarObj",donar);
		model.addAttribute("errorMsg", "");
		return "campRegisterIdForm";
	}
	
	/*
	 * By getting the Donar Id, this method is used to register the camp details for the donar
	 */
	@GetMapping("/campRegisterForm")
	public String campForm(@RequestParam int donarId, Model model) {
		Camp[] camps = template.getForObject("http://localhost:8002/api/v1/camps", Camp[].class);
		model.addAttribute("campObj", camp);
		model.addAttribute("camps",camps);
		String page="campRegisterForm";
		try {
		Donar forObject = template.getForObject("http://localhost:8001/api/v1/donars/id/"+donarId, Donar.class);
		model.addAttribute("donarObj", forObject);
		}
		catch(Exception e) {
			String errorMsg = "Please provide Correct DonarId";
			return "redirect:registerCampError?errorMsg="+errorMsg;
		}
		return "campRegisterForm";
	}
	
	/*
	 * If any errors occurred while giving the camp registering details that will be 
	 * handled by this method.
	 */
	@GetMapping("/registerCampError")
	public String campError(@RequestParam String errorMsg, Model model) {
		model.addAttribute("errorMsg", errorMsg);
		model.addAttribute("donarObj", donar);
		return "campRegisterIdForm";
	}
	
	//To Do
	@PostMapping("/campRegisterSuccess")
	public String register(@RequestBody Donar donar, Model model) {
		String page = "campRegisterSuccess";
		
//			try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Donar> requestBody = new HttpEntity<>(donar,headers);
			Camp[] camps = template.getForObject("http://localhost:8002/api/v1/camps", Camp[].class);
			
			String campLocation = donar.getDonarLocation();
			
			int campId = 0;
			for(Camp campT:camps) {
				if(campT.getCampLocation().equalsIgnoreCase(campLocation))
					camp = campT;
			}
			
			donar.getCamps().add(camp);
			
			
			template.put("http://localhost:8001/api/v1/donars/update/camp/", requestBody, headers);
			
//			int id = donar.getDonarId();
//			Donar forObject = template.getForObject("http://localhost:8001/api/v1/donars/id/"+id, Donar.class);
//			model.addAttribute("donarObj", forObject);
//			}
//			catch(Exception e) {
//				String errorMsg = "Please provide Correct DonarId";
//				return "redirect:registerCampError?errorMsg="+errorMsg;
//			}
		return page;
	}
	
	/*
	 * Deleting or unregistering form the Blood bank Management System
	 */
	@GetMapping("/delete")
	public String deleteForm(Model model) {
		model.addAttribute("donarObj", donar);
		model.addAttribute("errorMsg", "");
		return "deleteDonarIdForm";
	}
	
	/*
	 * Provides the Form for Un-registering from database
	 */
	@GetMapping("/deleteForm")
	public String deleteForm(@RequestParam int donarId, Model model) {
		String page="deleteSuccess";
		try {
//			template.getForObject("http://localhost:8001/api/v1/donars/"+donarId, Donar.class);
			 template.delete("http://localhost:8001/api/v1/donars/delete/"+donarId);
		}
		catch(Exception e) {
			String errorMsg = "Please provide Correct DonarId";
			return "redirect:deleteError?errorMsg="+errorMsg;
		}
		return page;
	}
	
	/*
	 * Handles the errors and exceptions while deleting a donar
	 */
	@GetMapping("/deleteError")
	public String deleteError(@RequestParam String errorMsg, Model model) {
		model.addAttribute("errorMsg", errorMsg);
		model.addAttribute("donarObj", donar);
		return "deleteDonarIdForm";
	}
	
	
	
	
	
	
	
	/* Searching Methods for Client
	 * Find all Donars
	 * Find eligible Donars
	 * Find Donars By Location
	 * */
	
	/*
	 * Finding All Donars
	 */
	@GetMapping("/searchDonars")
	public String searchDonars(Model model) {
		Donar[] donars = template.getForObject("http://localhost:8001/api/v1/donars", Donar[].class);
		model.addAttribute("donarObj",donars);
		return "showAllDonars";
	}
	
	/*
	 *  Form for finding data by blood group
	 */
	@GetMapping("/findByBloodGroup")
	public String findByBloodGroupForm(Model model) {
		model.addAttribute("donarObj", donar);
		return "findByBloodGroupForm";
	}
	
	/*
	 * Finding All Donars based on Blood Group
	 */
	@GetMapping("/group")
	public String findByBloodGroupData(@RequestParam String bloodGroup, Model model) {
		Donar[] donars = template.getForObject("http://localhost:8001/api/v1/donars/"+bloodGroup, Donar[].class);
		model.addAttribute("donarObj",donars);
		return "showAllDonars";
	}	
	
	/*
	 * Form for finding Donars by Location
	 */
	@GetMapping("/findByLocation")
	public String findByLocationForm(Model model) {
		Camp[] camps = template.getForObject("http://localhost:8002/api/v1/camps", Camp[].class);
//		model.addAttribute("campObj",camp);
		model.addAttribute("camps",camps);
		model.addAttribute("donarObj",donar);
		return "findByLocationForm";
	}
	
	/*
	 * Finding All Donars based on the Location
	 */
	@GetMapping("/byLocation")
	public String findByLocation(@RequestParam String donarLocation, Model model) {
		Donar[] forObject = template.getForObject("http://localhost:8001/api/v1/donars/location/"+donarLocation, Donar[].class);
		model.addAttribute("donarObj",forObject);
		return "showAllDonars";
	}
	
	/*
	 * Form for finding donars who are having donation date less than 6 months
	 */
	@GetMapping("/findByEligibleDonar")
	public String findByEligibleForm(Model model) {
		model.addAttribute("donarObj",donar);
		return "eligibleBloodGroupForm";
	}
	
	/*
	 * finding donars who are having donation date less than 6 months
	 */
	@GetMapping("/eligible")
	public String getEligible(@RequestParam String bloodGroup, Model model) {
		Donar[] forObject = template.getForObject("http://localhost:8001/api/v1/donars/byDate/"+bloodGroup, Donar[].class);
		model.addAttribute("donarObj",forObject);
		return "showAllDonars";
	}
	
	/*
	 * Contact Us page with the contact Info
	 */
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactUs";
	}
}
