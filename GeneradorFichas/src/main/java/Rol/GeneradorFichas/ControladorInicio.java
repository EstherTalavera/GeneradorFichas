package Rol.GeneradorFichas;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorInicio {
	@FXML
	Button btnGeneral;
	
	@FXML
	Button btnHarryPotter;
	
	@FXML
	Button btnGenshinImpact;
	
	public void initialize() {}
	
	public void cargarGenereal () throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
       	fxmlLoader.setLocation(getClass().getResource("general.fxml"));
       	Stage stage = (Stage) btnGeneral.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
	}
	
	public void cargarHarryPotter () throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
       	fxmlLoader.setLocation(getClass().getResource("harryPotter.fxml"));
       	Stage stage = (Stage) btnHarryPotter.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
	}
	
	public void cargarGenshinImpact () throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
       	fxmlLoader.setLocation(getClass().getResource("genshinImpact.fxml"));
       	Stage stage = (Stage) btnGenshinImpact.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
	}
}
