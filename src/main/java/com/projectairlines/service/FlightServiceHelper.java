package com.projectairlines.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectairlines.exception.FlightAlreadyExistsException;
import com.projectairlines.exception.NewFlightIncomplete;
import com.projectairlines.model.Flight;
import com.projectairlines.repository.FlightRepository;

@Component
public class FlightServiceHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceHelper.class);
	
	@Autowired
	private FlightRepository repository;

	public void checkNewFlight(Flight flight) {
		
		LOGGER.info("Executing FlightService.checkNewFlight()");
		
		checkIfFlightExists(flight);
		checkIfNewFlightIsComplete(flight);
		
	}
	
	public boolean checkIfFlightExists(Flight newFlight) {

		LOGGER.warn("Executing FlightService.checkIfFlightExists()");
		
		List<Flight> allFlights = repository.findAll();

		for(Flight flight : allFlights) {
			
			if (flight.equals(newFlight)) {
				throw new FlightAlreadyExistsException("The flight " + newFlight + " already exists");
			}
			
		}

		return false;

	}
	
	public boolean checkIfNewFlightIsComplete(Flight flight) {

		LOGGER.info("Executing FlightServiceHelper.checkAddNewFlightRequest()");

		LOGGER.info("FlightServiceHelper.checkAddNewFlightRequest(): checking if Departure is empty or blank");

		if (StringUtils.isBlank(flight.getDeparture())) {
			throw new NewFlightIncomplete("Departure can not be empty or blank.");
		}

		LOGGER.info("FlightServiceHelper.checkAddNewFlightRequest(): checking if Arrival is empty or blank");

		if (StringUtils.isBlank(flight.getArrival())) {
			throw new NewFlightIncomplete("Arrival can not be empty or blank.");
		}

		LOGGER.info("FlightServiceHelper.checkAddNewFlightRequest(): checking if the Flight's Class is empty or blank");

		if (StringUtils.isBlank(flight.getFlightClass())) {
			throw new NewFlightIncomplete("Flight's Class can not be empty or blank.");
		}

		LOGGER.info("FlightServiceHelper.checkAddNewFlightRequest(): checking if Terminal is empty or blank");

		if (StringUtils.isBlank(flight.getTerminal())) {
			throw new NewFlightIncomplete("Terminal can not be empty or blank.");
		}

		LOGGER.info("FlightServiceHelper.checkAddNewFlightRequest(): checking if the Flight's Number is empty or blank");

		if (flight.getFlightNumber() == null ) {
			throw new NewFlightIncomplete("Flight's Number can not be empty or blank.");
		}
		
		return true;

	}
	
}
