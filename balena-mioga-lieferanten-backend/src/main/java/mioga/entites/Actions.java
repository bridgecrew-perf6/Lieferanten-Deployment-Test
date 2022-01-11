package mioga.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actions")
public class Actions {
    private int id;
    private String title;
    private String description;
    private String commandline;
    private String uuid;
    private String updatedAt;
    private String successAt;
    private Integer FK_;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "commandline")
    public String getCommandline() {
        return commandline;
    }

    public void setCommandline(String commandline) {
        this.commandline = commandline;
    }

    @Basic
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "success_at")
    public String getSuccessAt() {
        return successAt;
    }

    public void setSuccessAt(String successAt) {
        this.successAt = successAt;
    }

    @Basic
    @Column(name = "FK_Zuliefer_ID")
    public Integer getFK_() {
        return FK_;
    }

    public void setFK_(Integer FK_) {
        this.FK_ = FK_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actions that = (Actions) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(commandline, that.commandline) && Objects.equals(uuid, that.uuid) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(successAt, that.successAt) && Objects.equals(FK_, that.FK_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, commandline, uuid, updatedAt, successAt, FK_);
    }
}
