package spdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Libro;
import model.Tema;

public interface DaoLibros extends JpaRepository<Libro,Integer> {		
	List<Libro> findAllByTema(Tema tema);
}
