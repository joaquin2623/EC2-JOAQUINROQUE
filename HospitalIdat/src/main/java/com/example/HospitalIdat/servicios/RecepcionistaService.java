package com.example.HospitalIdat.servicios;

import java.util.List;

import com.example.HospitalIdat.dto.*;

public interface RecepcionistaService {
	
	void guardarRecepcionista(RecepcionistaDTORequest Recepcionistao);
	void actualizarRecepcionista(RecepcionistaDTORequest Recepcionista);
	void eliminarRecepcionista(Integer id);
	List<RecepcionistaDTOResponse> listarRecepcionista();
	RecepcionistaDTOResponse obtenerRecepcionistaId(Integer id);

}
