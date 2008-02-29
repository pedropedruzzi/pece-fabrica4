package br.usp.poli.pece.ws;


import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import br.usp.poli.pece.bl.Pessoa;
import br.usp.poli.pece.bl.Usuario;
import br.usp.poli.pece.poc.PocIntegracao;
import br.usp.poli.pece.poc.PocIntegracaoInterface;

public class WebServicesServer {
	
	static final Logger logger = Logger.getLogger(WebServicesServer.class);
	
	private Endpoint alunos;
	
	public void start() {
		logger.info("Starting Server... ");
		String address = "http://0.0.0.0:9000/PocIntegracao";
		alunos = Endpoint.publish(address, new PocIntegracao());
		logger.info("Done!");
	}
	
	public void stop() {
		alunos.stop();
		alunos = null;
	}


	public static void main(String[] args) {
		WebServicesServer wss = new WebServicesServer();
		wss.start();
		/*
		clientTest();
		
		wss.stop();
		*/
	}
	
	public static void clientTest() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(PocIntegracaoInterface.class);
		factory.setAddress("http://localhost:9000/PocIntegracao");
		PocIntegracaoInterface client = (PocIntegracaoInterface) factory.create();

		List<Pessoa> lista = client.listaAlunos();
		System.out.println(lista);
	}
	
	public static void consultaAlunos() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(PocIntegracaoInterface.class);
		factory.setAddress("http://localhost:9000/PocIntegracao");
		PocIntegracaoInterface client = (PocIntegracaoInterface) factory.create();

		List<Usuario> lista = client.consultaUsuarios("");
		System.out.println(lista);
	}

}
