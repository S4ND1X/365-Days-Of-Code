import React from 'react';
import './InformationCard.css';
import PropTypes from 'prop-types';

class InformationCard extends React.Component {
    render() {
        return (
            <div className="card-container">
                <i class={this.props.icon}></i>
                <div className="title">{this.props.title}</div>
                <div className="description">{this.props.description}</div>
            </div>
        )
    }

}

InformationCard.propTypes = {
    icon: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired
}

export default InformationCard;