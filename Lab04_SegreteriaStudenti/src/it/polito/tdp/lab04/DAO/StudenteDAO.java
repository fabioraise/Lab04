package it.polito.tdp.lab04.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public String cercaNomeStudente(String matricola) {
		
		String sql = "SELECT nome " + 
					 "FROM studente " + 
					 "WHERE matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				String nome = rs.getString("nome");
				conn.close();
				return nome;
			}
			else {
				conn.close();
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public String cercaCognomeStudente(String matricola) {
		
		String sql = "SELECT cognome " + 
					 "FROM studente " + 
					 "WHERE matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				String cognome = rs.getString("cognome");
				conn.close();
				return cognome;
			}
			else {
				conn.close();
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	public List<Studente> cercaIscrittiCorso(String codins) {
		if(codins.equals(""))
			return null;
		
		String sql = "SELECT s.matricola, s.cognome, s.nome, s.CDS " + 
				     "FROM studente s, iscrizione i " + 
				     "WHERE s.matricola = i.matricola AND i.codins = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);
			
			ResultSet rs = st.executeQuery();
			
			List<Studente> studenti = new ArrayList<Studente>();
			
			while(rs.next()) {
				studenti.add(new Studente(rs.getInt("matricola"),
										  rs.getString("cognome"),
										  rs.getString("nome"),
										  rs.getString("CDS")));
			}
			
			conn.close();
			
			return studenti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	public List<Corso> cercaCorsi(String matricola) {
		String sql = "SELECT c.codins, c.crediti, c.nome, c.pd " +
					 "FROM iscrizione i, corso c " +
					 "WHERE i.codins = c.codins AND i.matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			List<Corso> corsi = new ArrayList<Corso>();
			
			while(rs.next()) {
				corsi.add(new Corso(rs.getString("codins"),
								    rs.getInt("crediti"),
								    rs.getString("nome"),
								    rs.getInt("pd")));
			}
			
			conn.close();
			
			return corsi;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public boolean checkIscrizione(String matricola, String codins) {
		String sql = "SELECT * " + 
					 "FROM iscrizione " + 
					 "WHERE matricola = ? AND codins = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			st.setString(2, codins);
			
			ResultSet rs = st.executeQuery();
			
			boolean iscritto;
			if(rs.next())
				iscritto = true;
			else
				iscritto = false;
			
			conn.close();
			
			return iscritto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
