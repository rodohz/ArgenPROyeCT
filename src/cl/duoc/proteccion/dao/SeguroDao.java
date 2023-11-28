package cl.duoc.proteccion.dao;

import cl.duoc.proteccion.basedatos.Conexion;
import cl.duoc.proteccion.dominio.Seguro;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;

public class SeguroDao {
 
    public boolean crear(Seguro seg) {
        boolean res = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement("insert into seguro (nombre, id, tipo) values (?,?,?)");
            ps.setString(1, seg.getNombre());
            ps.setInt(2, seg.getId());
            ps.setString(3, seg.getTipo());
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            System.out.println("error:" + ex.getMessage());
            res = false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("error: " + ex.getMessage());
            }

        }
        return res;
    }

    public boolean recuperar() {
        boolean res = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement("select nombre, id, tipo from seguro");
            rs = ps.executeQuary();

            while (rs.next())
            {
                Seguro seg = new Seguro();
                seg.setNombre(rs.getString("nombre"));
                seg.setId(rs.getInt("id"));
                seg.setTipo(rs.getString("tipo"));
                coleccion.add(seg);
            }
            catch (SQLException ex) {
                System.out.println("error:" + ex.getMessage());
            }
            finally {
                try {
                    
                    rs.close();
                    ps.close();
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
            return coleccion;
        
        }
    }

    public ArrayList<Seguro> recuperarFiltrado(String tipo) {
        ArrayList<Seguro> coleccion = new ArrayList<Seguro>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement("select nombre, id, tipo from seguro where nombre like '%" + nombre + "%' ");
            rs = ps.executeQuery();

            while (rs.next()) {
                Seguro seg = new Seguro();
                seg.setNombre(rs.getString("nombre"));
                seg.setId(rs.getInt("id"));
                seg.setTipo(rs.getString("tipo"));
                coleccion.add(seg);
            }

        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        } finally {

            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error:" + ex.getMessage());
            }

        }

        return coleccion;
    }

    public boolean recuperar(int id) {
        Seguro seg = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement("select nombre, id, tipo from seguro where id=?");
            ps.setString(1, idBuscado);
            rs = ps.executeQuary();

            while (rs.next()) {
                Seguro seg = new Seguro();
                seg.setNombre(rs.getString("nombre"));
                seg.setId(rs.getInt("id"));
                seg.setTipo(rs.getString("tipo"));
                coleccion.add(seg);

            }catch (SQLException ex) {
                System.out.println("error:" + ex.getMessage());
                
            }finally {
                try {
                    
                    rs.close();
                    ps.close();
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("error: " + ex.getMessage());
                }

            }
            return coleccion;
        }
    }
    public boolean actualizar(Seguro seg) {
        boolean res = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement(" update seguro set nombre=?, id=? where tipo=? ");
            ps.setString(1, seg.getNombre() );
            ps.setInt(2, seg.getId()   );
            ps.setString(3, seg.getTipo()   );
            ps.executeUpdate();
            res = true;
             
        } catch (SQLException ex) {
            System.out.println("Error:"+ex.getMessage());
            res = false;
             
        } finally {

            try{
                ps.close();
                con.close();
            }catch(SQLException ex){
                System.out.println("Error:"+ex.getMessage());
            }
        }
        return res;
    }
    public boolean eliminar(int id) {
        boolean res = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement(" delete from seguro where id=? ");
            ps.setString(1, id );
            ps.executeUpdate();
            res = true;
             
        } catch (SQLException ex) {
            System.out.println("Error:"+ex.getMessage());
            res = false;
             
        } finally {

            try{
                ps.close();
                con.close();
            }catch(SQLException ex){
                System.out.println("Error:"+ex.getMessage());
            }
        }
        return res;
    }

}
