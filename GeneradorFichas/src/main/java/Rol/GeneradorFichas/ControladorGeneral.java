package Rol.GeneradorFichas;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Rol.GeneradorFichas.clases.DatosGenerales;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ControladorGeneral {
	@FXML
	Button btnGenerar;
	
	@FXML
	CheckBox chbGafas;
	
	@FXML
	TextArea taOtros;
	
	@FXML
	ComboBox cbSangre;
	
	@FXML
	TextField tfNombre;
	
	@FXML
	TextField tfEdad;
	
	@FXML
	TextField tfAltura;
	
	@FXML
	TextField tfPeso;
	
	@FXML
	TextField tfCumpleaños;
	
	@FXML
	TextField tfPelo;
	
	@FXML
	TextField tfRopa;
	
	@FXML
	TextField tfOjos;
	
	DatosGenerales da = new DatosGenerales();
	
	public void initialize() {
		//genera las opciones de la lista desplegable
		cbSangre.getItems().setAll("A", "B", "AB", "0");
	}
	
	public void generarFicha() throws JRException {
		//asigna los datos al objeto
		da.setNombre(tfNombre.getText());
		da.setCumpleaños(tfCumpleaños.getText());
		da.setEdad(tfEdad.getText());
		da.setAltura(tfAltura.getText());
		da.setPeso(tfPeso.getText());
		da.setSangre(cbSangre.getValue().toString());
		da.setPelo(tfPelo.getText());
		da.setOjos(tfOjos.getText());
		da.setGafas(chbGafas.isSelected());
		da.setRopa(tfRopa.getText());
		da.setOtros(taOtros.getText());
		
		//crea una lista con los datos
		Map<String, Object> parameters = new HashMap<String, Object>();
    	List<DatosGenerales> listaDatos = new ArrayList<>();
    	listaDatos.add(da);
    	
    	//genera el pdf de la ficha
    	InputStream is = Main.class.getResourceAsStream("FichaGeneral.jrxml");
    	JasperReport report = JasperCompileManager.compileReport(is);
    	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaDatos);
    	JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
    	JasperExportManager.exportReportToPdfFile(print, "FichaGeneral.pdf");
    	
    	//cierra la aplicacion
    	System.exit(0);
	}
}
