using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour{
    [SerializeField] private CharacterController controller;
    [SerializeField] private float speed = 12f;

    [SerializeField] private float gravity = -9.81f;

    [SerializeField] private Transform groundCheck;
    [SerializeField] private float groundDistance = 0.4f;

    [SerializeField] private float jumpHeight = 3f;

    [SerializeField] LayerMask groundMask;

    private bool isGrounded;

    private Vector3 velocityVector;

    void Update()
    {
        //Creates an invisible sphere, and if collides with the mask, return true
        this.isGrounded = Physics.CheckSphere(this.groundCheck.position, 
                                                this.groundDistance, 
                                                this.groundMask);

        if(this.isGrounded && this.velocityVector.y < 0) { this.velocityVector.y = -2f; }

        float x = Input.GetAxis("Horizontal");
        float z = Input.GetAxis("Vertical");

        Vector3 move = transform.right * x + transform.forward * z;


        this.controller.Move(move * speed * Time.deltaTime);

        if (Input.GetButtonDown("Jump") && this.isGrounded)
        {
            this.velocityVector.y = Mathf.Sqrt(this.jumpHeight * -2f * this.gravity);
        }

        this.velocityVector.y += this.gravity * Time.deltaTime;

        this.controller.Move(this.velocityVector);

    }
}
