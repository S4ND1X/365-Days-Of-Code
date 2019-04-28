import React from 'react';
import './AcceptanceCard.css';
import { Line } from 'react-chartjs-2';

class AcceptanceCard extends React.Component {
    constructor(){
        super();
        this.state = {
            data: {
                labels: ["January", "February", "March", "April", "May", "June", "July"],
                datasets: [
                    {
                        label: "Amount to pay",
                        data: [65, 59, 80, 81, 56, 55, 40],
                        backgroundColor: [
                            "rgba(138, 121, 247, 0.2)"
                        ],
                        borderColor: ["rgba(138, 121, 247, 1)"],
                    }
                ]
            }
        }
    }
    render() {
        return(
        <div className="acceptance-container">
            <div className="title">
            HELLO there
            </div>
            <div className="chart">
                <Line
                    data={this.state.data}
                    height={400}
                    options={{
                        maintainAspectRatio: false
                    }}
                />
            </div>
        </div>
        
        )
    }

}

export default AcceptanceCard;