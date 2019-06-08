package com.pluralsight.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.mvc.model.Ride;
import com.pluralsight.mvc.repository.RideRepository;

@Service
public class RideServiceImpl implements RideService {

	@Autowired
	private RideRepository rideRepository;

	@Override
	public List<Ride> getRides() {
		return rideRepository.getRides();
	}

	@Override
	public Ride createRide(Ride ride) {
		// TODO Auto-generated method stub
		return rideRepository.createRide(ride);
	}

}
