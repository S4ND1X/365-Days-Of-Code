using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMove : MonoBehaviour
{
    //Config param *Movimiento*
    [SerializeField] private string horizontalInputName;
    [SerializeField] private string verticalInputName;
    private float movementSpeed;

    [SerializeField] private float walkSpeed, runSpeed;
    [SerializeField] private float runBuildUp;
    [SerializeField] private KeyCode runKey;

    [SerializeField] private float slopeForce;
    [SerializeField] private float slopeForceLength;
    //Referencia en cache
    private CharacterController charController;

    //Config param *Salto*
    //Esta se usa para aplicar menos fuerza ente más tiempo estemps en el aire
    [SerializeField] private AnimationCurve jumpFallOff;
    [SerializeField] private float jumpMultiplier;
    [SerializeField] private KeyCode jumpKey;

    private bool isJumping;

    private void Awake()
    {
        //Obtener el componente
        charController = GetComponent<CharacterController>();
    }

    private void Update()
    {
        PlayerMovement();
    }

    private void PlayerMovement()
    {
        //No se multiplica por Time.deltaTime porque simpleMove ya lo hace
        float vertInput = Input.GetAxis(verticalInputName);
        float horiInput = Input.GetAxis(horizontalInputName);

        //Se crean los vectores de movimiento
        Vector3 forwardMovement = transform.forward * vertInput;
        Vector3 rightMovement = transform.right * horiInput;

        /* El metodo junta los dos vectores para regresar la velocidad de movimiento
         * Y a su vez la restringe para que la velocidad combinada es decir la diagonal
         * no exceda el limite, para eso el ClampMagnitud, es como clamp para vectores
         */
        charController.SimpleMove(  Vector3.ClampMagnitude
                                    (forwardMovement + rightMovement, 1.0f) * movementSpeed);

        //Si esta movimiendo y esta en una rampa
        if ((vertInput != 0 || horiInput != 0) && OnSlope())
            charController.Move(Vector3.down * charController.height / 2 * slopeForce * Time.deltaTime);

        SetMovementSpeed();
        JumpInput();

    }

    private void SetMovementSpeed()
    {
        if (Input.GetKey(runKey))
        {
            movementSpeed = Mathf.Lerp(movementSpeed, runSpeed, Time.deltaTime * runBuildUp);
        }
        else
        {
            movementSpeed = Mathf.Lerp(movementSpeed, walkSpeed, Time.deltaTime * runBuildUp);

        }
    }


    //Funcion para saber si esta en una inclinacion
    private bool OnSlope()
    {
        if (isJumping) return false;

        //Guarda la informacion en donde fue golpeado
        RaycastHit hit;

        if(Physics.Raycast( transform.position,
                            Vector3.down, out hit, charController.height / 2 * slopeForceLength))
        {
            if(hit.normal != Vector3.up)
            {
                return true;
            }
        }
        return false;
    }


    private void JumpInput()
    {
        //Obtener input y ejecutar si no esta saltando y presiono la tecla
        if(Input.GetKeyDown(jumpKey) && !isJumping)
        {
            isJumping = true;
            StartCoroutine(JumpEvent());
        }
    }

    private IEnumerator JumpEvent()
    {
        charController.slopeLimit = 90.0f;
        float timeInAir = 0.0f;
        do{
            /*La fuerza dada al salto sera menos entre más tiempo este en el aire,
             * para esto checar la grafica en el inspector
             */
            float jumpForce = jumpFallOff.Evaluate(timeInAir);
            //Move no es frame independent por si solo
            charController.Move(Vector3.up * jumpForce * jumpMultiplier * Time.deltaTime);
            //Agregar tiempo en el aire
            timeInAir += Time.deltaTime;
            yield return null;
            /*Esto se hace para que mientras el jugador no este en el piso y además
             * para que si choca por arriba es decir con el "techo" deje de moverse hacia arriba
             */
        } while (!charController.isGrounded && charController.collisionFlags != CollisionFlags.Above);

        charController.slopeLimit = 45.0f;
        isJumping = false;

    }
}
