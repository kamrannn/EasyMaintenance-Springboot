package org.app.easymaintenance.restcontroller;

import org.app.easymaintenance.entities.Admin;
import org.app.easymaintenance.services.AdminService;
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

    @GetMapping("/getadminnode")
    public ResponseEntity<Object> getAdminNode(){
        return adminservice.adminNode();
    }


}
