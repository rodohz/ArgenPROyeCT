package cl.duoc.proteccion.control;

import cl.duoc.proteccion.dao.SeguroDao;
import cl.duoc.proteccion.dominio.Seguro;
import java.util.ArrayList;

public class ControlSeguro {

    public boolean agregarSeguro(String varNombre, int varId, String varTipo) {
        boolean res = false;
        Seguro seg = new Seguro();
        seg.setNombre(varNombre);
        seg.setId(varId);
        seg.setTipo(varTipo);

        SeguroDao sd = new SeguroDao();

    }

    public ArrayList<Seguro> recuperarSeguro() {
        ArrayList<Seguro> coleccion = new ArrayList<Seguro>();
        SeguroDao segdao = new SeguroDao();
        coleccion = segdao.recuperar();
        return coleccion;
    }

    public ArrayList<Seguro> recuperarSeguroFiltrado(String tipo, int id) {
        ArrayList<Seguro> coleccion = new ArrayList<Seguro>();
        SeguroDao segdao = new SeguroDao();
        coleccion = segdao.recuperarFiltrado(tipo, id);
        return coleccion;
    }

    public Seguro buscar(String tipo) {
        Seguro seg = null;
        SeguroDao segdao = new SeguroDao();
        seg = segdao.recuperar(tipo);
        return seg;
    }

    /* 
    public boolean agregarSeguro(String varNombre, int varId, String varTipo) {
        boolean res = false;
        Seguro seg = new Seguro();
        seg.setNombre(varNombre);
        seg.setId(varId);
        seg.setTipo(varTipo);
                
        SeguroDao sd = new SeguroDao();
        res = sd.actualizar(tipo);
        return res;
    }
    */
    
    public boolean eliminarSeguro(String tipo) {
        boolean res = false;
        SeguroDao sd = new SeguroDao();
        res = sd.eliminar(tipo);
        return res;
    }

}
