/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentoome.property.domain.mapper;

import com.rentoome.property.domain.Property;
import com.rentoome.property.domain.PropertyImage;
import com.rentoome.property.domain.PropertyType;
import com.rentoome.property.domain.Ville;
import com.rentoome.property.domain.dto.PropertyDTO;
import com.rentoome.property.domain.dto.PropertyImageDTO;
import com.rentoome.property.domain.dto.PropertyTypeDTO;
import com.rentoome.property.domain.dto.VilleDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author DYNABOOK
 */
@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    /**
     *
     * @param propertyTypeDto
     * @return
     */
    PropertyType propertyTypeDtoTopropertyType(PropertyTypeDTO propertyTypeDto);

    List<PropertyType> propertyTypesDtoTopropertyTypes(List<PropertyTypeDTO> propertyTypeDtos);

    List<PropertyTypeDTO> propertyTypesTopropertyTypeDtos(List<PropertyType> propertiesTypes);

    PropertyTypeDTO propertyTypeTopropertyTypeDto(PropertyType propertyType);

    VilleDTO VilleToVilleDto(Ville ville);

    List<VilleDTO> VilleToVilleDto(List<Ville> ville);

    /**
     *
     * @param property
     * @return
     */
    // Property class and DTO
    Property propertyDtoToproperty(PropertyDTO propertyDto);

    List<Property> propertiesDtoToproperties(List<PropertyDTO> propertyDtos);

    List<PropertyDTO> propertiesTopropertiesDto(List<Property> properties);

    PropertyDTO propertyTopropertyDto(Property property);

    //PropertyImage class and DTO
    PropertyImage propertyImageDtoTopropertyImage(PropertyImageDTO propertyImageDto);

    List<PropertyImage> propertyImageDtosToPropertyImages(List<PropertyImageDTO> propertyImageDtos);

    List<PropertyImageDTO> propertyImagesTopropertiesImageDtos(List<PropertyImage> propertyImages);

    PropertyImageDTO propertyImageTopropertyImageDto(PropertyImage propertyImage);

    Ville VilleDtoToVille(VilleDTO villeDto);

    List<Ville> VilleDtosToVille(List<VilleDTO> villeDtos);

}
