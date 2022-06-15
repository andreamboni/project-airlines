package com.projectairlines.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projectairlines.model.Flight;
import com.projectairlines.repository.FlightRepository;

@Service
public class FlightService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightService.class);
	
	@Autowired
	private FlightRepository repository;
	
	@Autowired
	private FlightServiceHelper helper;
	
	public ResponseEntity<?> addNewFlight(Flight flight) {

		LOGGER.warn("Executing FlightService.addNewFlight()");

		try {

			helper.checkNewFlight(flight);
			repository.save(flight);

			return ResponseEntity.ok().body(flight);

		} catch (RuntimeException exception) {

			throw new RuntimeException("It was not possible to add the flight: " + flight, exception);

		} finally {

			LOGGER.warn("Exiting FlightService.addNewFlight()");

		}

	}
	
	public ResponseEntity<?> getFlightById(Long id) {

		LOGGER.info("Executing FlightService.getFlightById()");

		LOGGER.info("Exiting FlightService.getFlightById()");

		return repository.findById(id)
				.map(flight -> ResponseEntity.ok().body(flight))
				.orElse(ResponseEntity.notFound().header("Flight not found", "The flight with id " + id + "was not found. Check if the id is correct").build());

	}
	
	public ResponseEntity<Flight> updateFlightById(Long id, Flight flight) {

		LOGGER.info("Executing FlightService.updateFlightById()");

		try {

			helper.checkNewFlight(flight);

			return repository.findById(id).map(flightUpdated -> {

				LOGGER.info("FlightService.updateFlightById(): inside the map");

				flightUpdated.setDeparture(flight.getDeparture());
				flightUpdated.setArrival(flight.getArrival());
				flightUpdated.setFlightClass(flight.getFlightClass());
				flightUpdated.setTerminal(flight.getTerminal());
				flightUpdated.setFlightNumber(flight.getFlightNumber());

				repository.save(flightUpdated);

				return ResponseEntity.ok().body(flightUpdated);

			}).orElse(ResponseEntity.notFound().build());
			
		} catch (RuntimeException exception) {

			throw new RuntimeException("It was not possible to update the flight " + flight, exception);

		} finally {

			LOGGER.info("Exiting FlightService.updateFlightById()");

		}

	}
	
	public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
		
		LOGGER.info("Executing FlightService.deleteFlight()");
		
		LOGGER.info("Exiting FlightService.deleteFlight()");
		
		return repository.findById(id).map(flight -> {

			repository.delete(flight);

			return ResponseEntity.ok().build();

		}).orElse(ResponseEntity.notFound().header("Flight not found", "The flight with id " + id + "was not found. Check if the id is correct").build());
	}
	
}
