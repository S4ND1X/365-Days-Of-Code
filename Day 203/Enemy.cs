using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    [Header("Enemy Config")]    
    private float shotCounter;
    [SerializeField] private float minTimeBetweenShots = 0.2f;
    [SerializeField] private float maxTimeBetweenShots = 3f;
    [SerializeField] private GameObject enemyLaserPrefab;
    [SerializeField] private float enemyLaserSpeed = 10f;
    [Header("VFX")]
    [SerializeField] private GameObject explosionParticles;
    [SerializeField] private float particlesDuration = 1f;
    [SerializeField] private AudioClip destroyClip;
    [SerializeField] [Range(0,1)] private float destroyClipVolume = 0.7f;
    [SerializeField] private AudioClip shootingClip;
    [SerializeField] [Range(0, 1)] private float shootingClipVolume = 0.7f;
    [Header("Enemy Stats")]
    [SerializeField] private int pointsPerKill = 10;
    [SerializeField] private float healt = 100;

    private GameSession gameSession;
    // Start is called before the first frame update
    void Start()
    {
        shotCounter = Random.Range(minTimeBetweenShots, maxTimeBetweenShots);
        gameSession = FindObjectOfType<GameSession>();
    }

    // Update is called once per frame
    void Update()
    {
        CountDownAndShoot();
    }

    private void CountDownAndShoot()
    {
        shotCounter -= Time.deltaTime;
        if (shotCounter <= 0f)
        {
            Fire();
            shotCounter = Random.Range(minTimeBetweenShots, maxTimeBetweenShots);
        }
    }

    private void Fire()
    {
        GameObject enemyLaser = Instantiate(enemyLaserPrefab,
                                             transform.position,
                                             Quaternion.identity) as GameObject;
        enemyLaser.GetComponent<Rigidbody2D>().velocity = new Vector2(0, -enemyLaserSpeed);
        AudioSource.PlayClipAtPoint(shootingClip, Camera.main.transform.position, shootingClipVolume);


    }

    private void OnTriggerEnter2D(Collider2D other)
    {

        //Lo que collisiono con nosotros tiene un damage dealer
        DamageDealer damageDealer = other.gameObject.GetComponent<DamageDealer>();
        if (!damageDealer) return; //Si no tiene damageDealer no hace nada
        ProccesHit(damageDealer);
    }

    private void Die()
    {
        gameSession.AddToScore(pointsPerKill);
        Destroy(gameObject);
        GameObject explosion =  Instantiate(explosionParticles, transform.position, transform.rotation);
        Destroy(explosion, particlesDuration);
        AudioSource.PlayClipAtPoint(destroyClip, Camera.main.transform.position, destroyClipVolume);
    }

    private void ProccesHit(DamageDealer damageDealer)
    {
        healt -= damageDealer.GetDamage();
        damageDealer.Hit();
        if (healt <= 0)
        {
            Die();
        }
    }
}
