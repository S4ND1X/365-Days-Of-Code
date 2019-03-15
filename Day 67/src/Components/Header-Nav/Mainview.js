import React, { Component } from 'react'

export default class Mainview extends Component {
  render() {
    return (
      <div>       
        {/* Como hacer un buen hero */}
        {/* Se usa un section y despues un div para poder usar bien Flexbox  */}
        <section className="hero">
            <div className="hero-container">
                <h1> Pagina Test </h1>
                <h2> Porfa no falles  </h2>
                <a href="http://pavbca.com/walldb/original/0/f/5/110230.jpg " class="btn">Go ahead...</a> 
            </div>
        </section>   
    </div>
    )
  }
}
