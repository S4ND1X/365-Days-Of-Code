using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour{

    //Config params
    [SerializeField] private Paddle paddle1;

    //State
    private Vector2 paddleToBallVector;

    //The user has launch the ball?
    private bool hasClicked = false;

    //Velocity of the ball
    [SerializeField]private float velX = 0f, velY = 10f;

    // Start is called before the first frame update
    void Start(){
        //Diferencia entre la pelota y el paddle
        this.paddleToBallVector = transform.position - this.paddle1.transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        if (!hasClicked)
        {
            LockBallToPaddel();
            LaunchOnClick();
        }
    }

    private void LockBallToPaddel()
    {
        Vector2 paddlePos = new Vector2(this.paddle1.transform.position.x, this.paddle1.transform.position.y);
        transform.position = paddlePos + this.paddleToBallVector;
    }

    private void LaunchOnClick()
    {
        if (Input.GetMouseButtonDown(0))
        {
            //Obtiene el componente Rigid Body y la velocidad se da como un vector
            GetComponent<Rigidbody2D>().velocity = new Vector2(velX, velY);
            hasClicked = true;
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (hasClicked) {
        //Get Component es para obtener un componente en el objeto y acceder a los elementos.
        GetComponent<AudioSource>().Play();
        }
    }
}
