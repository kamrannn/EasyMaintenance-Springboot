package org.app.easymaintenance.restcontroller;

import org.app.easymaintenance.entities.Node;
import org.app.easymaintenance.services.NodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Node")
public class NodeController {
    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return nodeService.showAllNodes();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Node node) {
        return nodeService.saveNode(node);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Node node) {
        return nodeService.saveNode(node);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long Id) {
        return nodeService.deleteNode(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getById(@RequestParam Long Id) {
        return nodeService.getById(Id);
    }
}
