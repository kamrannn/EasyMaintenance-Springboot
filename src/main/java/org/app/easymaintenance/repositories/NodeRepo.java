package org.app.easymaintenance.repositories;

import org.app.easymaintenance.entities.Network;
import org.app.easymaintenance.entities.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepo extends JpaRepository<Node, Long> {
    List<Network> findNodeByNetwork_NetworkId(Long networkId);
}
