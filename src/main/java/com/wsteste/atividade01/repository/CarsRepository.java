package com.wsteste.atividade01.repository;

import com.wsteste.atividade01.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {

    Cars findById(long id);

}
