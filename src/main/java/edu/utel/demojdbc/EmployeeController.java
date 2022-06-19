package edu.utel.demojdbc;

import edu.utel.demojdbc.beans.Empleado;
import edu.utel.demojdbc.sql.EmpleadoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Optional;

public class EmployeeController {

    public TextField cmpId;
    public TextField cmpNombre;
    public TextField cmpApellidos;
    public TextField cmpEmail;
    public ComboBox cmpDepto;
    public TextField cmpSalario;
    public Label lblMesg;

    private final EmpleadoDAO dao = new EmpleadoDAO();
    private Empleado actual;

    public void buscar(ActionEvent actionEvent) {
        int id = Integer.parseInt(cmpId.getText());
        Optional<Empleado> opt = dao.obtener(id);
        opt.ifPresent( emp -> cargarDatos(emp) );
    }

    public void cancelar(ActionEvent actionEvent) {
        limpiarFormulario();
    }

    public void guardar(ActionEvent actionEvent) {
        if( actual != null ) {
            leerFormulario();
            if( dao.actualizar( actual ) == 1 ) lblMesg.setText("Registro actualizado");
            else lblMesg.setText("Error al actualizar");
            limpiarFormulario();
        }
    }

    private void limpiarFormulario() {
        cmpId.setText("");
        cmpNombre.setText("");
        cmpApellidos.setText("");
        cmpEmail.setText("");
        cmpSalario.setText("");
        cmpDepto.getSelectionModel().clearSelection();
        actual = null;
    }

    private void leerFormulario() {
        actual.setNombre(cmpNombre.getText());
        actual.setApellidos(cmpApellidos.getText());
        actual.setEmail(cmpEmail.getText());
        actual.setSalario(Float.parseFloat(cmpSalario.getText()));
        actual.setDepartamento( cmpDepto.getSelectionModel().getSelectedIndex()+1 );
    }

    private void cargarDatos(Empleado emp) {
        cmpId.setText(String.valueOf(emp.getId()));
        cmpNombre.setText(emp.getNombre());
        cmpApellidos.setText(emp.getApellidos());
        cmpEmail.setText(emp.getEmail());
        cmpSalario.setText(String.valueOf(emp.getSalario()));
        cmpDepto.getSelectionModel().select( emp.getDepartamento()-1 );
        actual = emp;
    }
}