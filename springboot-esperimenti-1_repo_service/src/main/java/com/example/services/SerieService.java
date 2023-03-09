package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.DemoApplication;
import com.example.domains.Serie;
import com.example.repositories.SerieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SerieService {
    @Autowired
    SerieRepository libroRepository;
    public SerieService(){
        
    }

    public Optional<Serie> save(Serie entity){
        Serie libro=libroRepository.save(entity);
        Optional<Serie> opt=Optional.ofNullable(libro);
        return opt;
    }
    
    public Optional<Serie> update(Serie entity){
        Serie libro=libroRepository.save(entity);
        Optional<Serie> opt=Optional.ofNullable(libro);
        return opt;
    }
    public List<Serie> getAll(){
        return libroRepository.findAll();
    }
    public Optional<Serie> findById(Long id){
        return libroRepository.findById(id);
    }
    public Optional<Serie>delete(Long id){
        Optional<Serie> opt=libroRepository.findById(id);
        if (opt.isPresent()){
            libroRepository.deleteById(id);
        }
        return opt;
    }
    
}
