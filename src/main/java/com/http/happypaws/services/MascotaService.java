package com.http.happypaws.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.http.happypaws.models.Mascotas;
import com.http.happypaws.repositories.IMascotasRepository;

@Service
public class MascotaService {
	private IMascotasRepository iMascotasRepository;

	@Autowired
	public MascotaService(IMascotasRepository iMascotasRepository) {
		this.iMascotasRepository = iMascotasRepository;
	}
	
	//Crear protectora
	public void crearMascota(Mascotas mascotas) {
		iMascotasRepository.save(mascotas);
	}
	
	//Obtener protectoras
	public List<Mascotas> obtenerMascotas(){
		return iMascotasRepository.findAll();	
	}
	
	//Obtener protectora por ID
	public Optional<Mascotas> obtenerMascotasById(Long id){
		return iMascotasRepository.findById(id);
	}
	
	//Se actualizan los datos de una protectora
	public void updateMascotas(Mascotas mascotas) {
		iMascotasRepository.save(mascotas);
	}
	
	//Se elimina protectora por ID
	public void deleteMascotas(Long id) {
		iMascotasRepository.deleteById(id);
	}
	
	
}
