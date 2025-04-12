package model.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void info(String mensagem) {
		String timestamp = LocalDateTime.now().format(FORMATTER);
		System.out.printf("[%s] [INFO] %s\n", timestamp, mensagem);
	}

	public static void error(String mensagem, Throwable erro) {
		String timestamp = LocalDateTime.now().format(FORMATTER);
		System.out.printf("[%s] [ERROR] %s\n", timestamp, mensagem);
		erro.printStackTrace(System.out); // Imprime a stack trace no console
	}
}
