package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
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
    private ComboBox<Corso> corsiComboBox;

    @FXML
    private Button cercaIscrittiCorsoButton;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button cercaStudenteButton;
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

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
    	String matricola = txtMatricola.getText();
    	
    	if(model.checkStudente(matricola) == 0)
    		txtResult.appendText("La matricola non è valida!\n");
    	else {
    		String result = model.cercaCorsi(matricola);
    		txtResult.clear();
    		txtResult.appendText(result);
    	}
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	Corso c = corsiComboBox.getValue();
    	
    	txtResult.clear();
    	
    	if(c == null || c.toString().equals(""))
    		txtResult.appendText("Seleziona un corso!\n");
    	else {
    		String result = model.cercaIscrittiCorso(c);
    		txtResult.appendText(result);
    	}
    }

    @FXML
    void doCercaStudente(ActionEvent event) {
    	String matricola = txtMatricola.getText();
    	
    	if(corsiComboBox.getValue() == null || corsiComboBox.getValue().toString().equals("")) {
    		if(model.checkStudente(matricola) == 0) {
    			txtResult.clear();
    			txtResult.appendText("La matricola selezionata non appartiene a nessuno studente!\n");
    		}
    		else {
    			String nome = model.cercaNomeStudente(matricola);
        		String cognome = model.cercaCognomeStudente(matricola);
    			txtNome.setText(nome);
    			txtCognome.setText(cognome);
    		}
    	} else {
    		txtResult.clear();
    		
    		Corso corso = corsiComboBox.getValue();
    		
    		if(model.checkStudente(matricola) == 0)
    			txtResult.appendText("La matricola selezionata non appartiene a nessuno studente!\n");
    		else {
    			boolean iscritto = model.checkIscrizione(matricola, corso);
    			if(iscritto)
    				txtResult.appendText("Lo studente è iscritto.\n");
    			else
    				txtResult.appendText("Lo studente non è iscritto.\n");
    		}
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	String matricola = txtMatricola.getText();
    	Corso corso = corsiComboBox.getValue();
    	
    	txtResult.clear();
    	if(model.iscrivi(matricola, corso))
    		txtResult.appendText("Iscrizione avvenuta con successo :)\n");
    	else
    		txtResult.appendText("Iscrizione non avvenuta :(\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtMatricola.clear();
    	this.txtNome.clear();
    	this.txtCognome.clear();
    	this.txtResult.clear();
    }

    @FXML
    void initialize() {
        assert corsiComboBox != null : "fx:id=\"CorsiComboBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaIscrittiCorsoButton != null : "fx:id=\"cercaIscrittiCorsoButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaStudenteButton != null : "fx:id=\"cercaStudenteButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaCorsiButton != null : "fx:id=\"cercaCorsiButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert iscriviButton != null : "fx:id=\"iscriviButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	corsiComboBox.getItems().addAll(model.getTuttiICorsi());    	
    }
}
