import React, { Component} from 'react'
import './Navigation.css';


export default class Navigation extends Component {
  render() {
    return (
      <div class="luxbar luxbar-static">
    <input type="checkbox" id="luxbar-checkbox" class="luxbar-checkbox">
    <div class="luxbar-menu luxbar-menu-right luxbar-menu-dark">
        <ul class="luxbar-navigation">
            <li class="luxbar-header">
                <a class="luxbar-brand" href="#">Brand</a>
                <label class="luxbar-hamburger luxbar-hamburger-doublespin"
                        for="luxbar-checkbox"> <span></span> </label>
            </li>
            <li class="luxbar-item active"><a href="#">Home</a></li>
            <li class="luxbar-item dropdown"><a href="#">Users</a>
                <ul>
                    <li class="luxbar-item" ><a href="#">Prueba</a></li>
                    <li class="luxbar-item" ><a href="#">Prueba</a></li>
                    <li class="luxbar-item" ><a href="#">Prueba</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
    )
  }
}
