using UnityEngine;
//Requiere el Motor para servir
[RequireComponent(typeof(playerMotor))]

public class playerMovement : MonoBehaviour{
    //Se Hace SerializedFiled para que este en el inspector pero que siga pudiendo ser privada.
    [SerializeField]
    private float speed = 50f;
    [SerializeField]
    private float lookSensitivity = 3f;

    [SerializeField]
    private float thrusterForce = 1000f;

    private playerMotor motor;


    private void Start()
    {
        //Indica que el  motor para el Player sera el componente motor.
        motor = GetComponent<playerMotor>();
    }

    private void Update()
    {
        //Calcular el movimiento del Jugador con un vector 3D
        //Se pide GetAxisRaw, para que no se haga preprocesamiento
        float _xMovement = Input.GetAxisRaw("Horizontal");
        float _zMovement = Input.GetAxisRaw("Vertical");
        //Se movera a la derecha tomando en cuenta su previa posicion, la cantidad de movimiento dicha.
        //Tambien logra tomar valores negativos en los ejes
        Vector3 moveHorizontal = transform.right * _xMovement;
        Vector3 moveVertical = transform.forward * _zMovement;
        
        /*Se hace normalized para hacerlo = 1 y que no tenga una velocidad ridicula y solo indicara una direccion
         Y luego se multiplica por nuestra velocidad declarada al inicio */
        Vector3 _velocity = (moveHorizontal + moveVertical).normalized * speed;

        //Aplicar el movimiento
        motor.Move(_velocity);

        //Calcular la rotacion como Vector 3D (Volteando alrededor)
        float _yRota = Input.GetAxisRaw("Mouse X");

        Vector3 _rotation = new Vector3(0f, _yRota, 0f) * lookSensitivity;

        //Aplicar la rotacion
        motor.Rotate(_rotation);

       
        //Calcular la rotacion de la camara como Vector 3D (Volteando alrededor)
        float _xRota = Input.GetAxisRaw("Mouse Y");

        float _cameraRotationX = _xRota * lookSensitivity;
        //Aplicar la rotacion
        motor.RotateCamera(_cameraRotationX);

        //La fuerza sera 0 si no hay nada
        Vector3 _thrusterForce = Vector3.zero;
        
        //Calcular la fuerza
        if (Input.GetButton("Jump"))
        {
            //Se hara un vector hacia arriba multiplicado por la fuerza de salto
            _thrusterForce = Vector3.up * thrusterForce;
        }
        //Aplicar el salto 
        motor.ApplyThruster(_thrusterForce);
    }

}
