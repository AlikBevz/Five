package com.example.controllers;

import com.example.dto.MainpageCounterDto;
import com.example.entity.MainpageCounter;
import com.example.service.MainpageCounterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.net.HttpURLConnection.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@ApiResponses(value = {
        @ApiResponse(code = HTTP_UNAUTHORIZED, message = "You are not authorized "),
        @ApiResponse(code = HTTP_INTERNAL_ERROR, message = "System error occurred")
})

@RestController
@RequestMapping(value = "/v1/mainpage-counters")
@RequiredArgsConstructor
public class MainpageCounterController {

    private final MainpageCounterService mainpageCounterService;
    private final ModelMapper modelMapper;

    @ApiOperation(value = "Get list of the MainpageCounter")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_OK, message = "Request was successfully processed")
    })


    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<MainpageCounterDto>> getMainpageCounter() {
        return ResponseEntity.ok(mainpageCounterService.getAll()
                .stream()
                .map(MainpageCounter -> modelMapper.map(MainpageCounter, MainpageCounterDto.class))
                .collect(Collectors.toList()));
    }


    @ApiOperation(value = "Create new record for mainpage_counter")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_CREATED, message = "Resource was successfully created")
    })
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MainpageCounterDto> saveMainpageCounter(@Valid
                                                                  @RequestBody MainpageCounterDto mainpageCounterDto) {
        MainpageCounter mainpageCounter = mainpageCounterService.save(modelMapper.map(mainpageCounterDto,
                MainpageCounter.class));

        URI location =
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(mainpageCounter.getId()).toUri();

        return ResponseEntity.created(location).body(modelMapper.map(mainpageCounter, MainpageCounterDto.class));


    }

    @ApiOperation(value = "Get existing MainpageCounter")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_OK, message = "Request was successfully processed"),
            @ApiResponse(code = HTTP_NOT_FOUND, message = "The resource you were trying to reach is not found"),
    })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MainpageCounterDto> getMainpageCounterById(@PathVariable Long id) {
        return
                ResponseEntity.ok(modelMapper.map(mainpageCounterService.getById(id), MainpageCounterDto.class));
    }

    @ApiOperation(value = "Delete existing MainpageCounter")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_OK, message = "Request was successfully processed")}
    )

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MainpageCounterDto> deleteMainpageCounter(@PathVariable Long id) {
        ResponseEntity<MainpageCounterDto> responseEntity = ResponseEntity
                .ok(modelMapper.map(mainpageCounterService.getById(id), MainpageCounterDto.class));
        mainpageCounterService.delete(id);

        return responseEntity;

    }

    @ApiOperation(value = "Update existing MainpageCounter")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_OK, message = "Request was successfully processed"),
            @ApiResponse(code = HTTP_NOT_FOUND, message = "The resource you were trying to reach is not found")})

    @PutMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MainpageCounterDto> updateMainpageCounter(@Valid
                                                                    @RequestBody MainpageCounterDto mainpageCounterDto,
                                                                    @PathVariable Long id){
        MainpageCounterDto mainpageCounterDtoNow = modelMapper.map(mainpageCounterService.getById(id), MainpageCounterDto.class);

        if (mainpageCounterDtoNow==null ) { return ResponseEntity.notFound().build(); }

        mainpageCounterDto.setId(id);

        mainpageCounterService.save(modelMapper.map(mainpageCounterDto,
                MainpageCounter.class));

        return ResponseEntity.noContent().build();

    }


}
