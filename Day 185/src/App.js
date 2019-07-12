import React, { Component, Fragment } from "react";
import NavBar from "./components/NavBar";
import ProductList from './components/ProductList'

//Arreglo de productos
const initialProdducts = [
  { id: 1, title: "IPhone XS", inventory: 4, price: 22500.0 },
  { id: 2, title: "Galaxy S9", inventory: 5, price: 18500.0 },
  { id: 3, title: "Huawei P30", inventory: 2, price: 15399.0 },
  { id: 4, title: "Google Pixel 3", inventory: 9, price: 24600.0 },
  { id: 5, title: "Motorla G6", inventory: 2, price: 13400.0 }
];

class App extends Component {

  state = {
    addedIds : [],
    quantityById: {},
    products: initialProdducts,
  };
  addToCart =  (id) => {
    const {addedIds, quantityById, products} = this.state;
    const product = products.find(prod => prod.id === id);
    const available = product.inventory -  (quantityById[id] || 0);
    if(available > 0){
      const newAddedIds = addedIds.find(prodId => prodId === id) ? addedIds : addedIds.concat(product.id); 
      const newQuantityById = {
        ...quantityById,
        [id] : (quantityById[id] || 0) + 1,
      };
      this.setState({addedIds : newAddedIds, quantityById: newQuantityById});
    }
  }

  removeFromCart = (id) => {
    const { addedIds, quantityById } = this.state;
    if(quantityById[id]){
      const newQuantityById = {
        ...quantityById,
        [id]: quantityById[id] > 1 ? quantityById[id] - 1 : undefined,
      };
      const newAddedIds = newQuantityById[id] ? addedIds : addedIds.filter(prodId => prodId !== id);
      this.setState({addedIds : newAddedIds, quantityById: newQuantityById});
    }
  }

  render() {
    return (
      //Se usa fragment para dividir sin crear nodos adicionales, No puede tener estilos
      <Fragment>
        <NavBar total={0.0} />
        <ProductList 
        products = {initialProdducts} 
        addToCart = {this.addToCart}
        removeFromCart = {this.removeFromCart}
        />
      </Fragment>
    );
  }
}

export default App;
