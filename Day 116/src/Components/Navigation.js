import React, { Component} from 'react'
import './Navigation.css';


export default class Navigation extends Component {
  render() {
    return (
      <div>
        <header>
            <nav>
                <div className="nav-bar">
                    <div className="nav-container">
                    <ul>
                        <li><a href="#">Prueba 1</a></li>
                        <li><a href="#">Prueba 2</a></li>
                        <li><a href="#">Prueba 3</a></li>
                        <li><a href="#">Prueba 4</a></li>
                        <li><a href="#">Prueba 5</a></li>

                    </ul>
                    </div>
                </div>
            </nav>
        </header>
        
      </div>
    )
  }
}
