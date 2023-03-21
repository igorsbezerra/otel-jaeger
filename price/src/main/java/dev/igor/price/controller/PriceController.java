package dev.igor.price.controller;

import dev.igor.price.model.Price;
import dev.igor.price.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    private final PriceRepository repository;

    public PriceController(PriceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/price/{id}")
    public Price getPrice(@PathVariable("id") long productId) {
        LOGGER.info("Getting Price details for Product Id {}", productId);
        return repository.getPrice(productId);
    }
}