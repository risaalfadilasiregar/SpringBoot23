package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO extends BaseDTO{
    private Integer productId;

    private String productName;

    private Integer modelYears;

    private BigDecimal listPrice;

    private CategoryDTO category;

    private BrandDTO brand;
}