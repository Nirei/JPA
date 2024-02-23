package tutorialjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tutorialjpa.model.Categoria;
import tutorialjpa.repository.CategoriaRepository;

@SpringBootApplication
public class TutorialJpaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TutorialJpaApplication.class, args);
	}

	public void guardar() {
		Categoria cat = new Categoria("Informática", "Donde la gente no coge moreno");
		repository.save(cat);
	};

	private void buscarPorId() {
		Optional<Categoria> optional = repository.findById(1);
		if (optional.isPresent()) {
			System.out.println(optional.get());
		} else {
			System.out.println("Categoría no encontrada para el id aportado.");
		}
	}

	private void actualizar() {
		Optional<Categoria> optional = repository.findById(1);
		if (optional.isPresent()) {
			Categoria catTemporal = optional.get();
			System.out.println("Objeto recuperado de la tabla " + catTemporal);
			catTemporal.setNombre("Mecánica del automóvil");
			catTemporal.setDescripcion("Trabajos relacionados con los bugas");
			System.out.println("Objeto actualizado para ser guardado " + catTemporal);
			repository.save(catTemporal);
		} else {
			System.out.println("Categoría no encontrada para el id aportado");
		}
	}

	private void eliminarPorId() {
		repository.deleteById(1);
	}

	private void contarElementos() {
		long cuenta = repository.count();
		System.out.println("El número de elementos es " + cuenta);
	}

	private void eliminarTodos() {
		repository.deleteAll();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("TODO LO QUE SE ESCRIBA AQUÍ LO IMPRIMO");
		actualizar();
	}

}
