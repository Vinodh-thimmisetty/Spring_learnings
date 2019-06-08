package com.pluralsight.mvc.service;

import java.util.List;

import com.pluralsight.mvc.model.Ride;

public interface RideService {
	List<Ride> getRides();

	Ride createRide(Ride ride);
}
