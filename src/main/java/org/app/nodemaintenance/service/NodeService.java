package org.app.nodemaintenance.service;

import org.app.nodemaintenance.model.Node;
import org.app.nodemaintenance.repository.NodeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Node service.
 */
@Service
public class NodeService {
    private final NodeRepo nodeRepo;

    /**
     * Instantiates a new Node service.
     *
     * @param nodeRepo the node repo
     */
    public NodeService(NodeRepo nodeRepo) {
        this.nodeRepo = nodeRepo;
    }

    /**
     * Save node response entity.
     *
     * @param node the node
     * @return the response entity
     */
    public ResponseEntity<Object> saveNode(Node node) {
        try {
            nodeRepo.save(node);
            return ResponseEntity.accepted().body(node);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Show all nodes response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> showAllNodes() {
        try {
            List<Node> nodeList = nodeRepo.findAll();
            if (!nodeList.isEmpty())
                return ResponseEntity.ok().body(nodeList);
            else
                return ResponseEntity.ok().body("There are no nodes");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    /**
     * Gets by id.
     *
     * @param Id the id
     * @return the by id
     */
    public ResponseEntity<Object> getById(Long Id) {
        try {
            Optional<Node> node = nodeRepo.findById(Id);
            return ResponseEntity.ok().body(node);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    /**
     * Delete node response entity.
     *
     * @param Id the id
     * @return the response entity
     */
    public ResponseEntity<Object> deleteNode(Long Id) {
        try {
            Optional<Node> node = nodeRepo.findById(Id);
            nodeRepo.delete(node.get());
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
