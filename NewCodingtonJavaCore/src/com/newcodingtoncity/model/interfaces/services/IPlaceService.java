package com.newcodingtoncity.model.interfaces.services;

import java.util.List;

import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;

public interface IPlaceService {
	
	public List<LargeBusiness> getLargeBusiness();
	public List<Museum> getMuseums();
	public List<Park> getParks();
	public List<Stadium> getStadiums();
	public List<Theater> getTheaters();
	public List<TouristAttraction> getTouristAttractions();
	public List<TraditionalMarket> getTraditionalMarkets();
	public List<Zoo> getZoos();

}
