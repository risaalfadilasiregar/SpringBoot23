package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProductDTO extends BaseDTO {
    private Integer productId;

    private String productName;

    private Integer modelYear;

    private Integer listPrice;
}
