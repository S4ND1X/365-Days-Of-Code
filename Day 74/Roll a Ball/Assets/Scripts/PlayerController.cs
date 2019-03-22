using System.Collections;
using System.Collections.Generic;
using UnityEngine;
public class PlayerController : MonoBehaviour
{
    //Se crea la variable del tipo componente que necesites referenciar
    private Rigidbody rb;
    [SerializeField]
    private float movementSpeed = 0f;
    private void Start()
    {
        //Aqui se iguala la variable a su componente.
        rb = GetComponent<Rigidbody>();        
    }    
    private void FixedUpdate()
    {
        //Obtener el Input de movimiento
        float moveHorizontal = Input.GetAxis("Horizontal");
        float moveVertical = Input.GetAxis("Vertical");
        //Crear el vector de movimiento,(X,Y,Z)
        Vector3 movement = new Vector3(moveHorizontal, 0, moveVertical);
        //AddForce recibe un vector y un modode fuerza
        rb.AddForce(movement*movementSpeed);
    }
}
