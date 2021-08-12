/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.daos;

import hieunnm.utils.DBAcess;
import hieunnm.dtos.SupplierDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class SupplierDAO {

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
            String sql = "select count(*) from tblSuppliers";
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

    public Vector<SupplierDTO> loadSupplier() throws Exception {

        Vector<SupplierDTO> vector = new Vector<>();
        try {
            String sql = "SELECT * from tblSuppliers";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);
            rs = prSt.executeQuery();
            while (rs.next()) {

                SupplierDTO sup = new SupplierDTO(rs.getString("supCode"), rs.getString("supName"), rs.getString("address"), rs.getBoolean("colloborating"));
                vector.add(sup);

            }
        } finally {
            disconnection();
        }

        return vector;
    }

    public void insertSup(SupplierDTO sup) throws Exception {
        try {
            String sql = "insert into tblSuppliers values (?,?,?,?)";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);
            prSt.setString(1, sup.getSupCode());
            prSt.setString(2, sup.getSupName());
            prSt.setString(3, sup.getAddress());
            prSt.setBoolean(4, sup.isCollorating());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }

    public void updateSup(SupplierDTO sup) throws Exception {
        try {
            String sql = "update tblSuppliers set supName=?,address=?, colloborating =? where supCode=?";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);

            prSt.setString(1, sup.getSupName());
            prSt.setString(2, sup.getAddress());
            prSt.setBoolean(3, sup.isCollorating());
            prSt.setString(4, sup.getSupCode());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }

    public void deleteSup(String supCode) throws Exception {
        try {
            String sql = "delete from tblSuppliers where supCode=?";
            conn = DBAcess.getConnection();
            prSt = conn.prepareStatement(sql);
            prSt.setString(1, supCode);
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }
}
