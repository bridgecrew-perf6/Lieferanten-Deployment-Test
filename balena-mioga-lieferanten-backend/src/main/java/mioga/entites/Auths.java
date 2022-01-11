package mioga.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "auths")
public class Auths {
    private int id;
    private Integer noAuth;
    private Integer loginAuth;
    private Integer tokenAuth;
    private Integer keyAuth;
    private Integer fkConnectionId;

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
    @Column(name = "no_auth")
    public Integer getNoAuth() {
        return noAuth;
    }

    public void setNoAuth(Integer noAuth) {
        this.noAuth = noAuth;
    }

    @Basic
    @Column(name = "login_auth")
    public Integer getLoginAuth() {
        return loginAuth;
    }

    public void setLoginAuth(Integer loginAuth) {
        this.loginAuth = loginAuth;
    }

    @Basic
    @Column(name = "token_auth")
    public Integer getTokenAuth() {
        return tokenAuth;
    }

    public void setTokenAuth(Integer tokenAuth) {
        this.tokenAuth = tokenAuth;
    }

    @Basic
    @Column(name = "key_auth")
    public Integer getKeyAuth() {
        return keyAuth;
    }

    public void setKeyAuth(Integer keyAuth) {
        this.keyAuth = keyAuth;
    }

    @Basic
    @Column(name = "FK_Connection_ID")
    public Integer getFkConnectionId() {
        return fkConnectionId;
    }

    public void setFkConnectionId(Integer fkConnectionId) {
        this.fkConnectionId = fkConnectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auths that = (Auths) o;
        return id == that.id && Objects.equals(noAuth, that.noAuth) && Objects.equals(loginAuth, that.loginAuth) && Objects.equals(tokenAuth, that.tokenAuth) && Objects.equals(keyAuth, that.keyAuth) && Objects.equals(fkConnectionId, that.fkConnectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noAuth, loginAuth, tokenAuth, keyAuth, fkConnectionId);
    }
}
