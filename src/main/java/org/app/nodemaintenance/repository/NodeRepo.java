package org.app.nodemaintenance.repository;

import org.app.nodemaintenance.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NodeRepo extends JpaRepository<Node, Long> {
}
