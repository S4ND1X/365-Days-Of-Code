using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spinner : MonoBehaviour
{
    [SerializeField] private float spinnerSpeed = 10f;
    // Update is called once per frame
    void Update()
    {
        transform.Rotate(0, 0, spinnerSpeed);
    }
}
