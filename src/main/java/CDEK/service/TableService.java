package CDEK.service;

import CDEK.model.Entity;
import CDEK.repository.JdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcRepository repository;

    public Entity save(String name){
        log.info("save entity with name {}", name);
        return repository.save(name);
    }

    public List<Entity> getAll(){
        log.info("get all entities");
        return repository.getAll();
    }

    public List<Entity> getByName(String name){
        log.info("get entities with name {}", name);
        return repository.getByName(name);
    }
}
