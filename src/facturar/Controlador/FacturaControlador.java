
package facturar.Controlador;

import facturar.Modelo.Factura;
import facturar.Modelo.Helper;
import facturar.Modelo.Repositorio;
import facturar.Vista.ViewFactura;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FacturaControlador {
      Repositorio <Factura> regFactura;
    public FacturaControlador() {
        regFactura = new Repositorio<>();
        regFactura.cargar("Factura");
    }
    public void  crear(ViewFactura  vfact){
                
        int idf =Integer.parseInt(vfact.txtId.getText());
        if (!(this.traer(idf)== null)){
            JOptionPane.showMessageDialog(null,"Factura Existe.Verifique");
            return;
        }
        Factura fact = new Factura();
        String  ele =vfact.cboClientes.getSelectedItem().toString();
        String  idCli =Helper.getKeyByValue(vfact.mapCli, ele);
        fact.setIdCliente(Integer.parseInt(idCli));
        fact.setId(Integer.parseInt(vfact.txtId.getText()));
        fact.setNum(vfact.txtNum.getText());
        fact.setDireccion(vfact.txtDireccion.getText());
        regFactura.adicionar(fact);
        regFactura.guardar("Factura");
        JOptionPane.showMessageDialog(null,"Registro Ha sido Guardado");
        vfact.btnAddProd.setEnabled(true);
    }
    public Factura traer(int id){         
        return (Factura)regFactura.traer(id);
     } 
}


