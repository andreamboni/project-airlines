package com.projectairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectairlines.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
