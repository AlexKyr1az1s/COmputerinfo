package com.example.computerstats.repositries;

import com.example.computerstats.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long>{
}
