package com.newcodingtoncity.spring.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;
import com.newcodingtoncity.model.services.PlaceService;

@Controller
public class PlaceController{

	@RequestMapping(value = "/handle_place.htm")
	public String createPlaceController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("section", "new");
		return "handle_place";
	}

	@RequestMapping(value = "/new_place.htm")
	public String newPlaceController(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Place placeCreated = null;
		int typeOfPlace = 0;

		if(Integer.parseInt(request.getParameter("placeType"))== LargeBusiness.ID_TYPE_OF_PLACE){
			placeCreated = new LargeBusiness();
			typeOfPlace = LargeBusiness.ID_TYPE_OF_PLACE;
		}
		if(Integer.parseInt(request.getParameter("placeType"))== Museum.ID_TYPE_OF_PLACE){
			placeCreated = new Museum();
			typeOfPlace = Museum.ID_TYPE_OF_PLACE;
		}
		if(Integer.parseInt(request.getParameter("placeType"))== Stadium.ID_TYPE_OF_PLACE){
			placeCreated = new Stadium();
			typeOfPlace = Stadium.ID_TYPE_OF_PLACE;
		}
		if(Integer.parseInt(request.getParameter("placeType"))== Theater.ID_TYPE_OF_PLACE){
			placeCreated = new Theater();
			typeOfPlace = Theater.ID_TYPE_OF_PLACE;
		}
		if(Integer.parseInt(request.getParameter("placeType"))== Park.ID_TYPE_OF_PLACE){
			placeCreated = new Park();
			typeOfPlace = Park.ID_TYPE_OF_PLACE;
		}
		if(Integer.parseInt(request.getParameter("placeType"))== TouristAttraction.ID_TYPE_OF_PLACE){
			placeCreated = new TouristAttraction();
			typeOfPlace = TouristAttraction.ID_TYPE_OF_PLACE;
		}
		if(Integer.parseInt(request.getParameter("placeType"))== TraditionalMarket.ID_TYPE_OF_PLACE){
			placeCreated = new TraditionalMarket();
			typeOfPlace = TraditionalMarket.ID_TYPE_OF_PLACE;
		}
		if(Integer.parseInt(request.getParameter("placeType"))== Zoo.ID_TYPE_OF_PLACE){
			placeCreated = new Zoo();
			typeOfPlace = Zoo.ID_TYPE_OF_PLACE;
		}

		try{
			placeCreated.setName(request.getParameter("placeName"));
			placeCreated.setPlaceDescription(request.getParameter("placeDescription"));
			placeCreated.setCapacity(Integer.parseInt(request.getParameter("placeCapacity")));
			placeCreated.setStart(request.getParameter("placeStart"));
			placeCreated.setEnd(request.getParameter("placeEnd"));
			//placeCreated.setImage(new File(request.getParameter("placeImage")));
			//placeCreated.setZone(request.getParameter("placeType"));

			PlaceService placeservice = new PlaceService();

			int affectedRows = placeservice.insertPlace(placeCreated, typeOfPlace);

			if(affectedRows == 1){
				request.setAttribute("ok", "Place added successfully.");
			}else{
				request.setAttribute("error", "Unexpected error adding place.");
			}
			
			if(affectedRows == 1){
				return "welcome";
			}else{
				return "handle_place";
			}

		}catch(Exception e){
			request.setAttribute("error", "Place bad introduced."+ e.getMessage());
			return "handle_place";
		}

	}

	@RequestMapping(value = "/update_place.htm")
	public ModelAndView editPlaceController(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		request.setAttribute("section", "edit");
		ModelAndView modelAndView = new ModelAndView();		
		int id = Integer.parseInt(request.getParameter("id"));
		int typePlace = Integer.parseInt(request.getParameter("type"));
		PlaceService placeService = new PlaceService();	
		Place findPlace = placeService.getPlaceById(id,typePlace);
		modelAndView.addObject("place", findPlace);
		modelAndView.setViewName("handle_place");
		return modelAndView;
	}

	@RequestMapping(value = "/edit_place.htm")
	public String updatePlaceController(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Place placeCreated = new Museum();
		placeCreated.setId(id);
		placeCreated.setName(request.getParameter("placeName"));
		placeCreated.setPlaceDescription(request.getParameter("placeDescription"));
		placeCreated.setCapacity(Integer.parseInt(request.getParameter("placeCapacity")));
		placeCreated.setStart(request.getParameter("placeStart"));
		placeCreated.setEnd(request.getParameter("placeEnd"));
		PlaceService placeService = new PlaceService();	
		int affectedRows = placeService.updatePlace(placeCreated);
		if(affectedRows == 1){
			request.setAttribute("ok", "Place uppdated successfully.");
		}else{
			request.setAttribute("error", "Unexpected error updating place.");
		}
		return "welcome";
	}


	@RequestMapping(value = "/delete_place.htm")
	public String deletePlaceController(HttpServletRequest request, HttpServletResponse response) {	
		int id = Integer.parseInt(request.getParameter("id"));
		PlaceService placeService = new PlaceService();	
		int affectedRows = placeService.deletePlace(id);
		if(affectedRows == 1){
			request.setAttribute("ok", "Place deleted successfully.");
		}else{
			request.setAttribute("error", "Unexpected error deleting place.");
		}
		return "welcome";
	}


	@RequestMapping(value = "/show_place.htm")
	public ModelAndView showEventController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();		
		int id = Integer.parseInt(request.getParameter("id"));
		int typePlace = Integer.parseInt(request.getParameter("type_place"));
		PlaceService placeService = new PlaceService();	
		Place findPlace = placeService.getPlaceById(id,typePlace);
		modelAndView.addObject("place", findPlace);
		return modelAndView;
	}


	@RequestMapping(value = "/list_place.htm")
	public ModelAndView listEventsController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();		
		PlaceService placeService = new PlaceService();

		ArrayList<LargeBusiness> business = new ArrayList<LargeBusiness>(); 
		business = (ArrayList<LargeBusiness>) placeService.getLargeBusiness();
		modelAndView.addObject("business", business);

		ArrayList<Museum> museum = new ArrayList<Museum>(); 
		museum = (ArrayList<Museum>) placeService.getMuseums();
		modelAndView.addObject("museum", museum);

		ArrayList<Stadium> stadium = new ArrayList<Stadium>(); 
		stadium = (ArrayList<Stadium>) placeService.getStadiums();
		modelAndView.addObject("stadium", stadium);

		ArrayList<Theater> theater = new ArrayList<Theater>(); 
		theater = (ArrayList<Theater>) placeService.getTheaters();
		modelAndView.addObject("theater", theater);

		ArrayList<Park> park = new ArrayList<Park>(); 
		park = (ArrayList<Park>) placeService.getParks();
		modelAndView.addObject("park", park);

		ArrayList<TouristAttraction> tourist = new ArrayList<TouristAttraction>(); 
		tourist = (ArrayList<TouristAttraction>) placeService.getTouristAttractions();
		modelAndView.addObject("tourist", tourist);

		ArrayList<TraditionalMarket> market = new ArrayList<TraditionalMarket>(); 
		market = (ArrayList<TraditionalMarket>) placeService.getTraditionalMarkets();
		modelAndView.addObject("market", market);

		ArrayList<Zoo> zoo = new ArrayList<Zoo>(); 
		zoo = (ArrayList<Zoo>) placeService.getZoos();
		modelAndView.addObject("zoo", zoo);


		return modelAndView;
	}


}