package id.sinaukoding.latihan.model.mapper;

import id.sinaukoding.latihan.model.Store;
import id.sinaukoding.latihan.model.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    Store dtoToEntity(StoreDTO dto);

    StoreDTO entityToDto(Store param);

    List<Store> toEntityList(List<StoreDTO> data);

    List<StoreDTO> toDtoList(List<Store> data);

}