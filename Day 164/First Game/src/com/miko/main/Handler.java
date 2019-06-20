package com.miko.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	//Crear Lista Ligada
	LinkedList <GameObject> object = new LinkedList<GameObject>();
	
	/*Actualiza y renderiza todos los objetos que haya en escena */
	
	public void tick() {
		//Obtiene cada elemento en pantalla
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			//Actualiza ese objeto
			tempObject.tick();
		}
	}
	
	
	public void render(Graphics g) {
		//Obtiene cada elemento en pantalla
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			//Hace su nuevo render
			tempObject.render(g);
		}
	}
	//Agregar objeto
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	//Quitar Elemento
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
