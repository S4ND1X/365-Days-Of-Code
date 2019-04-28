import React from 'react';
import '../PersonalForm/PersonalForm.css';

class PersonalForm extends React.Component{
    render() {
        return(
            <div>
                <form className = "personal-form">
                    <div>
                        <i class="fas fa-user"></i>
                        <input type="text" placeholder="Nombre">
                        </input>
                    </div>
                    <div>
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Correo">
                        </input>
                    </div>
                </form>
            </div>
        )
    }

}

export default PersonalForm;