package org.app.nodemaintenance.service;

import org.app.nodemaintenance.model.Admin;
import org.app.nodemaintenance.repository.AdminRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Admin service.
 */
@Service
public class AdminService {
    private final AdminRepo adminRepo;

    /**
     * Instantiates a new Admin service.
     *
     * @param adminRepo the admin repo
     */
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    /**
     * Save admin response entity.
     *
     * @param admin the admin
     * @return the response entity
     */
    public ResponseEntity<Object> saveAdmin(Admin admin) {
        try {
            adminRepo.save(admin);
            return ResponseEntity.accepted().body(admin);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Show all admin response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> showAllAdmin() {
        try {
            List<Admin> adminList = adminRepo.allAdmin();
            if (!adminList.isEmpty())
                return ResponseEntity.ok().body(adminList);
            else
                return ResponseEntity.ok().body("There are no admins");
        } catch (Exception e) {
            System.out.println(e);
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
            Optional<Admin> admin = adminRepo.findById(Id);
            return ResponseEntity.ok().body(admin);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    /**
     * Delete admin response entity.
     *
     * @param Id the id
     * @return the response entity
     */
    public ResponseEntity<Object> deleteAdmin(Long Id) {
        try {
            Optional<Admin> admin = adminRepo.findById(Id);
            adminRepo.delete(admin.get());
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    /**
     * Admin node response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> adminNode(){
        try{
            List<Object> objectList = adminRepo.listOfPairs();
            if (!objectList.isEmpty()){
                return ResponseEntity.ok().body(objectList);
            }else return ResponseEntity.ok().body("There is no relation");
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
