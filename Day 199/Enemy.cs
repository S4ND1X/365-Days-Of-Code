using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{

    [SerializeField] private float healt = 100;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        //Lo que collisiono con nosotros tiene un damage dealer
        DamageDealer damageDealer = other.gameObject.GetComponent<DamageDealer>();
        ProccesHit(damageDealer);
    }

    private void ProccesHit(DamageDealer damageDealer)
    {
        healt -= damageDealer.GetDamage();
        if (healt <= 0)
        {
            Destroy(gameObject);
        }
    }
}
