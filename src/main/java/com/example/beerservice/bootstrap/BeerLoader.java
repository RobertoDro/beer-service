package com.example.beerservice.bootstrap;

import com.example.beerservice.domain.Beer;
import com.example.beerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
    }

    private void loadBeer() {
        if(beerRepository.count()==0){

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs").beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(33701000001L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(33701000002L)
                    .price(new BigDecimal("11.99"))
                    .build());
        }
    }
}
