import React from 'react';
import Header from '../elements/Header/Header';
import Home from '../Home/Home';


//Siempre se tiene que retonar todo en una solo grupo. Por eso los <div>
//Los componentes son funciones que reciben y devuelven algo. En este caso devuelve dos componentes
const App = () => {
    return (
        <div>
            <Header />
            <Home />
        </div>
    )
}

export default App;