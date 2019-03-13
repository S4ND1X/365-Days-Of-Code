import React, { Component } from 'react'
import './Menu.css'

export default class Menu extends Component {
  render() {
    return (
      <div>
            {/* start nav */}
            <nav id="menu">
              <ul>
                <li><a href="#">Menu</a></li>
                <ul>
                <li><a href="#">Menu.1  </a></li>
                <li><a href="#">Menu.2</a></li>
                <li><a href="#">Menu.3</a></li>
                </ul>
              </ul>
            </nav>            
            
      </div>
      )
  }
}
