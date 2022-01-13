package org.app.nodemaintenance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nodeId;
    private int ipAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "node_id", referencedColumnName = "nodeId")
    List<Network> network = new ArrayList<>();
    @OneToOne
    private Computer computer;
}
