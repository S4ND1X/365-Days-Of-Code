using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyPathing : MonoBehaviour
{
    //Config param
    private WaveConfig waveConfig;
    private List<Transform> wayPoints;
    private int wayPointIndex = 0;

    // Start is called before the first frame update
    void Start()
    {
        //Los puntos a visitar depende del wave config dado
        wayPoints = waveConfig.GetWayPoints();
        //Su posicion inicial es el primer punto de la oleada
        transform.position = wayPoints[wayPointIndex].transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        MoveEnemyOnPath();

    }

    public void SetWaveConfig(WaveConfig waveConfig)
    {
        this.waveConfig = waveConfig;
    }

    private void MoveEnemyOnPath()
    {
        //Si es lista se usa Count en vez de Length
        if (wayPointIndex <= wayPoints.Count - 1)
        {
            /*Se indica a donde se movera, cuanto se va a mover y cuando llegue al destino
            *se incrementa el index
            */
            var targetPosition = wayPoints[wayPointIndex].transform.position;
            var movementThisFrame = waveConfig.GetMoveSpeed() * Time.deltaTime;
            transform.position = Vector2.MoveTowards(transform.position,
                                                        targetPosition,
                                                        movementThisFrame);
            if (transform.position.Equals(targetPosition)) wayPointIndex++;
        }
        else
        {
            Destroy(gameObject);
        }
    }
}
