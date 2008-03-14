package br.usp.poli.pece.ws;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import br.usp.poli.pece.bl.Aluno;

public class WebServicesClient {
	
	public static AcademicoAluno getAlunosWS() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(AcademicoAluno.class);
		factory.setAddress("http://localhost:9000/AcademicoAluno");
		AcademicoAluno client = (AcademicoAluno) factory.create();

		return client;
	}
	
	
	//Teste para funcoes de aluno
	public static void main(String[] args) {
		/*
		 * TODO
		 */
		AcademicoAluno aluno = WebServicesClient.getAlunosWS();
				
		List<Aluno> l = aluno.consultaAluno("");
		System.out.println("Daqui!");
		
		System.out.println("Tamanho: " + l.size());
		
		for (Aluno a : l)
			System.out.println(a.getNome());
	}
}
