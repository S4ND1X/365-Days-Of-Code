using UnityEngine;
//Se necesita el rigid body
[RequireComponent(typeof(Rigidbody))]

public class playerMotor : MonoBehaviour{

    [SerializeField]
    private Camera cam;
        
    private Vector3 velocity = Vector3.zero;
    private Vector3 rotation = Vector3.zero;
    private Vector3 cameraRotation = Vector3.zero;



    private Rigidbody rigBod;

    private void Start()

    {
        //Indicando que necesita un RigidBody para funcionar
        rigBod = GetComponent<Rigidbody>();
    }


    //Obtiene un vector de movimiento
    public void Move (Vector3 _velocity)
    {
        velocity = _velocity;
    }
    //Obtiene un vector de rotacion
    public void Rotate(Vector3 _rotation)
    {
        rotation = _rotation;
    }
    //Obtiene un vector de rotacion de la camara
    public void RotateCamera(Vector3 _cameraRotation)
    {
        cameraRotation = _cameraRotation;
    }

    //Hace las fisicas cada cierto tiempo
    private void FixedUpdate()
    {
        PerfomMovement();
        PerformRotation();
    }

    //Movimiento segun la velocidad
    void PerfomMovement()
    {
        if(velocity != Vector3.zero)
        {
            //Hara que se mueva en la posicion + la velocidad
            rigBod.MovePosition(rigBod.position + velocity * Time.fixedDeltaTime);
        }
    }
    //Rotacion segun la velocidad.
    void PerformRotation ()
    {
        //Quaternion se usa para rotacion ya procesada por Unity
        rigBod.MoveRotation(rigBod.rotation * Quaternion.Euler (rotation));
        if(cam != null)
        {
            cam.transform.Rotate(-cameraRotation);           
            
        }
    }

}
