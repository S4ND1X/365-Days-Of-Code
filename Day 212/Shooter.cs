using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Shooter : MonoBehaviour
{
    // Start is called before the first frame update

    [SerializeField] private GameObject projectile;
    [SerializeField] private Transform spawnPoint;

    public void Fire()
    {
        Instantiate(projectile, spawnPoint.position, spawnPoint.rotation);
    }   

}
