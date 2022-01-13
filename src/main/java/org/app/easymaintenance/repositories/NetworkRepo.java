package org.app.easymaintenance.repositories;

import org.app.easymaintenance.entities.Network;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepo extends JpaRepository<Network, Long> {
}
