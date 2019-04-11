package datadb;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Kind {
    @Id
    public long id;
    //può essere solo uno tra Sea, Mountain, Art, Food e Romantic
    public String kind;

    public Kind() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}