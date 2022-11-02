package id.sinaukoding.latihan.model.mapper;

import id.sinaukoding.latihan.model.Brand;
import id.sinaukoding.latihan.model.dto.BrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    Brand dtoToEntity(BrandDTO dto);

    BrandDTO entityToDto(Brand param);

    List<Brand> toEntityList(List<BrandDTO> data);

    List<BrandDTO> toDtoList(List<Brand> data);

}