package tutorialjpa.repository;

import org.springframework.data.repository.CrudRepository;

import tutorialjpa.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

}
