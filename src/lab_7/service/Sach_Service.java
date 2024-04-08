/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_7.service;

//import com.sun.jdi.connect.Connector;
import java.util.ArrayList;
import lab_7.model.Sach;
import java.sql.*;
import lab_7.utility.DBcontext11;

/**
 *
 * @author Admin
 */
public class Sach_Service {
    public ArrayList<Sach> getAll() {
        ArrayList<Sach> dsSach = new ArrayList<>();
        try {
            String sql = "select Masach,TenSach,NXB,Giatien from SACH";
            Connection cn = DBcontext11.getConnection();
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Sach sa = new Sach();
                sa.setMaSach(rs.getString(1));
                sa.setTenSach(rs.getString(2));
                sa.setNXB(rs.getString(3));
                sa.setGiaTien(rs.getDouble(4));
                dsSach.add(sa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSach;
    }
}
