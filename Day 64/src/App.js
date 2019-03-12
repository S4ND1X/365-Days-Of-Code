import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Headernav from './Components/Header-Nav/Headernav'
class App extends Component {
  render() {
    return (
      <div className="App"> 
        <Headernav />        
      </div>
    );
  }
}

export default App;
