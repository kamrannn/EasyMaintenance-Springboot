package org.app.nodemaintenance.repository;

import org.app.nodemaintenance.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance, Long> {
}
