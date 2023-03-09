package com.example.controllers;

import java.util.List;

import com.example.domains.Serie;
import com.example.services.SerieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/shows", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, maxAge = 3600)
public class SerieController {

    
    //@Autowired
    SerieService libroService;
    public SerieController(SerieService libroService){
      this.libroService=libroService;
    }

    @GetMapping("")
    public ResponseEntity<List<Serie>> list(){
        return new ResponseEntity<List<Serie>>(libroService.getAll(),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Serie> add(@RequestBody Serie entity){
      if (libroService.save(entity).isPresent())
      return new ResponseEntity<Serie>(entity,HttpStatus.CREATED);
    else
      return new ResponseEntity<Serie>(HttpStatus.BAD_REQUEST);
 }

    @PutMapping("")
    public ResponseEntity<Serie>update(@RequestBody Serie entity){
      if (libroService.save(entity).isPresent())
        return new ResponseEntity<Serie>(entity,HttpStatus.CREATED);
      else
        return new ResponseEntity<Serie>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Serie>delete(@PathVariable Long id){
      if (libroService.delete(id).isPresent())
        return new ResponseEntity<Serie>(HttpStatus.OK);
      else
        return new ResponseEntity<Serie>(HttpStatus.NOT_FOUND);
    }
}
