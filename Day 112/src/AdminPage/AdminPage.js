import React from 'react';
import './AdminPage.css';
import AdminCards from '../AdminCards/AdminCards.js';

class AdminPage extends React.Component{
    constructor() {
        super();
        this.state = {
            data: null,
        }
    }

    componentWillMount(){
        fetch(`${process.env.REACT_APP_API_URL}`)
        .then(response => response.json())
        .then(data => {this.setState({ data }); console.log(data.companies)});
    }
    render(){
        return (
        <div className="admin-container">
            {
                this.state.data === null ? <div></div> :
                this.state.data.companies.map(function(item, i){
                    console.log('test');
                    return (
                        <AdminCards
                            name= {item.name}
                            domain = {item.website}
                            employees = {item.employees}
                            twitter = {item.twitter}
                            linkedin = {item.linkedin}
                            facebook = {item.facebook}
                            />
                        )
                  })
            }
        </div>
        )
    }

}

export default AdminPage;