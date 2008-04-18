package br.usp.poli.pece.ws;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import br.usp.poli.pece.ws.bl.Aluno;

public class WebServicesClient {
	
	private static JaxWsProxyFactoryBean academico;
	private static JaxWsProxyFactoryBean financeiro;
	
	static {
		academico = new JaxWsProxyFactoryBean();
		academico.getInInterceptors().add(new LoggingInInterceptor());
		academico.getOutInterceptors().add(new LoggingOutInterceptor());
		academico.setServiceClass(AcademicoAluno.class);
		academico.setAddress("http://localhost:9000/AcademicoAluno");

		financeiro = new JaxWsProxyFactoryBean();
		financeiro.getInInterceptors().add(new LoggingInInterceptor());
		financeiro.getOutInterceptors().add(new LoggingOutInterceptor());
		financeiro.setServiceClass(Financeiro.class);
		financeiro.setAddress("http://143.107.102.56:9000/Financeiro");
	}
	
	public static AcademicoAluno getAlunosWS() {
		return (AcademicoAluno) academico.create();
	}
	
	public static Financeiro getFinanceiroWS() {
		return (Financeiro) financeiro.create();
	}
	
	public static void main(String[] args) {
		AcademicoAluno aluno = WebServicesClient.getAlunosWS();
				
		List<Aluno> l = aluno.consultaAluno("");
		System.out.println("Daqui!");
		
		if (l == null) {
			System.out.println("null!");
			return;
		}
		
		System.out.println("Tamanho: " + l.size());
		
		for (Aluno a : l)
			System.out.println(a.nome);
	}
}
