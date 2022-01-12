package org.app.nodemaintenance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maintenanceId;
    private LocalDate creationDate;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_id", referencedColumnName = "adminId")
    private Admin admin;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "node_id", referencedColumnName = "nodeId")
    private Node node;
}
