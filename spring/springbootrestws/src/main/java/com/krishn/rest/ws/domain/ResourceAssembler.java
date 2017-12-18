package com.krishn.rest.ws.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ResourceAssembler<D, R> {

    @Autowired
    protected EntityLinks entityLinks;

    protected static final String UPDATE_REL = "update";
    protected static final String DELETE_REL = "delete";

    protected abstract R toResource(D d);

    public Collection<R> toResourceCollection(List<D> dList) {
        return dList.stream().map(this::toResource).collect(Collectors.toList());
    }
}
