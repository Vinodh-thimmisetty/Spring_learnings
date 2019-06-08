package com.pluralsight.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.mvc.model.Ride;
import com.pluralsight.mvc.service.RideService;

@Controller
public class RideController {

	@Autowired
	private RideService rideService;

	@GetMapping("/rides")
	public @ResponseBody List<Ride> getRides() {
		return rideService.getRides();
	}

	@PostMapping("/createRide")
	public @ResponseBody Ride createRide(@RequestBody Ride ride) {
		return rideService.createRide(ride);
	}
}
