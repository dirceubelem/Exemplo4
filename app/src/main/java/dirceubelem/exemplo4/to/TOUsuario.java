package dirceubelem.exemplo4.to;

/**
 * Created by dirceubelem on 05/04/15.
 */
public class TOUsuario extends TOBase {

    private String usuario;
    private String avatar;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TOUsuario() {
    }

    public TOUsuario(String usuario, String avatar) {
        this.usuario = usuario;
        this.avatar = avatar;
    }
}
