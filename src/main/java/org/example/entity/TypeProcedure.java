package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "types_procedures")
public class TypeProcedure {

    @Id
    @Column(name = "type_procedure_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeProcedureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedure_id")
    private Procedure procedure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

}

