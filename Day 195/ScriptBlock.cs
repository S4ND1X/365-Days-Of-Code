using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScriptBlock : MonoBehaviour
{
    //Config param
    [SerializeField] private AudioClip clip;
    [SerializeField] private GameObject blockParticles;
    [SerializeField] Sprite[] hitSprites;

    //Cached reference
    private LevelScript level;

    //State Variables
    [SerializeField] int timesHit; //serialized solo para poder verla

    private void Start()
    {
        CountBreakableBlocks();
    }

    private void CountBreakableBlocks()
    {
        //Encontrar el objeto con el script
        level = FindObjectOfType<LevelScript>();
        if (tag.Equals("Breakable"))level.CountBlocks();

    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        PlayBlockSFX();
        HandleHit();

    }

    private void HandleHit()
    {
        if (tag.Equals("Breakable"))
        {
            timesHit++;
            int maxHits = hitSprites.Length + 1;
            if (timesHit >= maxHits)
            {
                DestroyBlock();
            }else
            {
                ShowNextSprite();
            }
        }
    }

    private void ShowNextSprite()
    {
        int spriteIndex = timesHit - 1;
        if (hitSprites[spriteIndex] != null) GetComponent<SpriteRenderer>().sprite = hitSprites[spriteIndex];
        else Debug.LogError("Block Sprite Missing " + gameObject.name);
    }

    private void DestroyBlock()
    {
        FindObjectOfType<GameSession>().addPoints();
        TriggerParticles();
        Destroy(gameObject);
        level.RemoveBreakableBlock();
    }

    private void PlayBlockSFX()
    {
        //PlayCliptAtPoint permite emitir sonido en coordenadas especificas
        AudioSource.PlayClipAtPoint(this.clip, transform.position);
    }

    private void TriggerParticles()
    {
        //Se crea el objeto de particulas y se destruyen en 1 segundo
        GameObject particles = Instantiate(blockParticles, transform.position, transform.rotation);
        Destroy(gameObject, 2f);
    }
}
