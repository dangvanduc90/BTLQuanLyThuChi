package blahblah.hihi.btl.doituong;

import java.io.Serializable;

/**
 * Created by Hihi on 26/10/2017.
 */

public class MainDanhSach implements Serializable {
    private String muc,diengiai,ngay,loai;
    private int sotien,hinh;

    public MainDanhSach(String muc, String diengiai, String ngay, String loai, int sotien, int hinh) {
        this.muc = muc;
        this.diengiai = diengiai;
        this.ngay = ngay;
        this.loai = loai;
        this.sotien = sotien;
        this.hinh = hinh;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public MainDanhSach() {
    }

    public String getMuc() {
        return muc;
    }

    public void setMuc(String muc) {
        this.muc = muc;
    }

    public String getDiengiai() {
        return diengiai;
    }

    public void setDiengiai(String diengiai) {
        this.diengiai = diengiai;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

}
