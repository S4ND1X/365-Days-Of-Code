using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScriptBlock : MonoBehaviour
{

    [SerializeField] private AudioClip clip;
    [SerializeField] private float clipVolume = 100f;
    [SerializeField] GameObject blockParticles;

    private LevelScript level;

    private GameSession gameStatus;

    private void Start()
    {
        CountBreakableBlocks();
    }

    private void CountBreakableBlocks()
    {
        //Encontrar el objeto con el script
        level = FindObjectOfType<LevelScript>();
        if (tag == "Breakable") level.CountBlocks();
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (tag == "Breakable") DestroyBlock();
    }

    private void DestroyBlock()
    {
        PlayBlockSFX();
        Destroy(gameObject);
        gameStatus.addPoints();
        TriggerParticles();
    }

    private void PlayBlockSFX()
    {
        //PlayCliptAtPoint permite emitir sonido en coordenadas especificas
        AudioSource.PlayClipAtPoint(this.clip, transform.position, this.clipVolume);
        level.RemoveBreakableBlock();
    }

    private void TriggerParticles()
    {
        //Se crea el objeto de particulas y se destruyen en 1 segundo
        GameObject particles = Instantiate(blockParticles, transform.position, transform.rotation);
        Destroy(gameObject, 2f);
    }
}
