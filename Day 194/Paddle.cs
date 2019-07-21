using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Paddle : MonoBehaviour
{
    [SerializeField] private float cameraWidthUnits = 16f;
    [SerializeField] private float minX = 1f;
    [SerializeField] private float maxX = 15f;


    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        //Obteniendo posicion en x del mouse
        //Se divide la posicion entre el ancho de la pantalla de juego para tener valores entre 0 y 1
        float mxPosUnits = Input.mousePosition.x / Screen.width * cameraWidthUnits;
        //Se crea el vector de posicion con los valores del inspector
        Vector2 paddlePos = new Vector2(transform.position.x, transform.position.y);
        //Se restringe la posicion en x
        paddlePos.x = Mathf.Clamp(mxPosUnits, minX, maxX);
        //Se asgina la posicion
        transform.position = paddlePos;
    }
}
