package id.sinaukoding.latihan.model.mapper;

import id.sinaukoding.latihan.model.Category;
import id.sinaukoding.latihan.model.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category dtoToEntity(CategoryDTO dto);

    CategoryDTO entityToDto(Category param);

    List<Category> toEntityList(List<CategoryDTO> data);

    List<CategoryDTO> toDtoList(List<Category> data);

}