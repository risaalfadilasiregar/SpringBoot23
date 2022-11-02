package id.sinaukoding.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreDTO extends BaseDTO{
    private Integer storeId;

    private String storeName;

    private String phone;

    private String email;

    private String street;

    private String city;

    private Integer state;

    private String zipCode;

}