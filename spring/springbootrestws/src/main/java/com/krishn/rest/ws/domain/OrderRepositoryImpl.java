package com.krishn.rest.ws.domain;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends InMemoryRepository<Order> {

    @Override
    protected void updateIfExists(Order original, Order updated) {
        original.setCostInCents(updated.getCostInCents());
        original.setDescription(updated.getDescription());
        original.setComplete(updated.isComplete());
    }
}
