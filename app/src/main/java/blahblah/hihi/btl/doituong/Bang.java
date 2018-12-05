package blahblah.hihi.btl.doituong;

import java.io.Serializable;

/**
 * Created by Hihi on 24/10/2017.
 */

public class Bang implements Serializable {
    private String tieuDe, noiDung;

    public Bang() {
    }

    public Bang(String tieuDe, String noiDung) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
