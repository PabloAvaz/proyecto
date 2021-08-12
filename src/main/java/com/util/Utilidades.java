package com.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

public class Utilidades { 
	
	public static String guardarArchivo(MultipartFile archivo, String ruta) {
		//Obtenemos el nombre del archivo
		String nombreFinal = fechaActualConPattern("dd_MM_yyyy_hh_mm_ss_") + archivo.getOriginalFilename().replace(" ", "_"); 
		try {
			File imageFile = new File(ruta + nombreFinal); //Formamos el nombre del archivo para guardarlo en el diso duro
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			archivo.transferTo(imageFile); 	//Guardamos fisicamente el archivo en el disco
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		} 
		
	}
	public static String fechaActualConPattern(String pattern) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}
}
