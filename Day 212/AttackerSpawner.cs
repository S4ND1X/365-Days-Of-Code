using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AttackerSpawner : MonoBehaviour
{

    private bool spawn = true;
    [SerializeField] private float min, max;
    [SerializeField] private Attacker attackerPrefab;

    private IEnumerator Start()
    {
        while (spawn)
        {
            yield return new WaitForSeconds(Random.Range(min, max));
            SpawnAttacker();
        }
    } 

    private void SpawnAttacker()
    {
        Instantiate(attackerPrefab, transform.position, transform.rotation);
    }
}
