package cdek;

import cdek.model.Entity;

import java.util.Arrays;
import java.util.List;

public class EntityUtil {

    public static final Entity ENTITY_1 = new Entity(1, "name1");
    public static final Entity ENTITY_2 = new Entity(2, "name2");
    public static final Entity ENTITY_3 = new Entity(3, "name3");
    public static final Entity ENTITY_4 = new Entity(4, "name4");

    public static final List<Entity> ENTITIES = Arrays.asList(ENTITY_1, ENTITY_2, ENTITY_3);

    public static final List<Entity> ENTITIES_NEW = Arrays.asList(ENTITY_1, ENTITY_2, ENTITY_3, ENTITY_4);


}
