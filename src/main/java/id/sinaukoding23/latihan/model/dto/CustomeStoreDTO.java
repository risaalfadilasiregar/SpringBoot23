package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomeStoreDTO {
    private Integer storeId;

    private String storeName;

    private String phone;

    private String email;

    private String street;

    private String city;

    private String state;

    private String zipCode;
}
