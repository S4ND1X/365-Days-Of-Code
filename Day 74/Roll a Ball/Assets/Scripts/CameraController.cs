using System.Collections;
using System.Collections.Generic;
using UnityEngine;
public class CameraController : MonoBehaviour
{
    [SerializeField]
    private GameObject player;
    //Diferencia del jugador a la camara
    private Vector3 offset;    
    private void Start()
    {
        //Es igual al transform actual - el transform del jugador
        offset = transform.position - player.transform.position;
    }    
    private void Update()
    {
        transform.position = player.transform.position + offset;
    }
}
