package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Orders;
import id.sinaukoding23.latihan.model.Products;
import id.sinaukoding23.latihan.model.dto.CustomeCustomerDTO;
import id.sinaukoding23.latihan.model.dto.CustomeProductDTO;
import id.sinaukoding23.latihan.model.dto.OrderDTO;
import id.sinaukoding23.latihan.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PruductMappper {
    PruductMappper INSTANCE = Mappers.getMapper(PruductMappper.class);
    Products dtoToEntity(ProductDTO dto);

    ProductDTO entityToDto(Products param);

    List<Products> toEntityList(List<ProductDTO> data);

    List<ProductDTO> toDtoList(List<Products> data);

    CustomeProductDTO fromProductsToProduct(ProductDTO param);

    List<CustomeProductDTO> toCustomProduct(List<ProductDTO> data);

}
