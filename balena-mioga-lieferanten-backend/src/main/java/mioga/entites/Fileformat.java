package mioga.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fileformat")
public class Fileformat {
    private int id;
    private String fileType;
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
    @Column(name = "file_type")
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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
        Fileformat that = (Fileformat) o;
        return id == that.id && Objects.equals(fileType, that.fileType) && Objects.equals(fkZulieferId, that.fkZulieferId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileType, fkZulieferId);
    }
}
