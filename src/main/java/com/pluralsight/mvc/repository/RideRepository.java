package com.pluralsight.mvc.repository;

import java.util.List;

import com.pluralsight.mvc.model.Ride;

public interface RideRepository {

	List<Ride> getRides();

	Ride createRide(Ride ride);

}