package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "procedures")
public class Procedure {

    @Id
    @Column(name = "procedure_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long procedureId;

    @Column(name = "name_procedures")
    private String nameProcedures;

}

