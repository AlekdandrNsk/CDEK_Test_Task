package CDEK.repository;

import CDEK.model.Entity;

import java.util.List;

public interface JdbcRepository {

    Entity save(String name);

    List<Entity> getAll();

    List<Entity> getByName(String name);
}
