using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BackgroundScroller : MonoBehaviour
{   //Obtener el material y crear el movimiento
    [SerializeField] private float backgroundScrollerSpeed = 0.5f;
    private Material myMaterial;
    private Vector2 offSet;
    // Start is called before the first frame update
    void Start()
    {
        myMaterial = GetComponent<Renderer>().material;
        offSet = new Vector2(0, backgroundScrollerSpeed);
    }

    // Update is called once per frame
    void Update()
    {
        //Se va a mover en el vector creado
        myMaterial.mainTextureOffset += offSet * Time.deltaTime;
    }
}
