package org.app.easymaintenance.repositories;

import org.app.easymaintenance.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance, Long> {

    List<Maintenance> findMaintenancesByAdmin_AdminId(Long adminId);
}
