package mioga.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "connections")
public class Connection {
    private int id;
    private Integer fkProtocolId;
    private String title;
    private String url;
    private String description;
    private Integer fkZulieferId;

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
    @Column(name = "FK_protocol_ID")
    public Integer getFkProtocolId() {
        return fkProtocolId;
    }

    public void setFkProtocolId(Integer fkProtocolId) {
        this.fkProtocolId = fkProtocolId;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    @Column(name = "FK_Zuliefer_ID")
    public Integer getFkZulieferId() {
        return fkZulieferId;
    }

    public void setFkZulieferId(Integer fkZulieferId) {
        this.fkZulieferId = fkZulieferId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return id == that.id && Objects.equals(fkProtocolId, that.fkProtocolId) && Objects.equals(title, that.title) && Objects.equals(url, that.url) && Objects.equals(description, that.description) && Objects.equals(fkZulieferId, that.fkZulieferId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkProtocolId, title, url, description, fkZulieferId);
    }
}
