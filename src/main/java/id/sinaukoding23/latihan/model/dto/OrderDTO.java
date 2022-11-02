package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO extends BaseDTO{
    private Integer orderId;

    private String orderStatus;

    private Date orderDate;

    private Date requiredDate;

    private Date shippedDate;

    private CustomerDTO customer;

    private StaffDTO staff;

    private StoreDTO store;
}