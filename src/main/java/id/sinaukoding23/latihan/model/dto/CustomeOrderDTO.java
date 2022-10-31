package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CustomeOrderDTO {
    private Integer orderId;

    private Integer orderStatus;

    private Date orderDate;

    private Date requiredDate;

    private Date shippedDate;
}
