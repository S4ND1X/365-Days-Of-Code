import React, { Component} from 'react'
import './Navigation.css';


export default class Navigation extends Component {
  render() {
    return (
      
    
      constructor(props) {
        super(props);
        this.state = {
          mounted: false
        };
      }
    
      componentDidMount() {
        this.setState({ mounted: true });
      }
      
      handleSubmit = (e) => {
        this.setState({ mounted: false });
        e.preventDefault();
      }
    
      render() {
        const {mounted} = this.state;
    
        let child;
        let test = 12;
    
        if(mounted) {
          child = (
            <div className="App_test">
              <NavigationPanel></NavigationPanel>
              <Modal onSubmit={this.handleSubmit}/>
            </div>
          );
        }
        
        return(
          <div className="App">
            <ReactCSSTransitionGroup 
              transitionName="example"
              transitionEnterTimeout={500}
              transitionLeaveTimeout={300}>
                {child}
            </ReactCSSTransitionGroup>
          </div>
    )
  }
}
