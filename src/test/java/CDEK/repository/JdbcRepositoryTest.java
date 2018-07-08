package CDEK.repository;

import CDEK.EntityUtil;
import CDEK.model.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class JdbcRepositoryTest {

    @Autowired
    private JdbcRepository repository;

    @Test
    public void save() {
        repository.save("name4");
        assertEquals(repository.getAll(), EntityUtil.ENTITIES_NEW);
    }

    @Test
    public void getAll() {
        List<Entity> all = repository.getAll();
        assertEquals(all, EntityUtil.ENTITIES);
    }

    @Test
    public void getByName() {
        List<Entity> all = repository.getByName("name3");
        assertEquals(all, Collections.singletonList(EntityUtil.ENTITY_3));
    }
}
