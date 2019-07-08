import React from "react";
//Funcion anonima, esto es igual a decir const total = props.total;
const NavBar = ({ total }) => (
  <nav className="navbar is-light">
    <div className="container">
      <div className="navbar-brand">
        <a className="navbar-item" href="https://bulma.io">
          <h1 className="title">My Store</h1>
        </a>
        <div
          className="navbar-burger burger"
          data-target="navbarExampleTransparentExample"
        >
          <span />
          <span />
          <span />
        </div>
      </div>

      <div id="navbarExampleTransparentExample" className="navbar-menu">
        <div className="navbar-end">
          <div className="navbar-item">
            <div className="field is-grouped">
              <p className="control">
                <a className="bd-tw-button button is-primary">
                  <span className="icon">
                    <i className="fas fa-shopping-cart" />
                  </span>
                  <span class="tag is-dark">${total}</span>
                </a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>
);

export default NavBar;
