package model;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String telephone;

}
