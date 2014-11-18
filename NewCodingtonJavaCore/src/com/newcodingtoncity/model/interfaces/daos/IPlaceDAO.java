package com.newcodingtoncity.model.interfaces.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Place;

public interface IPlaceDAO {
	
	public void changeImage(int id, File image) throws FileNotFoundException, SQLException;
}
