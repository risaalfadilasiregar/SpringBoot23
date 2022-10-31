package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Staffs;
import id.sinaukoding23.latihan.model.dto.CustomeStaffDTO;
import id.sinaukoding23.latihan.model.dto.ProductDTO;
import id.sinaukoding23.latihan.model.dto.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
    Staffs dtoToEntity(StaffDTO dto);

    StaffDTO entityToDto(Staffs param);

    List<Staffs> toEntityList(List<StaffDTO> data);

    List<StaffDTO> toDtoList(List<Staffs> data);

    CustomeStaffDTO fromStaffsToStaff(StaffDTO param);

    List<CustomeStaffDTO> toCustomStaff(List<StaffDTO> data);

}
