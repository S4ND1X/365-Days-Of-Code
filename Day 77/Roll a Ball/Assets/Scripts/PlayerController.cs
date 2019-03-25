using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public class PlayerController : MonoBehaviour
{
    //Se crea la variable del tipo componente que necesites referenciar
    private Rigidbody rb;
    [SerializeField]
    private float movementSpeed = 0f;
    [SerializeField]
    //Se crea para contener la referencia
    private Text countText;
    [SerializeField]
    private Text winText;
    private int count;
    private void Start()
    {
        //Aqui se iguala la variable a su componente.
        rb = GetComponent<Rigidbody>();
        count = 0;
        //A que se igualara el texto a desplegar
        winText.text = "";
        setCountText();
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

    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Pick Up"))
        {
            other.gameObject.SetActive(false);
            count++;
            countText.text = "Score: " + count.ToString();
        }
    }

    void setCountText()
    {
        countText.text = "Score: " + count.ToString();
        if(count == 8)
        {
            winText.text = "You have won";
        }
    }
}
