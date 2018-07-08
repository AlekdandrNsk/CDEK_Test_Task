package CDEK.service;

import CDEK.EntityUtil;
import CDEK.model.Entity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/initDB_MySql.sql", config = @SqlConfig(encoding = "UTF-8"))
public class TableServiceTest {

    @Autowired
    private TableService service;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp() throws Exception {
        cacheManager.getCache("entities").clear();
    }


    @Test
    public void testSave() {
        service.save("name4");
        assertEquals(service.getAll(), EntityUtil.ENTITIES_NEW);
    }


    @Test
    public void testGetByName() throws Exception {
        List<Entity> all = service.getByName("name3");
        assertEquals(all, Collections.singletonList(EntityUtil.ENTITY_3));

    }


    @Test
    public void testGetAll() throws Exception {
        List<Entity> all = service.getAll();
        assertEquals(all, EntityUtil.ENTITIES);
    }
}
