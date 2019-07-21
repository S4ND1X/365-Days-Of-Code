using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LevelScript : MonoBehaviour
{
    [SerializeField]int breakableCount = 0; //Para poder verlo

    SceneLoader sceneLoader;

    private void Start()
    {
        sceneLoader = FindObjectOfType<SceneLoader>();
    }

    public void CountBlocks()
    {
        breakableCount++;
    }

    public void RemoveBreakableBlock()
    {
        breakableCount--;
        if(breakableCount <= 0)
        {
            sceneLoader.LoadNextScene();
        }
    }
}
