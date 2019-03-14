import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Inicio from './Components/Header-Nav/Inicio'
import Menu from './Components/Header-Nav/Menu'
import Headernav from './Components/Header-Nav/Headernav'
import Mainview from './Components/Header-Nav/Mainview'
class App extends Component {
  render() {
    return (
      <div className="App">
        <Headernav />
        <Mainview />
      </div>
    );
  }
}

export default App;
