package blahblah.hihi.btl.doituong;

import java.io.Serializable;

/**
 * Created by Hihi on 24/10/2017.
 */

public class ChiTra implements Serializable {
    private int hinh;
    private String noiDung;

    public ChiTra() {
    }

    public ChiTra(int hinh, String noiDung) {
        this.hinh = hinh;
        this.noiDung = noiDung;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
