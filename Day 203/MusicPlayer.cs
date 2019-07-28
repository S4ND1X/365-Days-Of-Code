using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MusicPlayer : MonoBehaviour
{
    /*Singleton es un patron de diseño hecho para tener una sola instancia sin tener que crear
    * más de un objeto
    */

    private void Awake()
    {
        SetUpSingleton();
    }

    private void SetUpSingleton()
    {
        //Gettype sirve para obtener el tipo de esta clase
        if(FindObjectsOfType(GetType()).Length > 1)Destroy(gameObject);
        else DontDestroyOnLoad(gameObject);
        
    }
}
