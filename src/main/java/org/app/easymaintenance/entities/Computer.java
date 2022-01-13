package org.app.easymaintenance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;
    private String model;
    private String macAddress;
}
