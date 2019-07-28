using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ScoreDisplay : MonoBehaviour
{

    private Text scoreText;
    private GameSession gameSession;


    // Start is called before the first frame update
    void Start()
    {
        //Obtener los componentes
        scoreText = GetComponent<Text>();
        gameSession = FindObjectOfType<GameSession>();
        scoreText.text = gameSession.GetScore().ToString();
    }

    // Update is called once per frame
    void Update()
    {
        //Convertir el puntaje en el texto del canvas
        scoreText.text = gameSession.GetScore().ToString();
    }
}
