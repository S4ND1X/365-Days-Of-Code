using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class GameSession : MonoBehaviour
{
    //Config param
    [Range(0.1f, 10f)] [SerializeField] private float gameSpeed = 1f;
    [SerializeField] int pointsPerBlock = 20;
    [SerializeField] bool isAutoPlayEnabled = false;
    //Varaible de tipo Text mesh
    [SerializeField] TextMeshProUGUI scoreText;
    //State variables
    [SerializeField] int currentScore = 0;

    private void Awake()
    {
        //No se destruye el objeto cuando se cargan las escenas
        int gameStatusCount = FindObjectsOfType<GameSession>().Length;
        if (gameStatusCount > 1)
        {
            gameObject.SetActive(false);
            Destroy(gameObject);
        }
        else DontDestroyOnLoad(gameObject);
    }

    private void Start()
    {
        //Acceder al texto y poner el score
        scoreText.text = currentScore.ToString();

    }
    void Update()
    {
        Time.timeScale = gameSpeed;
    }

    public void addPoints()
    {
        //Actualizar los valores
        currentScore += pointsPerBlock;
        scoreText.text = currentScore.ToString();
    }

    public void restartScore()
    {
        currentScore = 0;
    }

    public bool IsAutoPlayEnabled()
    {
        return isAutoPlayEnabled;
    }
}
