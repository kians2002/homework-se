import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EntityManager<T> {
    private List<T> entities;

    public EntityManager() {
        this.entities = new ArrayList<>();
    }

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public T getEntityById(Predicate<T> predicate) {
        for (T entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }
        return null;
    }

    public List<T> getAllEntities() {
        return entities;
    }

    public List<T> filterEntities(Predicate<T> predicate) {
        List<T> filteredEntities = new ArrayList<>();
        for (T entity : entities) {
            if (predicate.test(entity)) {
                filteredEntities.add(entity);
            }
        }
        return filteredEntities;
    }
}
