using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemySpawner : MonoBehaviour
{
    [SerializeField] private List<WaveConfig> waveConfigs;
    [SerializeField] private bool looping = false;
    private int startingWave = 0;

    // Start is called before the first frame update
    IEnumerator Start()
    {
        do yield return StartCoroutine(SpawnAllWaves());
        while (looping);
    }

    private IEnumerator SpawnAllWaves()
    {
        for(int waveIndex = startingWave; waveIndex < waveConfigs.Count; waveIndex++)
        {
            //Se empieza con la primera oleada y  se empieza la co-rutina
            var currentWave = waveConfigs[waveIndex];
            yield return StartCoroutine(SpawnAllEnemiesInWave(currentWave));
        }
    }

    private IEnumerator SpawnAllEnemiesInWave(WaveConfig waveConfig)
    {
        //Crea un enemigo hasta que haya la cantidad deseada por la configuracion
        for(int i = 0; i < waveConfig.GetNumberOfEnemies(); i++) {

            var newEnemy = Instantiate(waveConfig.GetEnemyPrefab(),
                    waveConfig.GetWayPoints()[0].transform.position,
                    Quaternion.identity);

            newEnemy.GetComponent<EnemyPathing>().SetWaveConfig(waveConfig);

            yield return new WaitForSeconds(waveConfig.GetTimeBetweenSpawn());
        }

    }
}
