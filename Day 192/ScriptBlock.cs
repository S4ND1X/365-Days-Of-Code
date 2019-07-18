using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScriptBlock : MonoBehaviour
{

    [SerializeField] private AudioClip clip;
    [SerializeField] private float clipVolume = 100f;

    private LevelScript level;

    private void Start()
    {
        level = FindObjectOfType<LevelScript>();
        level.CountBreakableBlocks();
    }
    private void OnCollisionEnter2D(Collision2D collision)
    {
        //PlayCliptAtPoint permite emitir sonido en coordenadas especificas
        AudioSource.PlayClipAtPoint(this.clip, transform.position, this.clipVolume);
        level.RemoveBreakableBlock();
        Destroy(gameObject);
    }
}
