package org.app.easymaintenance.entities;

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
    @JoinColumn(name = "fk_admin", referencedColumnName = "pk_admin")
    private Admin admin;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_node", referencedColumnName = "pk_node")
    private Node node;
}
