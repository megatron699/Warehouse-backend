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
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Operation {

    private static final String ID_SEQ = "operation_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQ)
    @SequenceGenerator(name = ID_SEQ, sequenceName = ID_SEQ, allocationSize = 1)
    private Long id;
    private Date operationDate;
    private int amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_type_id")
    private OperationType operationType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tool_warehouse_id")
    private ToolWarehouse toolWarehouse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tool_id")
    private Tool tool;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tool_warehouse_id")
    private Worker receivedEmployee;*/

}
