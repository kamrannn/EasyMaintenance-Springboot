package org.app.easymaintenance.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_admin")
    private Long adminId;
    private String name;
    private String username;
    private String phone;
    private String email;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.mm.yyyy", locale = "pt-BR", timezone = "Europe/Copenhagen")
    @Column(name = "birthdate")
    private Date birthDate;
}
