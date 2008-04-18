package br.usp.poli.pece.ws;


import javax.xml.ws.Endpoint;
import org.apache.log4j.Logger;
import br.usp.poli.pece.ws.AcademicoAlunoImpl;

public class WebServicesServer {
	
	static final Logger logger = Logger.getLogger(WebServicesServer.class);
	
	private Endpoint alunos;
	private Endpoint financeiro;
	private Endpoint estrategico;
	
	public void start() {
		logger.info("Starting Server... ");
		alunos = Endpoint.publish("http://0.0.0.0:9000/AcademicoAluno", new AcademicoAlunoImpl());
		financeiro = Endpoint.publish("http://0.0.0.0:9000/AcademicoFinanceiro", new AcademicoFinanceiroImpl());
		estrategico = Endpoint.publish("http://0.0.0.0:9000/AcademicoEstrategico", new AcademicoEstrategicoImpl());
		logger.info("Done!");
	}
	
	public void stop() {
		alunos.stop();
		financeiro.stop();
		estrategico.stop();
		alunos = null;
	}

	public static void main(String[] args) {
		WebServicesServer wss = new WebServicesServer();
		wss.start();
	}
}
