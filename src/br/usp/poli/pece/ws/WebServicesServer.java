package br.usp.poli.pece.ws;


import javax.xml.ws.Endpoint;
import org.apache.log4j.Logger;
import br.usp.poli.pece.ws.AcademicoAlunoImpl;

public class WebServicesServer {
	
	static final Logger logger = Logger.getLogger(WebServicesServer.class);
	
	private Endpoint alunos;
	
	public void start() {
		logger.info("Starting Server... ");
		String address = "http://localhost:9000/AcademicoAluno";
		alunos = Endpoint.publish(address, new AcademicoAlunoImpl());
		logger.info("Done!");
	}
	
	public void stop() {
		alunos.stop();
		alunos = null;
	}

	public static void main(String[] args) {
		WebServicesServer wss = new WebServicesServer();
		wss.start();
	}
}
