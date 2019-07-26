using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{

    [SerializeField] private float healt = 100;
    [SerializeField] private float shotCounter;
    [SerializeField] private float minTimeBetweenShots = 0.2f;
    [SerializeField] private float maxTimeBetweenShots = 3f;
    [SerializeField] private float enemyLaserSpeed = 10f;

    [SerializeField] private GameObject enemyLaserPrefab;
    // Start is called before the first frame update
    void Start()
    {
        shotCounter = Random.Range(minTimeBetweenShots, maxTimeBetweenShots);
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
