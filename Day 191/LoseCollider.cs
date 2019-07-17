using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class LoseCollider : MonoBehaviour {

    //Evento para un trigger Collider que recibe el collider
    //Esto se activa cuando algo pasa a través del objeto que tenga este script
    private void OnTriggerEnter2D(Collider2D collision){
            SceneManager.LoadScene("Game Over", LoadSceneMode.Single);
    }

}
