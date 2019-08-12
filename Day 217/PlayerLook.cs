using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerLook : MonoBehaviour
{
    //Config param
    [SerializeField]private string mouseXInputName, mouseYInputName;
    [SerializeField] private float mouseSensitivity;
    [SerializeField] private Transform playerBody;

    //Restriccion en x
    private float xAxisClamp;

    private void Awake()
    {
        LockCursor();
        xAxisClamp = 0.0f;
    }


    private void LockCursor()
    {
        //bloquea el cursor al centro de la pantalla
        Cursor.lockState = CursorLockMode.Locked;
    }


    private void Update()
    {
        CamerRotation();
    }

    private void CamerRotation()
    {
        //Obtiene la posicion del mouse
        float mouseX = Input.GetAxisRaw(mouseXInputName) * mouseSensitivity * Time.deltaTime;
        float mouseY = Input.GetAxisRaw(mouseYInputName) * mouseSensitivity * Time.deltaTime;

        xAxisClamp += mouseY;

        //Si esta viendo completamente hacia arriba
        if (xAxisClamp >= 90.0f)
        {
            xAxisClamp = 90.0f;
            mouseY = 0.0f;
            ClampXAxisToValue(270.0f);
        }
        //Si esta viendo completamente hacia abajo
        else if (xAxisClamp <= -90.0f)
        {
            xAxisClamp = -90.0f;
            mouseY = 0.0f;
            ClampXAxisToValue(90.0f);
        }
        //Se mueve la rotacion del eje segun el mouse
        transform.Rotate(Vector3.left * mouseY);
        playerBody.Rotate(Vector3.up * mouseX);

    }

    //Funcion para restringir movimiento en Y
    private void ClampXAxisToValue(float value)
    {
        //Se restringe el movimiento a cierto valor con los angulos de euler
        Vector3 eulerRotation = transform.eulerAngles;
        eulerRotation.x = value;
        transform.eulerAngles = eulerRotation;
    }
}
