package org.app.easymaintenance.repositories;

import org.app.easymaintenance.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepo extends JpaRepository<Computer, Long> {
}
