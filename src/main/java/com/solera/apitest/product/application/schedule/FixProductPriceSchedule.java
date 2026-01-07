package com.solera.apitest.product.application.schedule;

import com.solera.apitest.product.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FixProductPriceSchedule {

    private final ProductRepository productRepository;

    @Scheduled(fixedRate = 5000)
    public void fixProducPrice(){
        log.info("Inicio del método");

        log.info("Fin del método");
    }
}
