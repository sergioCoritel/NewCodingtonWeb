package com.newcodingtoncity.spring.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;
import com.newcodingtoncity.model.interfaces.services.IPlaceService;
import com.newcodingtoncity.model.services.PlaceService;

@Controller
public class PlaceController{
	
	@RequestMapping(value = "/create_place.htm")
	public String createPlaceController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "create_place";
	}
	
	@RequestMapping(value = "/validate_place.htm")
	public String validaterPlaceController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("H1");
		Place placeCreated = null;
		int typeOfPlace = 0;
		String placeType = request.getParameter("placeType");
		System.out.println("placeType!!!!!! "+ request.getParameter("placeType"));
		System.out.println("placeType!!!!!! "+ request.getParameter("placeName"));
		System.out.println("placeType!!!!!! "+ request.getParameter("placeDescription"));
		System.out.println("placeType!!!!!! "+ request.getParameter("placeCapacity"));
		System.out.println("placeType!!!!!! "+ request.getParameter("placeStart"));
		System.out.println("placeType!!!!!! "+ request.getParameter("placeEnd"));
		
//		if(request.getParameter("placeType")== "LARGE BUSINESS"){
//			placeCreated = new LargeBusiness();
//			typeOfPlace = 1;
//		}
//		/*if(Integer.parseInt(request.getParameter("placeType"))== Museum.ID_TYPE_OF_PLACE){
//			placeCreated = new Museum();
//			typeOfPlace = 2;
//		}*/
//		if(request.getParameter("placeType") == "STADIUM"){
//			placeCreated = new Stadium();
//			typeOfPlace = 3;
//		}
//		if(request.getParameter("placeType") == "THEATER"){
//			placeCreated = new Theater();
//			typeOfPlace = 4;
//		}
//		if(request.getParameter("placeType") == "PARK"){
//			placeCreated = new Park();
//			typeOfPlace = 5;
//		}
//		if(request.getParameter("placeType") == "TOURIST ATTRACTION"){
//			placeCreated = new TouristAttraction();
//			typeOfPlace = 6;
//		}
//		if(request.getParameter("placeType") == "TRADITIONAL MARKET"){
//			placeCreated = new TraditionalMarket();
//			typeOfPlace = 7;
//		}
//		if(request.getParameter("placeType") == "ZOO"){
//			placeCreated = new Zoo();
//			typeOfPlace = Zoo.ID_TYPE_OF_PLACE;
//		}
//		
//		try{
//			System.out.println("H2.1");
//			System.out.println(placeCreated);
//			placeCreated.setName(request.getParameter("placeName"));
//			System.out.println("H2.1.1");
//			placeCreated.setPlaceDescription(request.getParameter("placeDescription"));
//			placeCreated.setCapacity(Integer.parseInt(request.getParameter("placeCapacity")));
//			System.out.println("H2.2");
//			placeCreated.setStart(request.getParameter("placeStart"));
//			placeCreated.setEnd(request.getParameter("placeEnd"));
//			System.out.println("H2.3");
//			placeCreated.setImage(new File(request.getParameter("placeImage")));
//			//placeCreated.setZone(request.getParameter("placeType"));
//			System.out.println("H2.4");
//			
//			PlaceService placeservice = new PlaceService();
//			int newPlace = placeservice.insertPlace(placeCreated, typeOfPlace);
//			
//			if(newPlace == 0){
//				System.out.println("H3");
//				return "welcome";
//			}else{
//				return "create_place";
//			}
//				
//				
//		}catch(Exception e){
//			request.setAttribute("error", "Place bad introduced."+ e.getMessage());
//			System.out.println("H4");
			return "welcome";
//		}

	}
	
	
	@RequestMapping(value = "/update_place.htm")
	public String updatePlaceController() {
		return "show_event";
	}
	
	
	@RequestMapping(value = "/delate_place.htm")
	public String deletePlaceController() {
		return "show_event";
	}
	
	
	
}