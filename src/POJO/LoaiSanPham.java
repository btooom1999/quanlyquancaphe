/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.logging.Logger;

/**
 *
 * @author btooo
 */
public class LoaiSanPham {
    private String malsp, tenlsp;

    public LoaiSanPham(String malsp, String tenlsp) {
        this.malsp = malsp;
        this.tenlsp = tenlsp;
    }

    public String getMalsp() {
        return malsp;
    }

    public String getTenlsp() {
        return tenlsp;
    }

    public void setMalsp(String malsp) {
        this.malsp = malsp;
    }

    public void setTenlsp(String tenlsp) {
        this.tenlsp = tenlsp;
    }

    @Override
    public String toString() {
        return "LoaiSanPham{" + "malsp=" + malsp + ", tenlsp=" + tenlsp + '}';
    }
}
