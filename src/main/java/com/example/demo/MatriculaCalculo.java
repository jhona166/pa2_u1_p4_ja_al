package com.example.demo;

public class MatriculaCalculo {
		public void realizarMatricula(String tipo) {

			if(tipo.equals("1")) {
				Materia mat = new Materia();
				mat.setNombre("P. web");
				//Insertar en la base
				System.out.println("Se inserto Materia");
			}else {
				MateriaExtraordinaria matX = new MateriaExtraordinaria();
				matX.setCantidadCreditos(10);
				System.out.println("Se inserto materia Extraordinaria");

			}
		}
}
