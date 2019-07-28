using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class HealthDisplay : MonoBehaviour
{

    private Text healthText;
    private Player playerHealth;
    

    // Start is called before the first frame update
    void Start()
    {
        healthText = GetComponent<Text>();
        playerHealth = FindObjectOfType<Player>();
        healthText.text = playerHealth.GetPlayerHealth().ToString();
    }

    // Update is called once per frame
    void Update()
    {
        healthText.text = playerHealth.GetPlayerHealth().ToString();
    }
}
