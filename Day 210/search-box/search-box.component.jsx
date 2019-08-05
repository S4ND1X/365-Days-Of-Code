import React from 'react';
import './search-box.styles.css'

const SearchBox = ({ placeholder, handleChange}) => (
    // El input cambia al valor obtenido del input y automaticamente lo filtra la funcion de arriba
    <input
        className= 'search'
        type='search'
        placeholder= {placeholder}
        onChange= { handleChange }
    />
)

export default SearchBox;

