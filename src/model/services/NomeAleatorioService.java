package model.services;

import java.util.concurrent.ThreadLocalRandom;

public class NomeAleatorioService {
	private static final String[] NOMES = { "Luna", "Theo", "Maya", "Ravi", "Clara" };
	private static final String[] SOBRENOMES = { "Silva", "Souza", "Pereira", "Oliveira", "Costa" };
	
	public String gerarNome() {
        return NOMES[ThreadLocalRandom.current().nextInt(NOMES.length)] + " " +
               SOBRENOMES[ThreadLocalRandom.current().nextInt(SOBRENOMES.length)];
    }
}
