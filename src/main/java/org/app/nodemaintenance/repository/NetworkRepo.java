package org.app.nodemaintenance.repository;

import org.app.nodemaintenance.model.Network;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepo extends JpaRepository<Network, Long> {
}
