using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerStats : MonoBehaviour
{
    //Salud
    [SerializeField]
    private float Healt;
    [SerializeField]
    private float healtOverTime;

    //Hambre
    [SerializeField]
    private float Hunger;
    [SerializeField]
    private float HungerOverTime;

    //Sed
    [SerializeField]
    private float Thirst;
    [SerializeField]
    private float thirstOverTime;
    //Estamina
    [SerializeField]
    private float Stamina;
    [SerializeField]
    private float staminaOverTime;


    //Sliders
    [SerializeField]
    private Slider HealtBar;
    [SerializeField]
    private Slider HungerBar;
    [SerializeField]
    private Slider ThirstBar;
    [SerializeField]
    private Slider StaminaBar;

    [SerializeField]
    //Valor minimo antes de que empiece a afectar a la salud.
    private float minAmount = 5f;
    private float sprintSpeed = 5f;

    Rigidbody rigBod;

    private void Start()
    {
        //Obtener el componente RigidBody
        rigBod = GetComponent<Rigidbody>();
        //El valor maximo del slider sera el valor inicial, que esta en 100;
        HealtBar.maxValue = Healt;
        HungerBar.maxValue = Hunger;
        ThirstBar.maxValue = Thirst;
        StaminaBar.maxValue = Stamina;

        updateUI();


    }

 
    private void Update()
    {
        calculateValues();
    }

    private void calculateValues()
    {
        //Pierde Hambre y Sed con el tiempo
        Hunger -= HungerOverTime * Time.deltaTime;
        Thirst-= thirstOverTime * Time.deltaTime;

        //Si tiene menos del minimo, empezara a perder vida y Stamina
        if(Hunger <= minAmount || Thirst <= minAmount)
        {
            Healt -= healtOverTime * Time.deltaTime;
            Stamina -= staminaOverTime * Time.deltaTime;
        }

        //Si la velocidad en x es mayor a lo "permitido" empezara a perder stamina, salud y sed.
        if (rigBod.velocity.magnitude >= sprintSpeed && rigBod.velocity.y == 0)
        {
            //Le bajara el doble si es que corre. 
            Stamina -= staminaOverTime * Time.deltaTime;
            Hunger -= HungerOverTime * Time.deltaTime;
            Thirst -= thirstOverTime * Time.deltaTime;
        }
        else
        {
            //Si no esta corriendo, se recupera la estamina a la mitad de lo que la perdio
            Stamina += (staminaOverTime/2) * Time.deltaTime;
        }

        if(Healt <= 0)
        {
            Debug.Log("Has Muerto");
        }
        updateUI();
    }
    private void updateUI()
    {
        //Restringir los valores entre 0 y un maximo
        Healt = Mathf.Clamp(Healt, 0, 100f);
        Hunger = Mathf.Clamp(Hunger, 0, 100f);
        Thirst = Mathf.Clamp(Thirst, 0, 100f);
        Stamina = Mathf.Clamp(Stamina, 0, 100f);
        //Actualiza la barra
        HealtBar.value = Healt;
        HealtBar.value = Healt;
        HungerBar.value = Hunger;
        ThirstBar.value = Thirst;
        StaminaBar.value = Stamina;
    }
    public void takeDamage(float amount)
    {
        Healt -= amount;
        updateUI();
    }
}
