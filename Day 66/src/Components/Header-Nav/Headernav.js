import React, { Component } from 'react'
import Contacto from './Contacto'
import Menu from './Menu'
import Inicio from './Inicio'
import Nosotros from './Nosotros'
import './Headernav.css'
export default class Headernav extends Component {
  render() {
    return (
      <div className="wea">               
          <Inicio />          
          <Menu />
          <Contacto />
          <Nosotros />        
      </div>
    )
  }
}
