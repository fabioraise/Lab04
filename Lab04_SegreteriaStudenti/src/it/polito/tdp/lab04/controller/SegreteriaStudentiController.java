package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> CorsiComboBox;

    @FXML
    private Button cercaIscrittiCorsoButton;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button cercaStudenteButton;

    @FXML
    private Button cercaCorsiButton;

    @FXML
    private Button iscriviButton;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button resetButton;

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    }

    @FXML
    void doCercaStudente(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert CorsiComboBox != null : "fx:id=\"CorsiComboBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaIscrittiCorsoButton != null : "fx:id=\"cercaIscrittiCorsoButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaStudenteButton != null : "fx:id=\"cercaStudenteButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaCorsiButton != null : "fx:id=\"cercaCorsiButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert iscriviButton != null : "fx:id=\"iscriviButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
