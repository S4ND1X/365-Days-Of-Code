

using System.Collections;
using System.Collections.generic;
using UnityEngine;

public class Enemy : MonoBehaviour{

    [SerializedField] private float moveSpeed = 1f;
    private RigidBody2D myRigidBody;

    bool isFacingRight;


    void Start(){
        this.myRigidBody = GetComponent<RigidBody2D>();
    }

    void Update(){
        myRigidBody.velocity = new Vector2(this.moveSpeed,0f)
    }

    private void OnTriggerExit2D(Collider2D collision){
        transform.localScale = new Vector2(-(Mathf.Sign(myRigidBody.velocity.x)),1f);
    }
}