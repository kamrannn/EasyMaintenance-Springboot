package org.app.nodemaintenance.repository;

import org.app.nodemaintenance.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance, Long> {

    List<Maintenance> findMaintenancesByAdmin_AdminId(Long adminId);
}
