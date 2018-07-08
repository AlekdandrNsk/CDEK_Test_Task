package CDEK.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.PostConstruct;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RootControllerTest {
    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();

    static {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }

    private MockMvc mockMvc;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    private void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilter(CHARACTER_ENCODING_FILTER)
                .build();
    }

    @Before
    public void setUp() {
        cacheManager.getCache("entities").clear();
    }

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post("/create")
                .param("name", "name4"))
                .andDo(print())
                .andExpect(view().name("redirect:table"))
                .andExpect(redirectedUrl("table"));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/table"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("table"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/table.jsp"))
                .andExpect(model().attribute("table", hasSize(3)))
                .andExpect(model().attribute("table", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("name", is("name1"))
                        )
                )));

    }

    @Test
    public void testGetByName() throws Exception {
        mockMvc.perform(post("/filter")
                .param("name", "name2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("table"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/table.jsp"))
                .andExpect(model().attribute("table", hasSize(1)))
                .andExpect(model().attribute("table", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("name", is("name2"))
                        )
                )));
    }

}
