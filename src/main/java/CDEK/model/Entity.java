package CDEK.model;

public class Entity {

    private int id;

    private String name;

    public Entity() {
    }

    public Entity(String name) {
        this.name = name;
    }

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return entity.id != 0 && this.id != 0 && id == entity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
