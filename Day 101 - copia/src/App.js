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
          // Poner forma de columnas
          <div className="col-md-4">
          {/* Margin top de 4 */}
            <div className="card mt-4">
              <div className="card-header">
                <h2>{todo.title}</h2>
                {/* Poner un badge rojo y poner la prioridad */}
                <span class="badge badge-pill badge-info">
                  {todo.priority}
                </span>
              </div>
              <div  className="card-description">
                <h3>{todo.description}</h3>
                <p>{todo.responsible}</p>
              </div>
            </div>          
          </div>

        )
      })
    return (
      <div className="App">
        <nav className="navbar navbar-dark bg-dark">
          <a className="text-white">
            Tarjetas
            <span className="badge badge-pill badge-light ml-2">
              {this.state.todos.length}
            </span>
          </a>
        </nav>




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
