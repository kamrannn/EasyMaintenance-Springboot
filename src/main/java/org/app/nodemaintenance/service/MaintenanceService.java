package org.app.nodemaintenance.service;

import org.app.nodemaintenance.model.Maintenance;
import org.app.nodemaintenance.repository.MaintenanceRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Maintenance service.
 */
@Service
public class MaintenanceService {
    private final MaintenanceRepo maintenanceRepo;

    /**
     * Instantiates a new Maintenance service.
     *
     * @param maintenanceRepo the maintenance repo
     */
    public MaintenanceService(MaintenanceRepo maintenanceRepo) {
        this.maintenanceRepo = maintenanceRepo;
    }

    /**
     * Save maintenance response entity.
     *
     * @param maintenance the maintenance
     * @return the response entity
     */
    public ResponseEntity<Object> saveMaintenance(Maintenance maintenance) {
        try {
            maintenanceRepo.save(maintenance);
            return ResponseEntity.accepted().body(maintenance);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Show all maintenance response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> showAllMaintenance() {
        try {
            List<Maintenance> maintenanceList = maintenanceRepo.findAll();
            if (!maintenanceList.isEmpty())
                return ResponseEntity.ok().body(maintenanceList);
            else
                return ResponseEntity.ok().body("There are no maintenance");
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
            Optional<Maintenance> maintenance = maintenanceRepo.findById(Id);
            if (maintenance.isPresent())
                return ResponseEntity.ok().body(maintenance);
            else return ResponseEntity.badRequest().body("The given ID does not exist");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    /**
     * Delete maintenance response entity.
     *
     * @param Id the id
     * @return the response entity
     */
    public ResponseEntity<Object> deleteMaintenance(Long Id) {
        try {
            Optional<Maintenance> maintenance = maintenanceRepo.findById(Id);
            if (maintenance.isPresent()) {
                maintenanceRepo.delete(maintenance.get());
                return ResponseEntity.ok().body("Deleted");
            } else return ResponseEntity.badRequest().body("The given ID does not exist");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
