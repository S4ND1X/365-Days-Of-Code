using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyPathing : MonoBehaviour
{
    //Config param
    [SerializeField] private List<Transform> wayPoints;
    [SerializeField] private float moveSpeed = 3f;
    private int wayPointIndex = 0;

    // Start is called before the first frame update
    void Start()
    {
        transform.position = wayPoints[wayPointIndex].transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        MoveEnemyOnPath();

    }

    private void MoveEnemyOnPath()
    {
        //Si es lista se usa Count en vez de Length
        if (wayPointIndex <= wayPoints.Count - 1)
        {
            var targetPosition = wayPoints[wayPointIndex].transform.position;
            var movementThisFrame = moveSpeed * Time.deltaTime;
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
