import React from 'react';
import MenuItem from '../menu-item/menu-item.component';
class Directory extends React.Component {

    constructor() {
        super();

        this.state = {
            sections: [{
                title: 'Balloons',
                imageUrl: 'https://images.unsplash.com/photo-1525268771113-32d9e9021a97?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60',
                id: 1
            }, {
                title: 'Teddies',
                imageUrl: 'https://images.unsplash.com/photo-1553364851-7de6d86102c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60',
                id: 2
            }, {
                title: 'Gifts',
                imageUrl: 'https://images.unsplash.com/photo-1549465220-1a8b9238cd48?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60',
                id: 3
            }, {
                title: 'Candy Bar',
                imageUrl: 'https://images.unsplash.com/photo-1519691548119-14735e4a11c8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60',
                size: 'large',
                id: 4
            }, {
                title: 'Events',
                imageUrl: 'https://images.unsplash.com/photo-1530023367847-a683933f4172?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60',
                size: 'large',
                id: 5
            }]
        }
    }

    render(){
        return(
            <div className='directory-menu'>
                {this.state.sections.map( ({ title, imageUrl, id, size}) => ( <MenuItem key = {id} title={title} imageUrl={imageUrl} size={size}/>))}
            </div>
        );
    }
}
export default Directory;