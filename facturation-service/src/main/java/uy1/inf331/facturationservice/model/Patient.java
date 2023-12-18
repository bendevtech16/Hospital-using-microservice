package uy1.inf331.facturationservice.model;

import lombok.Data;

@Data
public class Patient {
    private Long id;
    private String name;
    private String telephone;
    private String email;
}
