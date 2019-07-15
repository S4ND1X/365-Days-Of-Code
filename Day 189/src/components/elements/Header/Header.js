import React from 'react';
import './Header.css'


const Header = () => {

    return (
        //Esto se puede remplazar con
        //?React.createElement('div', {className: 'react_div'}, 'This is a test');
        //Header basico con dos imagenes en el
        <div className = "rmdb-header">
            <div className = "rmdb-header-content">
                <img className = "rmdb-logo" src= "./images/reactMovie_logo.png" alt ="rmdb-logo" />
                <img className = "rmdb-tmdb-logo" src= "./images/tmdb_logo.png" alt ="tmdb-logo" /> 
            </div>
        </div>
    )
}
export default Header;
