using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RocketMovement : MonoBehaviour
{
    [SerializeField] private Rigidbody rocketRigidBody;
    void Start()
    {
        //Finds a component of this type on the current object
        this.rocketRigidBody = this.GetComponent<Rigidbody>();
    }

    void Update()
    {
        ProcessInput();
        
    }

    private void ProcessInput()
    {
        //Handle the inputs
        if (Input.GetKeyDown(KeyCode.Space))
        {
            this.rocketRigidBody.AddRelativeForce(Vector3.up);
        }else if(Input.GetKeyDown(KeyCode.A)){
            this.transform.Rotate(Vector3.forward);
        }else if (Input.GetKeyDown(KeyCode.D)){
            this.transform.Rotate(-Vector3.forward) ;
        }
    }
}
