
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.daos;

import hieunnm.utils.DBAcess;
import hieunnm.dtos.ItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class ItemDAO {

    Connection conn = null;
    PreparedStatement prSt = null;
    ResultSet rs = null;

    public void disconnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (prSt != null) {
            prSt.close();
        }
        if (conn != null) {
            conn.close();
        }

    }

    public long countDB() throws Exception {
        long count = 0;
        try {
            String sql = "select count(*) from tblItems";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                count = rs.getLong(1);
            }
            rs.close();
            prSt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public Vector<ItemDTO> getJDPC(long numberpage) throws Exception {
        Vector<ItemDTO> vector = new Vector<>();
        try {
            String sql = "select top 5 * from tblItems where [itemCode] not in (select top " + (numberpage * 5 - 5) + " [itemCode] from tblItems)";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);
            rs = prSt.executeQuery();
            while (rs.next()) {
                ItemDTO item = new ItemDTO(rs.getString("itemCode"), rs.getString("itemName"), rs.getString("supCode"), rs.getString("unit"), rs.getInt("price"), rs.getBoolean("supplying"));
                vector.add(item);
            }
        } finally {
            disconnection();
        }
        return vector;

    }

    public void insertItem(ItemDTO item) throws Exception {

        try {
            String sql = "insert into tblItems values(?,?,?,?,?,?)";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);
            prSt.setString(1, item.getItemCode());
            prSt.setString(2, item.getItemName());
            prSt.setString(3, item.getSubCode());
            prSt.setString(4, item.getUnit());
            prSt.setInt(5, item.getPrice());
            prSt.setBoolean(6, item.isSupplying());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }

    }

    public void updateItem(ItemDTO item) throws Exception {
        try {
            String sql = "update tblItems set itemName=?, supCode=?,unit=?,price=?,supplying=? where itemCode=?";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);
            prSt.setString(1, item.getItemName());
            prSt.setString(2, item.getSubCode());
            prSt.setString(3, item.getUnit());
            prSt.setInt(4, item.getPrice());
            prSt.setBoolean(5, item.isSupplying());
            prSt.setString(6, item.getItemCode());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }

    public void deteleItem(String itemCode) throws Exception {
        try {
            String sql = "delete from tblItems where itemCode=?";
            conn = DBAcess.getConnection();
            prSt = conn.prepareCall(sql);
            prSt.setString(1, itemCode);
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }

}
