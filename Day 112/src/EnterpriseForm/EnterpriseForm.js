import React from 'react';
import '../EnterpriseForm/EnterpriseForm.css';
class EnterpriseForm extends React.Component{
    eval () {
        var sliderValue = document.getElementById('rating').value;
            document.getElementById('sliderVal').innerHTML = sliderValue;
    }
    render() {
        
        return(
            <div>
                <form className = "enterprise-form">
                    <div>
                        <i class="fas fa-globe-americas"></i>
                        <input type="text" placeholder="Enterprise Name">
                        </input>
                    </div>
                    <div>
                        <i class="fas fa-link"></i>
                        <input type="url" placeholder="Url de la empresa">
                        </input>
                    </div>
                    <div>
                        <i class="fas fa-envelope"></i>
                        <input type="email" placeholder="Correo">
                        </input>
                    </div>
                    <div>
                        <i class="fas fa-dot-circle"></i>
                        <input type="number" step="1" min="0" max="100" placeholder="Puntos Buró">
                        </input>
                    </div>         
                    <div>
                        <i class="fas fa-dot-circle"></i>
                        <input type="number" step="1" min="0" max="100000000" placeholder="Ingreso Mensual">
                        </input>
                    </div>
                    <div>
                        <i class="fas fa-bacon"></i>
                        <input type="number" step="1" min="0" max="10000000000" placeholder="Ingreso Neto">
                        </input>
                    </div>             
                    
                    <div>
                        <i class="fas fa-building none-border"></i>
                        <input type="range" class="custom-range" id="rating" onChange={this.eval} step="1" min="0" max="100" />
                        <div className="border-separator"/>
                        <output id="sliderVal"></output>
                        
                        </div>
                </form>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossOrigin="anonymous"/>

            </div>
            
        )
    }

}

export default EnterpriseForm;