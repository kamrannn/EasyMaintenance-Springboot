package org.app.nodemaintenance.service;

import org.app.nodemaintenance.model.Network;
import org.app.nodemaintenance.model.Node;
import org.app.nodemaintenance.repository.NetworkRepo;
import org.app.nodemaintenance.repository.NodeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Network service.
 */
@Service
public class NetworkService {
    private final NetworkRepo networkRepo;
    private final NodeRepo nodeRepo;

    /**
     * Instantiates a new Network service.
     *
     * @param networkRepo the network repo
     * @param nodeRepo
     */
    public NetworkService(NetworkRepo networkRepo, NodeRepo nodeRepo) {
        this.networkRepo = networkRepo;
        this.nodeRepo = nodeRepo;
    }

    /**
     * Save network response entity.
     *
     * @param network the network
     * @return the response entity
     */
    public ResponseEntity<Object> saveNetwork(Network network) {
        try {
            networkRepo.save(network);
            return ResponseEntity.accepted().body(network);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Show all networks response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> showAllNetworks() {
        try {
            List<Network> networks = networkRepo.findAll();
            if (!networks.isEmpty())
                return ResponseEntity.ok().body(networks);
            else
                return ResponseEntity.ok().body("There are no Networks");
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
            Optional<Network> network = networkRepo.findById(Id);
            return ResponseEntity.ok().body(network);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    /**
     * Delete network response entity.
     *
     * @param Id the id
     * @return the response entity
     */
    public ResponseEntity<Object> deleteNetwork(Long Id) {
        try {
            Optional<Network> network = networkRepo.findById(Id);
            if (network.isPresent()) {
                Node node = nodeRepo.getById(Id);
                node.setNetwork(null);
            }
            networkRepo.delete(network.get());
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
