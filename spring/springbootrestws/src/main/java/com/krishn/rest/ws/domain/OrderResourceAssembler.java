package com.krishn.rest.ws.domain;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class OrderResourceAssembler extends ResourceAssembler<Order, OrderResource> {

    @Override
    protected OrderResource toResource(Order order) {
        OrderResource orderResource = new OrderResource(order);

        final Link link = entityLinks.linkToSingleResource(order);
        orderResource.add(link.withSelfRel());
        orderResource.add(link.withRel(UPDATE_REL));
        orderResource.add(link.withRel(DELETE_REL));
        return orderResource;
    }
}
