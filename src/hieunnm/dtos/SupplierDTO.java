/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.dtos;

import java.util.Vector;

/**
 *
 * @author PC
 */
public class SupplierDTO {

    String supCode;
    String supName;
    String address;
    boolean collorating;

    public SupplierDTO() {
    }

    public SupplierDTO(String supCode, String supName, String address, boolean collorating) {
        this.supCode = supCode;
        this.supName = supName;
        this.address = address;
        this.collorating = collorating;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCollorating() {
        return collorating;
    }

    public void setCollorating(boolean collorating) {
        this.collorating = collorating;
    }
    public Vector toVector(){
        Vector vector = new Vector();
        vector.add(this.supCode);
        vector.add(this.supName);
        vector.add(this.address);
        vector.add(this.collorating);
        return vector;
    }
   
}
