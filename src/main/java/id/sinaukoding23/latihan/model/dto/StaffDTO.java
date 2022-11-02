package id.sinaukoding.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDTO extends BaseDTO{
    private Integer staffId;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String active;

    private StoreDTO store;
}