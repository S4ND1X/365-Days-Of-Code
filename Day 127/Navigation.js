import React, { Component} from 'react'
import './Navigation.css';


export default class Navigation extends Component {

    render() {
        return (
          <footer className="neal-footer navbar">
            <Container>
                <Row>
                <Col size={["xs-12", "md-4"]}>
                    <p className="neal-footer-copyright">
                    © {new Date().getFullYear()}, {this.props.brandName}
                    </p>
                    {this.props.address}
                    <p>
                        <a href={`mailto:${this.props.email}`}>{this.props.email}</a>
                    </p>
                </Col>
                <Col size={["xs-12", "md-4"]}>
                </Col>
                <Col size={["xs-12", "md-4"]}>
                    {this.renderSocialIcons()}
                </Col>
                </Row>
            </Container>
            </footer>
        );
        }
    
    
    )
  }
}
