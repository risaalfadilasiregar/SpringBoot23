package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomeStaffDTO {
    private Integer staffId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Integer active;
}
