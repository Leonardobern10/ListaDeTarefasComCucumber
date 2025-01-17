package com.example.DesafioComNovasTechs;

import com.example.DesafioComNovasTechs.model.ListaTarefa;
import com.example.DesafioComNovasTechs.model.StatusTarefa;
import com.example.DesafioComNovasTechs.model.Tarefa;
import com.example.DesafioComNovasTechs.service.ListaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioComNovasTechsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioComNovasTechsApplication.class, args);
		ListaService service = new ListaService();
		service.adicionarTarefa("titulo", "Estudar", StatusTarefa.EM_ANDAMENTO);
		System.out.println(service.toString());
		service.changeStatusTarefa(StatusTarefa.CONCLUIDO, 1);
		System.out.println(service.toString());
	}

}
