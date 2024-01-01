package uy1.inf331.facturationservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Patient {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String telephone;

}
