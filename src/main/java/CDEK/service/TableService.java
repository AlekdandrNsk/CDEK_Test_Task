package CDEK.service;

import CDEK.model.Entity;

import java.util.List;

public interface TableService {

    Entity save(String name);

    List<Entity> getAll();

    List<Entity> getByName(String name);
}
