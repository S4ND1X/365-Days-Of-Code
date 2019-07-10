import React from 'react'

//Recibe tres argumentos para desplegarlos en pantalla
const Product = ({title, price, inventory}) => (
    //Aqui se utiliza div para poder agregar estilos
    <div style ={{ margin : '1.5rem'}}>
        <p><strong>{title}</strong> - ${price}</p>
        <div className="field is-grouped">
            <p className="control">
                {/* Modificadores de bulma */}
                <span className="tag is-primary is-medium is-rounded">{inventory}</span>
            </p>
            <p className="control">
                <a className="button is-link is-rounded">
                    {/* Iconos de font awesome */}
                    <span className="icon is-small">
                    <i className="fas fa-plus" />
                    </span>
                </a>
            </p>
            <p className="control">
                <a className="button is-warning is-rounded">
                    {/* Iconos de font awesome */}
                    <span className="icon is-small">
                    <i className="fas fa-minus" />
                    </span>
                </a>
            </p>
            <p className="control">
                <a className="button is-danger">
                    {/* Iconos de font awesome */}
                    <span className="icon is-small">
                    <i className="fas fa-trash" />
                    </span>
                </a>
            </p>
        </div>
    </div>
);

export default Product;