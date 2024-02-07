/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentoome.property.domain.mapper;

import com.rentoome.property.domain.Property;
import com.rentoome.property.domain.PropertyImage;
import com.rentoome.property.domain.PropertyType;
import com.rentoome.property.domain.dto.PropertyDto;
import com.rentoome.property.domain.dto.PropertyImageDto;
import com.rentoome.property.domain.dto.PropertyTypeDto;
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
    PropertyType propertyTypeDtoTopropertyType(PropertyTypeDto propertyTypeDto);

    List<PropertyType> propertyTypesDtoTopropertyTypes(List<PropertyTypeDto> propertyTypeDtos);

    List<PropertyTypeDto> propertyTypesTopropertyTypeDtos(List<PropertyType> propertiesTypes);

    PropertyTypeDto propertyTypeTopropertyTypeDto(PropertyType propertyType);

    /**
     *
     * @param property
     * @return
     */
    // Property class and DTO
    Property propertyDtoToproperty(PropertyDto propertyDto);

    List<Property> propertiesDtoToproperties(List<PropertyDto> propertyDtos);

    List<PropertyDto> propertiesTopropertiesDto(List<Property> properties);

    PropertyDto propertyTopropertyDto(Property property);

    //PropertyImage class and DTO
    PropertyImage propertyImageDtoTopropertyImage(PropertyImageDto propertyImageDto);

    List<PropertyImage> propertyImageDtosToPropertyImages(List<PropertyImageDto> propertyImageDtos);

    List<PropertyImageDto> propertyImagesTopropertiesImageDtos(List<PropertyImage> propertyImages);

    PropertyImageDto propertyImageTopropertyImageDto(PropertyImage propertyImage);
}
