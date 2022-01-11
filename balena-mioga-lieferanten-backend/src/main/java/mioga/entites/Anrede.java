package mioga.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "anrede")
public class Anrede {
    private int id;
    private String anrede;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "anrede")
    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anrede that = (Anrede) o;
        return id == that.id && Objects.equals(anrede, that.anrede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anrede);
    }
}
