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
public class ItemDTO {

    private String itemCode;
    private String itemName;
    private String subCode;
    private String unit;
    private int price;
    private boolean supplying;

    public ItemDTO(String itemCode, String itemName, String subCode, String unit, int price, boolean supplying) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.subCode = subCode;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
    }

    public ItemDTO() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }

    public Vector getVector() {
        Vector vector = new Vector();
        vector.add(this.itemCode);
        vector.add(this.itemName);
        vector.add(this.subCode);
        vector.add(this.unit);
        vector.add(price);
        vector.add(supplying);
        return vector;
    }
}
