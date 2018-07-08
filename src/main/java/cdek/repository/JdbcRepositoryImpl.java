package cdek.repository;

import cdek.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JdbcRepositoryImpl implements JdbcRepository {

    private static final BeanPropertyRowMapper<Entity> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Entity.class);

    private final JdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insertEntity;

    @Autowired
    public JdbcRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.insertEntity = new SimpleJdbcInsert(dataSource)
                .withTableName("table_CDEK")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Entity save(String name) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("name", name);

        Number id = insertEntity.executeAndReturnKey(map);

        return new Entity(id.intValue(), name);
    }

    @Override
    public List<Entity> getAll() {
        return jdbcTemplate.query("SELECT * FROM table_CDEK", ROW_MAPPER);
    }

    @Override
    public List<Entity> getByName(String name) {
        return jdbcTemplate.query("SELECT * FROM table_CDEK WHERE name = ?", ROW_MAPPER, name);
    }
}
