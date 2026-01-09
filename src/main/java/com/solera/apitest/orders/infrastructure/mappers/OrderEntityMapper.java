package com.solera.apitest.orders.infrastructure.mappers;

import com.solera.apitest.orders.domain.models.Order;
import com.solera.apitest.orders.infrastructure.persistence.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {


    OrderEntity toEntity(Order order);


    Order toDomain(OrderEntity entity);


}
