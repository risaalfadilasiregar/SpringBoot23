package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Categories;
import id.sinaukoding23.latihan.model.dto.CategoriesDTO;
import id.sinaukoding23.latihan.model.dto.CustomeCategoriesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Categories dtoToEntity(CategoriesDTO dto);

    CategoriesDTO entityToDto(Categories param);

    List<Categories> toEntityList(List<CategoriesDTO> data);

    List<CategoriesDTO> toDtoList(List<Categories> data);

    CustomeCategoriesDTO fromCategoriesToCategory(CategoriesDTO param);

    List<CustomeCategoriesDTO> toCustomCategory(List<CategoriesDTO> data);

}
