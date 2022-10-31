package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Brands;
import id.sinaukoding23.latihan.model.dto.BrandsDTO;
import id.sinaukoding23.latihan.model.dto.CustomeBrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandsMapper {
    BrandsMapper INSTANCE = Mappers.getMapper(BrandsMapper.class);
    Brands dtoToEntity(BrandsDTO dto);

    BrandsDTO entityToDto(Brands param);

    List<Brands> toEntityList(List<BrandsDTO> data);

    List<BrandsDTO> toDtoList(List<Brands> data);

    CustomeBrandDTO fromBrandsToBrand(BrandsDTO param);

    List<CustomeBrandDTO> toCustomBrand(List<BrandsDTO> data);
}
