import React, { Component } from "react";
import "./App.css";

class App extends Component {
  constructor() {
    super();

    this.state = {
      monster: []
    };
  }

  componentDidMount() {
    //!Hace el request a la pagina, despues convierte esa respuesta en un json
    fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => response.json())
    //!Despues de convertir en json, asigna a este array lo adquirido
    .then(users => this.setState({ monster : users }))
  }


  render() {
    return this.state.monster.map(monster => (
      <h1 key={monster.id}> {monster.name} </h1>
    ));
  }
}

export default App;
