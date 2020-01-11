using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameSession : MonoBehaviour
{

    [SerializeField] private int score = 0;

    private void Awake()
    {
        SetUpSingleton();
    }

    private void SetUpSingleton()
    {
        /*Si hay más de un objeto se destruye para que solo uno lleve el control
         * el otro no se destruye en el cambio de escena
         */
        if (FindObjectsOfType(GetType()).Length > 1) Destroy(gameObject);
        else DontDestroyOnLoad(gameObject);
        

    }

    public int GetScore()
    {
        return score;
    }

    public void AddToScore(int scoreValue)
    {
        this.score += scoreValue;
    }

    public void ResetGame()
    {
        Destroy(gameObject);
    }


}
