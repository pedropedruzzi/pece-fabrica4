package br.usp.poli.pece.ws;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import br.usp.poli.pece.poc.PocIntegracaoInterface;

public class WebServicesClient {
	
	public static PocIntegracaoInterface getAlunosWS() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(PocIntegracaoInterface.class);
		factory.setAddress("http://143.107.102.56:9000/PocIntegracao");
		PocIntegracaoInterface client = (PocIntegracaoInterface) factory.create();

		return client;
	}
	
	public static void main(String[] args) {
		PocIntegracaoInterface alunos = WebServicesClient.getAlunosWS();
		
		System.out.println(alunos.listaAlunos());
	}
}
