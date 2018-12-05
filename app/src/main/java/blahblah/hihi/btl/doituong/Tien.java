package blahblah.hihi.btl.doituong;

import java.io.Serializable;

/**
 * Created by Hihi on 23/10/2017.
 */

public class Tien implements Serializable {
    private int hinh;
    private int soTien;
    public Tien() {

    }

    public Tien(int hinh, int soTien, String loaiTien) {
        this.hinh = hinh;
        this.soTien = soTien;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }



}
