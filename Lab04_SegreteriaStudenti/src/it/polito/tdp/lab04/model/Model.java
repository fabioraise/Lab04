package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.lab04.DAO.*;

public class Model {
	
	public List<Corso> getTuttiICorsi() {
		CorsoDAO cdao = new CorsoDAO();
		List<Corso> corsi = cdao.getTuttiICorsi();
		corsi.add(new Corso("", 0, "", 0));
		
		Collections.sort(corsi);
		
		return corsi;
	}
	
	/**********************************************************************************/
	
	/**
	 * cerca il nome dello studente passato
	 */
	public String cercaNomeStudente(String matricola) {
		StudenteDAO sdao = new StudenteDAO();
		String nome = sdao.cercaNomeStudente(matricola);
		return nome;
	}
	
	/**********************************************************************************/
	
	/**
	 * cerca il cognome dello studente passato
	 */
	public String cercaCognomeStudente(String matricola) {
		StudenteDAO sdao = new StudenteDAO();
		String cognome = sdao.cercaCognomeStudente(matricola);
		return cognome;
	}

	/**********************************************************************************/
	
	/**
	 * cerca gli iscritti al corso selezionato
	 * @param c
	 * @return
	 */
	public String cercaIscrittiCorso(Corso c) {
		StudenteDAO sdao = new StudenteDAO();
		List<Studente> studenti = sdao.cercaIscrittiCorso(c.getCodins());
		
		if(studenti == null)
			return null;
		
		String result = "";
		for(Studente s : studenti) {
			result += s.toString() + "\n";
		}
		
		return result;
	}

	/**********************************************************************************/
	
	public String cercaCorsi(String matricola) {
		StudenteDAO sdao = new StudenteDAO();
		
		List<Corso> corsi = sdao.cercaCorsi(matricola);
		
		String result = "";
		for(Corso c : corsi) {
			result += c.toString() + "\n";
		}
		
		return result;
	}

	/**********************************************************************************/
	
	public boolean checkIscrizione(String matricola, Corso corso) {
		StudenteDAO sdao = new StudenteDAO();
		String codins = corso.getCodins();
		
		return sdao.checkIscrizione(matricola, codins);
	}
	
	public int checkStudente(String matricola) {
		StudenteDAO sdao = new StudenteDAO();
		if(sdao.cercaNomeStudente(matricola) == null)
			return 0;
		else
			return 1;
	}
	
	/**********************************************************************************/
	
	public boolean iscrivi(String matricola, Corso corso) {
		CorsoDAO cdao = new CorsoDAO();
		if(cdao.iscriviStudenteACorso(matricola, corso.getCodins()))
			return true;
		else
			return false;
	}
}
