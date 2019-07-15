import React, {Component} from 'react';
import HeroImage from '../elements/HeroImage/HeroImage';
import SearchBar from '../elements/SearchBar/SearchBar';
import FourColGrid from '../elements/FourColGrid/FourColGrid';
import MovieThumb from '../elements/MovieThumb/MovieThumb';
import LoadMoreButton from '../elements/LoadMoreBtn/LoadMoreBtn';
import Spinner from '../elements/Spinner/Spinner';

import './Home.css';

//Se importa {Component} para no tener que poner extends React.Component
//Un componente clase siempre tiene un estado y un metodo de renderizado que devuelve algo
class Home extends Component {
    state = {

    }

    render(){
        return (
            <div className="rmdb-home">
                <HeroImage />
                <SearchBar />
                <FourColGrid />
                <Spinner />
                <LoadMoreButton />
            </div>
        )
    }
}

export default Home;