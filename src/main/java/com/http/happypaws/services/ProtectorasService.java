package com.http.happypaws.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.http.happypaws.models.Protectoras;
import com.http.happypaws.repositories.IProtectorasRepository;

@Service
public class ProtectorasService {
	private IProtectorasRepository iProtectorasRepository;

	@Autowired
	public ProtectorasService(IProtectorasRepository iProtectorasRepository) {
		this.iProtectorasRepository = iProtectorasRepository;
	}
	
	//Crear protectora
	public void crearProtectora(Protectoras protectora) {
		iProtectorasRepository.save(protectora);
	}
	
	//Obtener protectoras
	public List<Protectoras> obtenerProtectoras(){
		return iProtectorasRepository.findAll();	
	}
	
	//Obtener protectora por ID
	public Optional<Protectoras> obtenerProtectoraById(Long id){
		return iProtectorasRepository.findById(id);
	}
	
	//Se actualizan los datos de una protectora
	public void updateProtectora(Protectoras protectora) {
		iProtectorasRepository.save(protectora);
	}
	
	//Se elimina protectora por ID
	public void deleteProtectora(Long id) {
		iProtectorasRepository.deleteById(id);
	}
	
	
}
