import React, { Component } from "react";
import { Button, FormGroup, FormControl} from "react-bootstrap";
import "./Login.css";
import logo from '../Images/konfio.png';

export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: ""
    };
  }

  validateForm() {
    return this.state.email.length > 0 && this.state.password.length > 0;
  }

  handleChange = event => {
    this.setState({
      [event.target.id]: event.target.value
    });
  }

  handleSubmit = event => {
    event.preventDefault();
  }

    render() {
    return (
    <body>
    <div className="Login">
      <div className="pop">    
        <form onSubmit={this.handleSubmit}>  
        <img src={logo} alt="" className="login-logo"/>      
          <FormGroup controlId="email" className="email_label" bsSize="large">
          <i class="fas fa-envelope"></i>
            <FormControl
              autoFocus
              type="email"
              value={this.state.email}
              onChange={this.handleChange} placeholder="Mail" 
            
            />
          </FormGroup>
          <FormGroup controlId="password" bsSize="large">
          <i class="fas fa-key"></i>
            <FormControl
              value={this.state.password}
              onChange={this.handleChange}
              type="password" placeholder = "Password"
            />
          </FormGroup>
          <br/>
          <br/>
          <Button
            block
            bsSize="large"
            disabled={!this.validateForm()}
            type="submit"
            className="btn-primary-mine"
          >
            Login
          </Button>
        </form>
        </div>
    </div>
    </body>
    );
  }
}