import React from "react";
import "./App.css";

import {Switch, Route} from 'react-router-dom';

//Components
import HomePage from "./pages/homepage/homepage.component";


const BaloonsPage = () => (
  <div>
    <h1>Baloons Page</h1>
  </div>
)

function App() {
  return (
    <div>
      <Switch>
        <Route path='/' component = {HomePage}/>
        <Route path='/baloons' component = {BaloonsPage}/>
      </Switch>
    </div>
  );
}



export default App;



