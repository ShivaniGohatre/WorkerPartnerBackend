package com.workerpartner.sequenceGeneration.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "id_sequence")
public class IdSequence {

    @Id
    @Column(name = "seq_name")
    private String seqName;

    @Column(name = "next_val", nullable = false)
    private Long nextVal;

    // getters and setters
}