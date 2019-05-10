import React, { Component} from 'react'
import './Navigation.css';


export default class Navigation extends Component {
  render() {
    return (
      <div>
      <ul id="nav">
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">FAQ</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </div>
    )
  }
}
