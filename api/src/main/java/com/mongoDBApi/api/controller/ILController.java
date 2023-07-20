package com.mongoDBApi.api.controller;

import com.mongoDBApi.api.model.IL;
import com.mongoDBApi.api.service.ILService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
@AllArgsConstructor

@RestController//controller olduğunu söylüyor
@RequestMapping("/cities")
public class ILController {
    private final ILService ilService;
    @GetMapping
    public ResponseEntity<List<IL>> getCities()
    {

        return new ResponseEntity<>(ilService.getIller(), OK);//bu sayfaya kod vermek için mesela 404 kodu gibi
    }
    @GetMapping("/{id}")//bu id ile city buluyor yolu ona göre yapıyır path variable ile çalışıyor
    public ResponseEntity<IL> getCity(@PathVariable String id)//bu {id} kısmını buluyor süslü parantenizin iççinde ne varsa burda da o olmalı
    {
       IL founded =  getILById(id);
       return new ResponseEntity<>(founded,OK);
    }

    //obje eklemek için yapılır
    @PostMapping
    public ResponseEntity<IL> createCity(@RequestBody IL newCity){

        return new ResponseEntity<>(ilService.createIl(newCity), HttpStatus.CREATED);
    }
    //objeyi değiştirmek için put kullanılır yine bodye nasıl değiştireceğimizi söylüyoruz
    @PutMapping("/{id}")
    public ResponseEntity<Void>  getCity(@PathVariable String id, @RequestBody IL newCity)
    {
        IL oldCity = getILById(id);
        oldCity.setName(newCity.getName());

        IL updatedCity= ilService.updateIl(oldCity);
        if (updatedCity != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")//bunu bodye değik httpe kısmına yazacağız
    public ResponseEntity<Void> deleteCity(@PathVariable String id)
    {
        ilService.deleteIl(id);
        return new ResponseEntity<>(OK);
    }
    private IL getILById(String id)
    {
        return ilService.getIlById(id);
    }
}
