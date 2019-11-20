import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	//Lista ligada que almacena todos los objetos
	LinkedList <GameObject> gameObjects = new LinkedList<GameObject>();

	//Metodo para llamar al tick de todos los objetos
	public void tick() {
		//Tick todos los objetos
		for(GameObject tempGO : gameObjects) {
			tempGO.tick();
		}
	}

	//Metodo para hacer render de todos los objetos
	public void render(Graphics g) {
		//Renderizar todos los objetos
		for(GameObject tempGO : gameObjects) {
			tempGO.render(g);
		}
	}
	//Metodo para agregar un objeto al juego
	public void addGameObject(GameObject gameObject) {
		this.gameObjects.add(gameObject);
	}
	//Metodo para remover un objeto al juego
	public void removeGameObject(GameObject gameObject) {
		this.gameObjects.remove(gameObject);
	}
}
