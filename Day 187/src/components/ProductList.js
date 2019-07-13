import React from 'react';
import Product from './Product'

const ProductList = ({ products, addToCart, removeFromCart, deleteFromCart }) => (
    <div className="container">
        <div className="columns is-centered">
        <div className="column is-narrow">
            {/* Se itera sobre el arreglo y regresandoo componentes con sus argumentos */}
            {products.map(prod => (
            <Product
                key = {prod.id}
                title = {prod.title}
                price = {prod.price}
                inventory = {prod.inventory}
                addToCart = {() =>addToCart(prod.id)} 
                removeFromCart = {()  => removeFromCart(prod.id)}
                deleteFromCart = {() => deleteFromCart(prod.id)}
            />
            ))}
        </div>
        </div>
    </div>
);

export default ProductList;
