package org.app.nodemaintenance.repository;

import org.app.nodemaintenance.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT admin_id, node_id FROM maintenance", nativeQuery = true)
    List<Object> listOfPairs();

    @Query(value = "SELECT * FROM node_maintenance.admin", nativeQuery = true)
    List<Admin> allAdmin();
}
