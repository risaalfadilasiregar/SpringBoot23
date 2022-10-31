package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Customers;
import id.sinaukoding23.latihan.model.dto.CustomeCustomerDTO;
import id.sinaukoding23.latihan.model.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customers dtoToEntity(CustomerDTO dto);

    CustomerDTO entityToDto(Customers param);

    List<Customers> toEntityList(List<CustomerDTO> data);

    List<CustomerDTO> toDtoList(List<Customers> data);

    CustomeCustomerDTO fromCustomerToCustome(CustomerDTO param);

    List<CustomeCustomerDTO> toCustomCustomer(List<CustomerDTO> data);
}
