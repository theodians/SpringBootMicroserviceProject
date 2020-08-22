package com.example.MicroProject.web.controller;

import com.example.MicroProject.services.BeerService;
import com.example.MicroProject.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MicroProject.services.BeerService;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    private final BeerService beerService;
    @Autowired
    public BeerController(BeerService beerService1) {
        this.beerService = beerService1;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(BeerDto beerDto){
        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Locations","api/v1/beer/"+savedDto.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }
}
