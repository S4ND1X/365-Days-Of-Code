import React, { Component } from 'react'
import { Navbar, InputGroup, Form, FormControl, Button } from 'react-bootstrap';
import './Headernav.css'
export default class Headernav extends Component {
  render() {
    return (
      <div>
        <Navbar className="miclasejaja justify-content-between">
      <Form inline>
        <InputGroup>
          <InputGroup.Prepend>
            <InputGroup.Text id="basic-addon1">@</InputGroup.Text>
          </InputGroup.Prepend>
          <FormControl
            placeholder="Username"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
        </InputGroup>
      </Form>
      <Form inline>
        <FormControl type="text" placeholder="Search" className=" mr-sm-2" />
        <Button type="submit">Submit</Button>
      </Form>
    </Navbar>

        
      </div>
    )
  }
}