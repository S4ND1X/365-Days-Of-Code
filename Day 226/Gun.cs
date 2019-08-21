using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Gun : MonoBehaviour
{
    [SerializeField] private GameObject bulletPrefab;
    [SerializeField] private Transform bulletSpawnPoint;
    [SerializeField] private float bulletSpeed;
    [SerializeField] private string fireInputName;


    // Update is called once per frame
    void FixedUpdate()
    {
        if(Input.GetButtonDown(fireInputName))Shoot();
    }


    private void Shoot()
    {
        GameObject currentSpawnedBullet;
        currentSpawnedBullet = Instantiate( bulletPrefab,
                                            bulletSpawnPoint.position,
                                            bulletSpawnPoint.rotation) as GameObject;

        Rigidbody bulletTempRB;
        bulletTempRB = currentSpawnedBullet.GetComponent<Rigidbody>();

        bulletTempRB.AddForce(transform.forward * bulletSpeed);

    }
}
