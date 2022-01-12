package org.app.nodemaintenance.service;

import org.app.nodemaintenance.model.Computer;
import org.app.nodemaintenance.repository.ComputerRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Computer service.
 */
@Service
public class ComputerService {
    private final ComputerRepo computerRepo;

    /**
     * Instantiates a new Computer service.
     *
     * @param computerRepo the computer repo
     */
    public ComputerService(ComputerRepo computerRepo) {
        this.computerRepo = computerRepo;
    }

    /**
     * Save computer response entity.
     *
     * @param computer the computer
     * @return the response entity
     */
    public ResponseEntity<Object> saveComputer(Computer computer) {
        try {
            computerRepo.save(computer);
            return ResponseEntity.accepted().body(computer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Show all computers response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> showAllComputers() {
        try {
            List<Computer> computerList = computerRepo.findAll();
            if (!computerList.isEmpty())
                return ResponseEntity.ok().body(computerList);
            else
                return ResponseEntity.ok().body("There are no computers");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    /**
     * Gets by id.
     *
     * @param Id the id
     * @return the by id
     */
    public ResponseEntity<Object> getById(Long Id) {
        try {
            Optional<Computer> computer = computerRepo.findById(Id);
            return ResponseEntity.ok().body(computer);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    /**
     * Delete computer response entity.
     *
     * @param Id the id
     * @return the response entity
     */
    public ResponseEntity<Object> deleteComputer(Long Id) {
        try {
            Optional<Computer> computer = computerRepo.findById(Id);
            computerRepo.delete(computer.get());
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
