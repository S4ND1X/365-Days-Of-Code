using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Rotator : MonoBehaviour
{
   
    void Update()
    {
        transform.Rotate(new Vector3 (90,45,90)*Time.deltaTime);
    }
}
