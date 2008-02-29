package br.usp.poli.pece.ws;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import br.usp.poli.pece.bl.Pessoa;
import br.usp.poli.pece.db.PessoaDAO;
import br.usp.poli.pece.poc.PocIntegracaoInterface;

public class WebServicesClient {
	
	public static PocIntegracaoInterface getAlunosWS() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(PocIntegracaoInterface.class);
		factory.setAddress("http://143.107.102.47:9000/PocIntegracao");
		PocIntegracaoInterface client = (PocIntegracaoInterface) factory.create();

		return client;
	}
	
	public static void main(String[] args) {
		/*
		 * TODO
		 */
		
		PocIntegracaoInterface alunos = WebServicesClient.getAlunosWS();
		
		
		List<Pessoa> l = alunos.listaAlunos();
		System.out.println("Retornou!");
		
		System.out.println("Tamanho: " + l.size());
		
		for (Pessoa p : l)
			System.out.println(p.getNome());
	}
}
