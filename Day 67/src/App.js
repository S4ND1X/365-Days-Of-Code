import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Headernav from './Components/Header-Nav/Headernav'
import Cosaquehacepop from './Components/Header-Nav/Cosaquehacepop'
class App extends Component {
  render() {
    return (
      <div className="App">
        <Headernav /> 
        <Cosaquehacepop />       
      </div>
    );
  }
}

export default App;
