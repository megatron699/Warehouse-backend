package ru.ssau.labs.toolwarehousebackend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
public class Employee {

    private static final String ID_SEQ = "employee_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQ)
    @SequenceGenerator(name = ID_SEQ, sequenceName = ID_SEQ, allocationSize = 1)
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tool_warehouse_id")
    private ToolWarehouse toolWarehouse;
    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id")
    private Set<Operation> operations = new HashSet<>();*/

}
