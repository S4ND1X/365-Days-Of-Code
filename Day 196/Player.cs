using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    [SerializeField] private float moveSpeed = 10f;
    private float minX, maxX, minY, maxY, padding = 0.8f;
    // Start is called before the first frame update
    void Start()
    {
        SetUpMoveBoundaries();
    }

    // Update is called once per frame
    void Update()
    {
        MoveX();

    }
    private void MoveX()
    {
        //Se usa var porque automaticamente sabe que tipo de dato es
        //Se multiplica por Delta time para frames parejos y con la velocidad
        //Se le suma la posicion a la que se dirije + en la que esta
        var deltaX = Input.GetAxis("Horizontal") * Time.deltaTime * moveSpeed;
        var deltaY = Input.GetAxis("Vertical") * Time.deltaTime * moveSpeed;
        var newXPos = Mathf.Clamp(transform.position.x + deltaX, minX, maxX);
        var newYPos = Mathf.Clamp(transform.position.y + deltaY, minY, maxY);
        transform.position = new Vector2(newXPos, newYPos);
    }

    private void SetUpMoveBoundaries()
    {
        Camera gameCamera = Camera.main;
        //Se da el minimo que se puede mover en el eje de las x relativo a la camara
        minX = gameCamera.ViewportToWorldPoint(new Vector3(0, 0, 0)).x + padding;
        maxX= gameCamera.ViewportToWorldPoint(new Vector3(1, 0, 0)).x - padding;

        //Se usa para tener la coordenadas en Y en las que es el minimo y maximo
        minY = gameCamera.ViewportToWorldPoint(new Vector3(0, 0, 0)).y + padding;
        maxY = gameCamera.ViewportToWorldPoint(new Vector3(0, 0.5f, 0)).y;
    }
}
