package braveprogrammerapp.braveprogrammer.controller;

import braveprogrammerapp.braveprogrammer.exception.AppException;
import braveprogrammerapp.braveprogrammer.model.request.VictimRequestList;
import braveprogrammerapp.braveprogrammer.model.response.WebResponse;
import braveprogrammerapp.braveprogrammer.services.CalculateAverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebController {

    @Autowired
    private CalculateAverageService calculateAverageService;

    @PostMapping(
            value = "/calculate-victim",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<WebResponse> averageVictim(
            @Validated @RequestBody VictimRequestList request
    ) {
        Double average = calculateAverageService.calculateAverageVictim(
                request.getVictimA(),
                request.getVictimB()
        );

        WebResponse response = new WebResponse(average, "");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
