package com.deuvanio.bookstore;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deuvanio.bookstore.domain.Categoria;
import com.deuvanio.bookstore.domain.Livro;
import com.deuvanio.bookstore.repository.CategoriaRepository;
import com.deuvanio.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica","Livros de T.I");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Teste", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
