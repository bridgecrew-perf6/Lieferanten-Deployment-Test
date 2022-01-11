package mioga.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "protocol")
public class Protocol {
    private int id;
    private String sftp;
    private String restapi;
    private String scp;
    private String http;
    private String https;
    private String ftp;
    private String website;

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
    @Column(name = "SFTP")
    public String getSftp() {
        return sftp;
    }

    public void setSftp(String sftp) {
        this.sftp = sftp;
    }

    @Basic
    @Column(name = "RESTAPI")
    public String getRestapi() {
        return restapi;
    }

    public void setRestapi(String restapi) {
        this.restapi = restapi;
    }

    @Basic
    @Column(name = "SCP")
    public String getScp() {
        return scp;
    }

    public void setScp(String scp) {
        this.scp = scp;
    }

    @Basic
    @Column(name = "HTTP")
    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    @Basic
    @Column(name = "HTTPS")
    public String getHttps() {
        return https;
    }

    public void setHttps(String https) {
        this.https = https;
    }

    @Basic
    @Column(name = "FTP")
    public String getFtp() {
        return ftp;
    }

    public void setFtp(String ftp) {
        this.ftp = ftp;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Protocol that = (Protocol) o;
        return id == that.id && Objects.equals(sftp, that.sftp) && Objects.equals(restapi, that.restapi) && Objects.equals(scp, that.scp) && Objects.equals(http, that.http) && Objects.equals(https, that.https) && Objects.equals(ftp, that.ftp) && Objects.equals(website, that.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sftp, restapi, scp, http, https, ftp, website);
    }
}
