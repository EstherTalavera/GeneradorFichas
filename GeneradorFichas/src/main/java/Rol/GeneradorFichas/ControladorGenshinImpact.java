package Rol.GeneradorFichas;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Rol.GeneradorFichas.clases.DatosGenshinImpact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ControladorGenshinImpact {
	@FXML
	Button btnGenerar;
	
	@FXML
	TextField tfNombre;
	
	@FXML
	TextField tfCumpleaños;
	
	@FXML
	ComboBox cbVision;
	
	@FXML
	ComboBox cbArma;
	
	@FXML
	ComboBox cbRol;
	
	@FXML
	ComboBox cbRegion;
	
	@FXML
	TextField tfConstelacion;
	
	@FXML
	TextField tfAfiliacion;
	
	@FXML
	TextArea taDescripcion;
	
	DatosGenshinImpact da = new DatosGenshinImpact();
	
	public void initialize() {
		//genera las opciones de las listas desplegables
		cbVision.getItems().setAll("Pyro", "Hydro", "Electro", "Cryo", "Dendro", "Anemo", "Geo");
		cbArma.getItems().setAll("Arco", "Catalizador", "Mandoble", "Lanza", "Espada ligera");
		cbRol.getItems().setAll("DPS","Sub-DPS", "Support escudo", "Curador", "Explosion elemental");
		cbRegion.getItems().setAll("Mondstadt", "Liyue", "Inazuma", "Sumeru", "Fontaine", "Natlan", "Snezhnaya");
	}
	
	public void generarFicha() throws JRException {
		//asigna los datos al objeto
		da.setNombre(tfNombre.getText());
		da.setCumpleaños(tfCumpleaños.getText());
		da.setVision(cbVision.getValue().toString());
		da.setArma(cbArma.getValue().toString());
		da.setRol(cbRol.getValue().toString());
		da.setRegion(cbRegion.getValue().toString());
		da.setConstelacion(tfConstelacion.getText());
		da.setAfiliacion(tfAfiliacion.getText());
		da.setDescripcion(taDescripcion.getText());
		
		//crea una lista con los datos
		Map<String, Object> parameters = new HashMap<String, Object>();
    	List<DatosGenshinImpact> listaDatos = new ArrayList<>();
    	listaDatos.add(da);
    	
    	//genera el pdf de la ficha
    	InputStream is = Main.class.getResourceAsStream("FichaGenshinImpact.jrxml");
    	JasperReport report = JasperCompileManager.compileReport(is);
    	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaDatos);
    	JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
    	JasperExportManager.exportReportToPdfFile(print, "FichaGenshinImpact.pdf");
    	
    	System.exit(0);
	}
}
