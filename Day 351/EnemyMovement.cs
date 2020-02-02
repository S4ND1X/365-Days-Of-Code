using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyMovement : MonoBehaviour
{

    //Param
    [SerializeField] private float movementSpeed = 1f;

    //Cache Ref
    private Rigidbody2D myRigidBody;

    // Start is called before the first frame update
    void Start()
    {
        this.myRigidBody = GetComponent<Rigidbody2D>();
        this.movementSpeed = Random.Range(1f, 3f);
    }

    // Update is called once per frame
    void Update()
    {
        Move();
    }

    private void Move()
    {
        if (IsFacingRight())
        {
            this.myRigidBody.velocity = new Vector2(this.movementSpeed, 0f);
        }
        else
        {
            this.myRigidBody.velocity = new Vector2(-this.movementSpeed, 0f);
        }
        
    }

    private bool IsFacingRight()
    {
        return transform.localScale.x < 0;
    }

    private void OnTriggerExit2D(Collider2D collision)
    {
        transform.localScale = new Vector2(Mathf.Sign(this.myRigidBody.velocity.x),1f);   
    }

}
