package com.krishn.rest.ws.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {

    private final long resourceId;

    private final String description;

    private final long costInCents;

    private final boolean isComplete;

    public OrderResource(Order order) {
        this.resourceId = order.getId();
        this.description = order.getDescription();
        this.costInCents = order.getCostInCents();
        this.isComplete = order.isComplete();
    }

    @JsonProperty("id")
    public long getResourceId() {
        return resourceId;
    }

    public String getDescription() {
        return description;
    }

    public long getCostInCents() {
        return costInCents;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
