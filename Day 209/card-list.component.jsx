import React from "react";
import "./card-list.styles.css";
import Card from '../card/card.component'

const CardList = props => (
        <div className='card-list'>
            {/* Recorre cada elemento y asigan su id y el despliega el nombre */}
            {props.monsters.map(monster => (
                //Regresa un componente Card con su key y se le pasa el prop
                <Card key={monster.id} monster={monster}/>
            ))}
        </div>
    );

export default CardList;

