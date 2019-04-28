import React from 'react';
import './AdminCards.css';
import PropTypes from 'prop-types';

class AdminCards extends React.Component {
    render(){
        return(
        <div className="admin-card-container">
        <div className="style-information">
                <div className="title"><a href={this.props.domain}>{this.props.name}</a></div>
            <div className="employees">
                <div >Employees </div>
                <i className="fas fa-user-tie"></i>
                <div className="num-employees"> {this.props.employees} </div>
            </div>
        </div>
        <div className="social-media">
            <a href ={this.props.twitter}>
            <i className="fab fa-twitter"></i>
            </a>
            <a href = {this.props.linkedin}>
            <i className="fab fa-linkedin"></i>
            </a>
            <a href = {this.props.facebook}>
            <i className="fab fa-facebook-f"></i>
            </a>
        </div>

        </div>
        )
    }
}

AdminCards.propTypes = {
    name: PropTypes.string.isRequired,
    domain: PropTypes.string.isRequired,
    employees: PropTypes.number.isRequired,
    twitter: PropTypes.string.isRequired,
    linkedin: PropTypes.string.isRequired,
    facebook: PropTypes.string.isRequired,
}

export default AdminCards;