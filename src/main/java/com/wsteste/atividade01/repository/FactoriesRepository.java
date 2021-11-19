package com.wsteste.atividade01.repository;

import com.wsteste.atividade01.model.Factories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoriesRepository extends JpaRepository<Factories, Long> {

    Factories findById(long id);

}
