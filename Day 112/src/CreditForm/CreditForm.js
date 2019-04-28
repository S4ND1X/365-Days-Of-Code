import React from 'react';

class CreditForm extends React.Component{
    render() {
        return(
            <div>
                <form className = "credit-form">
                    <div>
                        <i class="fas fa-money-bill-wave"></i>
                        <input type="number" min="0.00" max="100000000000" step="1000" placeholder="Monto Deseado">
                        </input>
                    </div>
                    <div>
                        <i class="fas fa-calendar-alt"></i>
                        <input type="date" placeholder="Plazo Deseado">
                        </input>
                    </div>
                </form>
                <button type="submit" className="btn-primary-mine">Submit</button>
            </div>
        )
    }

}

export default CreditForm;