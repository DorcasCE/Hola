package com.example.demo;

public class jhfg {
	@RestController @RequestMapping("api/paciente") public class PacienteController { @Autowired private PacienteServiceImpl pacienteServiceImpl; @GetMapping() public ResponseEntity<List<Paciente>> readAll() { try { List<Paciente> pacientes = pacienteServiceImpl.readAll(); if(pacientes.isEmpty()) { return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); } return new ResponseEntity<>(pacientes, HttpStatus.OK); } catch (Exception e) { // TODO: handle exception return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } } @PostMapping public ResponseEntity<Paciente> setPaciente(@Valid @RequestBody Paciente cat) { //TODO: process POST request try { Paciente d  = pacienteServiceImpl.create(cat); return new ResponseEntity<>(d, HttpStatus.OK); } catch (Exception e) { // TODO: handle exception return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } } @PutMapping("/{id}") public ResponseEntity<?> updatePaciente(@PathVariable("id") Long id, @Valid @RequestBody Paciente cat) { //TODO: process PUT request Optional<Paciente> d = pacienteServiceImpl.read(id); if (d.isEmpty()) { return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); }else { return new ResponseEntity<>(pacienteServiceImpl.update(cat), HttpStatus.OK); } } @GetMapping("/{id}") public ResponseEntity<Paciente> getPaciente(@PathVariable("id") Long id) { try { Paciente d = pacienteServiceImpl.read(id).get(); return new ResponseEntity<>(d, HttpStatus.OK); } catch (Exception e) { // TODO: handle exception return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); } } @DeleteMapping("/{id}") public ResponseEntity<Paciente> delPaciente(@PathVariable("id") Long id) { try { pacienteServiceImpl.delete(id); return new ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { // TODO: handle exception return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } } }
}

@RestController
@RequestMapping("api/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteServiceImpl pacienteServiceImpl;
	
	@GetMapping()
	public ResponseEntity<List<Paciente>> readAll() {
		try {
			
			List<Paciente> pacientes = pacienteServiceImpl.readAll();
			
			if(pacientes.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);			
			}
				return new ResponseEntity<>(pacientes, HttpStatus.OK);			
		
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Paciente> setPaciente(@Valid @RequestBody Paciente cat) {
		//TODO: process POST request
		try {
			Paciente d  = pacienteServiceImpl.create(cat);
			return new ResponseEntity<>(d, HttpStatus.OK);			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePaciente(@PathVariable("id") Long id, @Valid @RequestBody Paciente cat) {
		//TODO: process PUT request
		Optional<Paciente> d = pacienteServiceImpl.read(id);
		if (d.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(pacienteServiceImpl.update(cat), HttpStatus.OK);			

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> getPaciente(@PathVariable("id") Long id) {
		
		try {
			Paciente d = pacienteServiceImpl.read(id).get();
			return new ResponseEntity<>(d, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> delPaciente(@PathVariable("id") Long id) {
		
		try {
			pacienteServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}