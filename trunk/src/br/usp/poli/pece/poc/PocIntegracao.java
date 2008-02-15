package br.usp.poli.pece.poc;

import java.util.ArrayList;
import java.util.List;

import javax.jws.*;

import org.hibernate.Session;

import br.usp.poli.pece.db.DataBaseUtil;
import br.usp.poli.pece.bl.Pessoa;

@WebService(endpointInterface="br.usp.poli.pece.poc.PocIntegracaoInterface")

public class PocIntegracao implements PocIntegracaoInterface {
	
	public List<String> listaAlunos() {
		
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
						
		List<String> listaAlunos = new ArrayList<String>();
		
		listaAlunos.add("Virgilio");
		listaAlunos.add("Gabriel");
		
		return listaAlunos;
	}
}
