package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class StoreDTO extends BaseDTO{
    private Integer storeId;

    private String storeName;

    private String phone;

    private String email;

    private String street;

    private String city;

    private String state;

    private String zipCode;

}
