package com.krishn.rest.ws.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Order.class)
@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderRepositoryImpl orderRepository;
    @Autowired
    private OrderResourceAssembler orderResourceAssembler;

    @GetMapping
    public ResponseEntity<Collection<OrderResource>> findAll() {
        final List<Order> all = orderRepository.findAll();
        final Collection<OrderResource> orderResources = orderResourceAssembler.toResourceCollection(all);
        return new ResponseEntity<>(orderResources, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResource> findById(@PathVariable long id) {
        final Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.map(order -> new ResponseEntity<>(orderResourceAssembler.toResource(order), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResource> update(@PathVariable long id, @RequestBody Order order) {
        final boolean updated = orderRepository.update(id, order);
        if (updated) {
            return findById(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<OrderResource> delete(@PathVariable long id) {
        final boolean deleted = orderRepository.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResource> create(@RequestBody Order order) {
        final Order order1 = orderRepository.create(order);
        return new ResponseEntity<>(orderResourceAssembler.toResource(order1), HttpStatus.OK);
    }

}
