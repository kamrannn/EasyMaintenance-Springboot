package org.app.easymaintenance.restcontroller;

import org.app.easymaintenance.entities.Network;
import org.app.easymaintenance.services.NetworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Network")
public class NetworkController {
    private final NetworkService networkService;

    public NetworkController(NetworkService networkService) {
        this.networkService = networkService;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return networkService.showAllNetworks();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Network network) {
        return networkService.saveNetwork(network);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Network network) {
        return networkService.saveNetwork(network);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long Id) {
        return networkService.deleteNetwork(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getById(@RequestParam Long Id) {
        return networkService.getById(Id);
    }
}
