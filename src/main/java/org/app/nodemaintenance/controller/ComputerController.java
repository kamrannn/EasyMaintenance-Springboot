package org.app.nodemaintenance.controller;

import org.app.nodemaintenance.model.Computer;
import org.app.nodemaintenance.service.ComputerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Computer")
public class ComputerController {
    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return computerService.showAllComputers();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Computer computer) {
        return computerService.saveComputer(computer);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Computer computer) {
        return computerService.saveComputer(computer);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long Id) {
        return computerService.deleteComputer(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getById(@RequestParam Long Id) {
        return computerService.getById(Id);
    }
}
