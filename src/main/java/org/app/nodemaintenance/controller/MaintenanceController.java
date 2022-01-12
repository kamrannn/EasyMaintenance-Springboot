package org.app.nodemaintenance.controller;

import org.app.nodemaintenance.model.Maintenance;
import org.app.nodemaintenance.service.MaintenanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return maintenanceService.showAllMaintenance();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Maintenance maintenance) {
        return maintenanceService.saveMaintenance(maintenance);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Maintenance maintenance) {
        return maintenanceService.saveMaintenance(maintenance);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long Id) {
        return maintenanceService.deleteMaintenance(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getById(@RequestParam Long Id) {
        return maintenanceService.getById(Id);
    }
}
