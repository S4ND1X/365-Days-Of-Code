import React, { Component } from "react";
import "./App.css";

//Components
import CardList from "./components/card-list/card-list.component";
import SearchBox from "./components/search-box/search-box.component";
import { stat } from "fs";



class App extends Component {
  constructor() {
    super();

    this.state = {
      monsters: [],
      searchField: ""
    };
  }

  componentDidMount() {
    //Fetch te devuelve el promise y then es para que hacer con ello
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(response => response.json())
      //La respuesta ya convertida en json, la pone en el array de monsters
      .then(users => this.setState({ monsters: users }));
  }

  render() {
    //Se define las variables y despues se filtran para ver si incluye el texto buscado
    const { monsters, searchField} = this.state;
    const filteredMonsters = monsters.filter(monster => monster.name.toLowerCase().includes(searchField.toLowerCase()));

    return (
      <div className="App">
        <h1>Monster Rolodex</h1>
        {/* Se le pasa como prop que funcion y el placeholder */}
        <SearchBox
          placeholder ='search monsters...'
          // Que funcion ejecuta cuando detecte el cambio
          //Esto se hace porque no se puede enviar info en dos direcciones
          handleChange = {e => this.setState({searchField: e.target.value})}
        />
        {/* Se le pasa el array filtrado de monsters como prop */}
        <CardList monsters={filteredMonsters} />
      </div>
    );
  }
}

export default App;
