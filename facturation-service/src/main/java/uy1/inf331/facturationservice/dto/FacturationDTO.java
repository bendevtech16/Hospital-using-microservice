package uy1.inf331.facturationservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uy1.inf331.facturationservice.model.Patient;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FacturationDTO {
    private Long id;
    private LocalDate createdAt;
    private Double montant;
    private Long patientId;
    private Patient patient;
}
