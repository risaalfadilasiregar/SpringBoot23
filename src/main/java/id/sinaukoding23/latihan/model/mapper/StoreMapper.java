package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Staffs;
import id.sinaukoding23.latihan.model.Stores;
import id.sinaukoding23.latihan.model.dto.CustomeStaffDTO;
import id.sinaukoding23.latihan.model.dto.CustomeStoreDTO;
import id.sinaukoding23.latihan.model.dto.StaffDTO;
import id.sinaukoding23.latihan.model.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
    Stores dtoToEntity(StoreDTO dto);

    StoreDTO entityToDto(Stores param);

    List<Stores> toEntityList(List<StoreDTO> data);

    List<StoreDTO> toDtoList(List<Stores> data);

    CustomeStoreDTO fromStoresToStore(StoreDTO param);

    List<CustomeStoreDTO> toCustomStore(List<StoreDTO> data);
}
