using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MouseLook : MonoBehaviour{

    [SerializeField]private float mouseSensitivity = 100f;
    [SerializeField]private Transform playerBody;
                    private float xRotation = 0f;
    void Start(){
        //Lock mouse in center of the screen so the mouse doesn't go out of the screen
        Cursor.lockState = CursorLockMode.Locked;   
    }
    void Update(){
        //Make it frame independent 
        float mouseX = Input.GetAxis("Mouse X") * mouseSensitivity * Time.deltaTime;
        float mouseY = Input.GetAxis("Mouse Y") * mouseSensitivity * Time.deltaTime;

        this.xRotation -= mouseY;
        //clamp the the rotation on a 180°
        this.xRotation = Mathf.Clamp(this.xRotation, -90f,90f);

        //Quaternion is the one in charge of the rotations
        this.transform.localRotation = Quaternion.Euler(xRotation,0f,0f);
        //Rotate the body
        this.playerBody.Rotate(Vector3.up * mouseX);
    }
}
