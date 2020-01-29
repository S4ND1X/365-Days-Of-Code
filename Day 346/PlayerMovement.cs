using System.Collections;
using System.Collections.Generic;
using UnityEngine;//Usando el sistema de Input para multiplataforma del StandardAssets
using UnityStandardAssets.CrossPlatformInput;

public class PlayerMovement : MonoBehaviour
{
    //Config param
    [SerializeField] private float runSpeed = 5f;
    [SerializeField] private float jumpSpeed = 5f;
    [SerializeField] private float climbingSpeed = 2.5f;

    //State
    private bool isAlive = true;
    private bool isJumping = false;
    private bool hasHorizontalSpeed = false;
    private bool isGrounded = true;
    private bool isTouchingLadder = false;

    //Cached component references
    private Rigidbody2D myRigidBody;
    private Animator myAnimator;
    private Collider2D myCollider2D;
    private float originalGravityScale;
    

    void Start(){
        //Buscar componentesiniciar
        this.myRigidBody = GetComponent<Rigidbody2D>();
        this.myAnimator = GetComponent<Animator>();
        this.myCollider2D = GetComponent<Collider2D>();
        this.originalGravityScale = this.myRigidBody.gravityScale;
    }
    void Update(){
        
        CalculateHorizontalSpeed();
        IsTouchingSomething();
        ChangePhysicsIfTouching();
        ClimbLadder();
        Run();
        Jump();        
        ChangeSprite();
    }

    
    private void Run(){
        if (this.isTouchingLadder && !this.isGrounded) { return; }
        //Se obtiene el eje a traves de crossPlatform para facilitar el uso en otros dispositivos
        float controlThrow = CrossPlatformInputManager.GetAxis("Horizontal"); // valores entre -1, +1
        //Hacer los valores Frame Independent
        float horizontalVelocity = controlThrow * runSpeed;
        //Se iguala la velocidad a que tanto se este yendo en el eje X, junto con la velocidad actual en y
        Vector2 playerVelocity = new Vector2(horizontalVelocity, this.myRigidBody.velocity.y);
        this.myRigidBody.velocity = playerVelocity;
    }//Metodo para que el jugador corra

    private void Jump(){
        //Si no esta en el suelo, no puede saltar
        if (!this.isGrounded) { return; }
        //Si esta se pide el imput de salto y se agrega esa fuerza a la velocidad
        this.isJumping = CrossPlatformInputManager.GetButtonDown("Jump");
        if (this.isJumping)
        {
            Vector2 jumpVelocity = new Vector2(0f,this.jumpSpeed);
            this.myRigidBody.velocity += jumpVelocity;
            
        }
    }//Metodo para que el jugador salte

    private void ChangeSprite(){
        if (this.hasHorizontalSpeed){
            //Se asigna el signo ya sea -1 o +1 a la escala para rotar
            transform.localScale = new Vector2(Mathf.Sign(this.myRigidBody.velocity.x), 1f);
        }
        if (this.isJumping || !this.isGrounded && !this.isTouchingLadder){
            this.myAnimator.SetBool("Jumping", true);
        }
        else
        {
            this.myAnimator.SetBool("Jumping",false);
        }
        if (this.isTouchingLadder && !this.isGrounded)
        {
            this.myAnimator.SetBool("Climb",true);
        }
        else
        {
            this.myAnimator.SetBool("Climb", false);
        }
        //Se usa abs para que te devuelva el valor ya sea positivo o negativo
        this.myAnimator.SetBool("Running", this.hasHorizontalSpeed);
    }//Metodo para que el sprite cambie segun la accion
    private void CalculateHorizontalSpeed(){
        //Si el jugador se mueve horizonalmente
        this.hasHorizontalSpeed = Mathf.Abs(myRigidBody.velocity.x) > Mathf.Epsilon;
    }//Calcular la velocidad horizontal

    private void IsTouchingSomething(){
        //Detectar si esta tocando la capa donde esta el piso
        this.isGrounded = this.myCollider2D.IsTouchingLayers(LayerMask.GetMask("Ground"));
        //Si esta tocando las escaleras
        this.isTouchingLadder = this.myCollider2D.IsTouchingLayers(LayerMask.GetMask("Ladder"));
    }//Metodo para detectar si esta tocando algun objeto

    private void ClimbLadder()
    {   
        //Si no esta tocando se regresa
        if (!this.isTouchingLadder) { return; }
        //Si esta tocando, se espera a que el usuario quiera subir, y se sube con la velocidad que el quiera
        float controlThrow = CrossPlatformInputManager.GetAxis("Vertical");
        Vector2 climbVelocity = new Vector2(0f, controlThrow*this.climbingSpeed);
        this.myRigidBody.velocity = climbVelocity;
    }//Metodo para las fisicas de subir escaleras

    private void ChangePhysicsIfTouching()
    {
        if (this.isTouchingLadder)
        {
            this.myRigidBody.gravityScale = 0f;
        }
        else
        {
            this.myRigidBody.gravityScale = this.originalGravityScale;
        }
    }//Metodo para cambiar fisicas en contacto, con los objetos
}
