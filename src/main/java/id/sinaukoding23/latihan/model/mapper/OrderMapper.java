package id.sinaukoding.latihan.model.mapper;

import id.sinaukoding.latihan.model.Order;
import id.sinaukoding.latihan.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order dtoToEntity(OrderDTO dto);

    OrderDTO entityToDto(Order param);

    List<Order> toEntityList(List<OrderDTO> data);

    List<OrderDTO> toDtoList(List<Order> data);

}