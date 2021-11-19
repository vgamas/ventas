package java.com.mintic.lagenerica.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.lagenerica.model.ventas;
import com.mintic.lagenerica.repository.ventasRepository;

@CrossOrigin(origins = "http://localhost:8181")
@RestController
@RequestMapping("/ventas")
public class ventasController {

	@Autowired
	private ventasRepository ventasRepository;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> crearventa(@RequestBody ventas ventas){
		return ResponseEntity.status(HttpStatus.CREATED).body(ventasRepository.save(ventas));
	}
	
	@GetMapping("/listar")
	public List<ventas> listarventas() {
		List<ventas> listaVentas = StreamSupport.stream(ventasRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listarventas();
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> bucarventasEntity(@PathVariable(value = "id") Long id) {

		Optional<ventas> oventas = ventasRepository.findById(id) ;
		
		if (oventas.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oventas);
	}

	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> borrarTodos() {

		ventas oventas = new ventas();
		
		ventasRepository.deleteAll();;
		
		return ResponseEntity.ok(oventas);
	}


	@PutMapping("actualizar")
	public ResponseEntity<?> actualizarventas(@RequestBody ventas ventas) {

		Optional<ventas> ventasAnt = ventasRepository.findById(ventas.getcedula_cliente());
		
		if(ventasAnt.isEmpty())
			return ResponseEntity.notFound().build();
		
		ventasAnt.get().setcodigo_producto(ventas.getcodigo_producto());
		ventasAnt.get().setcedula_cliente(ventas.getcedula_cliente());
		ventasAnt.get().setcodigo_venta(ventas.getcodigo_venta());
		ventasAnt.get().setdetalles_venta(ventas.getdetalles_venta());
		ventasAnt.get().setcantidad_productos(ventas.getcantidad_productos());
		ventasAnt.get().setcantidad_productos(ventas.getcantidad_productos());
		ventasAnt.get().setcodigo_producto(ventas.getcodigo_producto());
		ventasAnt.get().setvalor_total(ventas.getvalor_total());
		ventasAnt.get().setvalor_venta(ventas.getvalor_venta());
		ventasAnt.get().setvaloriva(ventas.getvaloriva());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ventasRepository.save(ventasAnt.get()));	
	}
}
