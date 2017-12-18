package com.krishn.rest.ws.domain;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {

    private AtomicLong id = new AtomicLong(1);


    public Long getId() {
        return id.getAndIncrement();
    }
}
