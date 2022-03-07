package Rol.GeneradorFichas;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Rol.GeneradorFichas.clases.DatosHarryPotter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ControladorHarryPotter {
	@FXML
	Button btnGenerar;
	
	@FXML
	TextField tfNombre;
	
	@FXML
	ComboBox cbAscendencia;
	
	@FXML
	ComboBox cbTipo;
	
	@FXML
	ComboBox cbCurso;
	
	@FXML
	ComboBox cbCasa;
	
	@FXML
	CheckBox chbMortifago;
	
	@FXML
	TextField tfPatronus;
	
	@FXML
	ComboBox cbMascota;
	
	@FXML
	ComboBox cbQuidditch;

	@FXML
	ComboBox cbOptativa1;
	
	@FXML
	ComboBox cbOptativa2;
	
	@FXML
	CheckBox chbPrefecto;
	
	@FXML
	ComboBox cbExtracurricular;
	
	DatosHarryPotter da = new DatosHarryPotter();
	
	public void initialize() {
		//genera las opciones de la lista desplegable
		cbAscendencia.getItems().setAll("Sangre pura", "Mestizo", "Nacido de muggle");
		cbTipo.getItems().setAll("Mago", "Animago", "Metamorfomago", "Parsel hablante", "Legeremante");
		cbCurso.getItems().setAll("1", "2", "3", "4", "5", "6", "7");
		cbCasa.getItems().setAll("Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin");
		cbMascota.getItems().setAll("Buho" , "Lechuza", "Sapo", "Rana", "Gato", "Raton");
		cbQuidditch.getItems().setAll("No juega", "Cazador", "Golpeador", "Guardian", "Buscador");
		cbOptativa1.getItems().setAll("Runas antiguas", "Aritmancia", "Estudios muggles", 
				"Cuidado de criaturas magicas", "Adivinacion", "Alquimia");
		cbOptativa2.getItems().setAll("Runas antiguas", "Aritmancia", "Estudios muggles", 
				"Cuidado de criaturas magicas", "Adivinacion", "Alquimia");
		cbExtracurricular.getItems().setAll("Estudios antiguos", "Arte y musica magica", 
				"Arte y musica muggle", "Magia terrestre", "Estudio de demonios encrofalos", 
				"Teoria magica", "Estudios avanzados de aritmancia", "Xilomancia", "Coro del sapo", 
				"Orquesta de Hogwarts", "Aparicion");		
	}
	
	//activar los campos conforme se sube de curso
	public void activarCursos() {
		int curso = Integer.parseInt(cbCurso.getValue().toString());
		
		if (curso == 1) {
			cbQuidditch.setDisable(true);
			cbOptativa1.setDisable(true);
			cbOptativa2.setDisable(true);
			chbPrefecto.setDisable(true);
			cbExtracurricular.setDisable(true);
		}
		
		if (curso == 2) {
			cbQuidditch.setDisable(false);
			cbOptativa1.setDisable(true);
			cbOptativa2.setDisable(true);
			chbPrefecto.setDisable(true);
			cbExtracurricular.setDisable(true);
		}
		
		if (curso == 3) {
			cbQuidditch.setDisable(false);
			cbOptativa1.setDisable(false);
			cbOptativa2.setDisable(false);
			chbPrefecto.setDisable(true);
			cbExtracurricular.setDisable(true);
		}
		
		if (curso == 4) {
			cbQuidditch.setDisable(false);
			cbOptativa1.setDisable(false);
			cbOptativa2.setDisable(false);
			chbPrefecto.setDisable(true);
			cbExtracurricular.setDisable(true);
		}
		
		if (curso == 5) {
			cbQuidditch.setDisable(false);
			cbOptativa1.setDisable(false);
			cbOptativa2.setDisable(false);
			chbPrefecto.setDisable(false);
			cbExtracurricular.setDisable(true);
		}
		
		if (curso == 6) {
			cbQuidditch.setDisable(false);
			cbOptativa1.setDisable(false);
			cbOptativa2.setDisable(false);
			chbPrefecto.setDisable(false);
			cbExtracurricular.setDisable(false);
		}
		
		if (curso == 7) {
			cbQuidditch.setDisable(false);
			cbOptativa1.setDisable(false);
			cbOptativa2.setDisable(false);
			chbPrefecto.setDisable(false);
			cbExtracurricular.setDisable(false);
		}
	}
	
	public void generarFicha() throws JRException {
		//asigna los datos al objeto
		da.setNombre(tfNombre.getText());
		da.setAscendencia(cbAscendencia.getValue().toString());
		da.setTipo(cbTipo.getValue().toString());
		da.setCurso(cbCurso.getValue().toString());
		da.setCasa(cbCasa.getValue().toString());
		da.setMortifago(chbMortifago.isSelected());
		da.setPatronus(tfPatronus.getText());
		da.setMascota(cbMascota.getValue().toString());
		
		if (cbQuidditch.getValue() == null) {
			da.setQuidditch("No juega");
		} else {
			da.setQuidditch(cbQuidditch.getValue().toString());
		}
		
		if (cbOptativa1.getValue() == null) {
			da.setOptativa1("No cursa optativas");
		} else {
			da.setOptativa1(cbOptativa1.getValue().toString());
		}
		
		if (cbOptativa2.getValue() == null) {
			da.setOptativa2("No cursa optativas");
		} else {
			da.setOptativa2(cbOptativa2.getValue().toString());
		}
		
		da.setPrefecto(chbPrefecto.isSelected());
		
		if (cbExtracurricular.getValue() == null) {
			da.setExtracurricular("No cursa extracurricular");
		} else {
			da.setExtracurricular(cbExtracurricular.getValue().toString());
		}
		
		//crea una lista con los datos
		Map<String, Object> parameters = new HashMap<String, Object>();
    	List<DatosHarryPotter> listaDatos = new ArrayList<>();
    	listaDatos.add(da);
    	
    	//genera el pdf de la ficha
    	InputStream is = Main.class.getResourceAsStream("FichaHarryPotter.jrxml");
    	JasperReport report = JasperCompileManager.compileReport(is);
    	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaDatos);
    	JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
    	JasperExportManager.exportReportToPdfFile(print, "FichaHarryPotter.pdf");
    	
    	//cierra la aplicacion
    	System.exit(0);
	}
}
