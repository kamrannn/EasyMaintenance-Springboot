package org.app.nodemaintenance.repository;

import org.app.nodemaintenance.model.Network;
import org.app.nodemaintenance.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepo extends JpaRepository<Node, Long> {
    List<Network> findNodeByNetwork_NetworkId(Long networkId);
}
