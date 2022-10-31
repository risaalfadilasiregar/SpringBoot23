package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Customers;
import id.sinaukoding23.latihan.model.Orders;
import id.sinaukoding23.latihan.model.dto.CustomeCustomerDTO;
import id.sinaukoding23.latihan.model.dto.CustomerDTO;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Orders dtoToEntity(OrderDTO dto);

    OrderDTO entityToDto(Orders param);

    List<Orders> toEntityList(List<OrderDTO> data);

    List<OrderDTO> toDtoList(List<Orders> data);

    CustomeCustomerDTO fromOrdersToOrder(OrderDTO param);

    List<CustomeCustomerDTO> toCustomOrder(List<OrderDTO> data);
}
