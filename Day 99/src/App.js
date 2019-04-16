import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';


import {todos} from './todos.json';


class App extends Component {
  //Se ejecuta antes del render
  constructor() {
    super();
    this.state = {
      todos
    }
}
  render() {
      //Devuelve cada uno de los todos 
      const todos = this.state.todos.map((todo, i)  => {
        return(
          //Estrucutra para presentarlas
          <div className="col-md-4">
            <div className="card">
              <div className="card-header">
                <h2>{todo.title}</h2>
              </div>
              <div  className="card-description">
                <h3>{todo.description}</h3>
              </div>
            </div>
          </div>

        )
      })
    return (
      <div className="App">
        <div className="container">
          <div className="row mt-4">
            {todos}
          </div>
        </div>    
      </div>
      
    );
  }
}

export default App;
