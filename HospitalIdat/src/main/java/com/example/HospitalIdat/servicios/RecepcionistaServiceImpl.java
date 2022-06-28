package com.example.HospitalIdat.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalIdat.dto.RecepcionistaDTOResponse;
import com.example.HospitalIdat.dto.RecepcionistaDTORequest;
import com.example.HospitalIdat.model.Recepcionista;
import com.example.HospitalIdat.repository.RecepcionistaRepository;

@Service
public class RecepcionistaServiceImpl implements RecepcionistaService {

	@Autowired
	private RecepcionistaRepository repository;

	@Override
	public void guardarRecepcionista(RecepcionistaDTORequest Recepcionista) {
		
		Recepcionista p = new Recepcionista();
		p.setNombre(Recepcionista.getNombre());
		p.setCelular(p.getCelular());
		
		repository.save(p);
	}

	@Override
	public void actualizarRecepcionista(RecepcionistaDTORequest Recepcionista) {
		// TODO Auto-generated method stub
		
		Recepcionista p = new Recepcionista();
		p.setIdRecepcionista(Recepcionista.getId());
		p.setNombre(Recepcionista.getNombre());
		p.setCelular(p.getCelular());

		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarRecepcionista(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<RecepcionistaDTOResponse> listarRecepcionista() {
		
		List<RecepcionistaDTOResponse> listar = new ArrayList<>();
		
		RecepcionistaDTOResponse dto = null;
		
		List<Recepcionista> p = repository.findAll();
		
		for (Recepcionista Recepcionista : p) {
			
			dto = new RecepcionistaDTOResponse();
			
			
			dto.setNombre(Recepcionista.getNombre());
			dto.setCelular(Recepcionista.getCelular());
			
			
			listar.add(dto);
		}
		
		return listar;
	}
			
		
	@Override
	public RecepcionistaDTOResponse obtenerRecepcionistaId(Integer id) {
		// TODO Auto-generated method stub
		
		Recepcionista Recepcionista = repository.findById(id).orElse(null);
		RecepcionistaDTOResponse dto = new RecepcionistaDTOResponse();
		
		
		dto.setNombre(Recepcionista.getNombre());
		dto.setCelular(Recepcionista.getCelular());
	
		
		return dto;
	}


}
