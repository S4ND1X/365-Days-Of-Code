using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    //Config param
    [SerializeField] private AudioClip[] clips;
    [SerializeField] private int bulletMaxTime;
    [SerializeField] private GameObject particle;
    private int timeSinceBulletSpawned;

    // Start is called before the first frame update
    void Start()
    {
        PlayFiringSFX();
        Destroy(gameObject, bulletMaxTime);

    }

    private void PlayFiringSFX()
    {
        //Reproduce el sonido en donde sea el inicio de la bala
        AudioSource.PlayClipAtPoint(clips[0], transform.position);
    }
    private void PlayHitSFX()
    {
        AudioSource.PlayClipAtPoint(clips[1], transform.position);
    }


    private void OnTriggerEnter(Collider other)
    {
        PlayHitSFX();
        //ParticlesHit();
        Destroy(gameObject);
        Debug.Log("Collision");
    }

   /* private void ParticlesHit()
    {
        Instantiate(particle, transform.position, Quaternion.identity);
        Destroy(particle,3.0f);

    }
    */
}
