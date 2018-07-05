package CDEK.repository;

import CDEK.model.Entity;
import CDEK.util.EntityUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRepository {
    public List<Entity> ENTITIES = EntityUtil.ENTITIES;
}
