package org.app.nodemaintenance.controller;

import org.app.nodemaintenance.model.Admin;
import org.app.nodemaintenance.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Admin")
public class AdminController {
    private final AdminService adminservice;

    public AdminController(AdminService adminservice) {
        this.adminservice = adminservice;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return adminservice.showAllAdmin();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Admin admin) {
        return adminservice.saveAdmin(admin);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Admin admin) {
        return adminservice.saveAdmin(admin);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long Id) {
        return adminservice.deleteAdmin(Id);
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getById(@RequestParam Long Id) {
        return adminservice.getById(Id);
    }


}
