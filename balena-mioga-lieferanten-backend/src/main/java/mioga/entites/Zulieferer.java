package mioga.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "zulieferer")
public class Zulieferer implements Serializable {
    // TODO: 10/15/2021  add a company field


    @Id
    @Column(name = "zulieferer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Autowired
    public Zulieferer(String title, String description, String uuid, String updatedAt, String successAt, Integer timetableId, ArrayList<Contacts> contacts) {
        this.title = title;
        this.description = description;
        this.uuid = uuid;
        this.updatedAt = updatedAt;
        this.successAt = successAt;
        this.timetableId = timetableId;
        this.contacts= contacts;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "belongs_to")
    private BelongsTo belongsTo;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "updated_at")

    private String updatedAt;

    @Column(name = "success_at")
    private String successAt;

    @Column(name = "timetable_id")
    private Integer timetableId;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "zulieferer_id", referencedColumnName = "zulieferer_id")
    private List<Contacts> contacts;







}
