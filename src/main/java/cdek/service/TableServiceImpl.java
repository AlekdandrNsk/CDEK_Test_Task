package cdek.service;

import cdek.model.Entity;
import cdek.repository.JdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcRepository repository;

    @Override
    @CacheEvict(value = "entities", allEntries = true)
    public Entity save(String name) {
        log.info("save entity with name {}", name);
        return repository.save(name);
    }

    @Override
    @Cacheable("entities")
    public List<Entity> getAll() {
        log.info("get all entities");
        return repository.getAll();
    }

    @Override
    public List<Entity> getByName(String name) {
        log.info("get entities with name {}", name);
        return repository.getByName(name);
    }
}
