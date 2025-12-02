package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodios;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConveterDados;
import br.com.alura.screenmatch.service.CosumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);


	}

    @Override
    public void run(String... args) throws Exception {

        CosumoApi cosumoApi = new CosumoApi();
        var json = cosumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=41394108");
        System.out.println(json);
        ConveterDados conveterDados = new ConveterDados();
        DadosSerie dadosSerie = conveterDados.obterDadosJson(json, DadosSerie.class);
        System.out.println(dadosSerie);
         json = cosumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=41394108");
        System.out.println(json);
        DadosEpisodios dadosEpisodios = conveterDados.obterDadosJson(json, DadosEpisodios.class);
        System.out.println(dadosEpisodios);
    }
}
