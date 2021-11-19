package com.wsteste.atividade01.CSV;

import com.wsteste.atividade01.model.Cars;
import com.wsteste.atividade01.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    CarsRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Cars> cars = CSVHelper.csvToCars(file.getInputStream());
            repository.saveAll(cars);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Cars> cars = repository.findAll();

        ByteArrayInputStream in = CSVHelper.carsToCSV(cars);
        return in;
    }

    public List<Cars> getAllCars() {
        return repository.findAll();
    }
}
