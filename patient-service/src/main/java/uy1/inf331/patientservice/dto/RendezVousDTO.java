package uy1.inf331.patientservice.dto;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RendezVousDTO {
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    private long patientId;
    private long medecinId;
}