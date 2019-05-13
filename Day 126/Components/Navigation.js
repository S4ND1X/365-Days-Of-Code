import React, { Component} from 'react'
import './Navigation.css';


export default class Navigation extends Component {
  render() {
    return (
      <footer id="footer">
        <p class="copyright">Made with
            <i class="fa fa-heart"></i> By
            <a target="_blank" title="Orbit Themes" href="http://www.orbitthemes.com">S4ND1X</a> &copy;
            <span id="currentYear"></span> All Rights Reserved.
        </p>
        <div class="social">
            <a traget="_blank" href="https://facebook.com/orbitthemes" title="facebook">
                <i class="fa fa-facebook"></i>
            </a>
            <a traget="_blank" href="https://twitter.com/orbitthemes" title="twitter">
                <i class="fa fa-twitter"></i>
            </a>
            <a traget="_blank" href="https://plus.google.com/+orbitthemes" title="Google+" target="_blank">
                <i class="fa fa-google-plus"></i>
            </a>
            <a traget="_blank" href="https://github.com/orbitthemes" title="github" target="_blank">
                <i class="fa fa-github"></i>
            </a>
            <a traget="_blank" href="https://www.behance.net/orbitthemes" title="Behance" target="_blank">
                <i class="fa fa-behance"></i>
            </a>
            <a traget="_blank" href="https://dribbble.com/orbitthemes" title="Dribbble" target="_blank">
                <i class="fa fa-dribbble"></i>
            </a>
            <a traget="_blank" href="https://www.pinterest.com/orbitThemes/" title="Pinterest" target="_blank">
                <i class="fa fa-pinterest"></i>
            </a>
            <a traget="_blank" href="https://www.reddit.com/user/orbitthemes" title="Reddit" target="_blank">
                <i class="fa fa-reddit"></i>
            </a>
            <a traget="_blank" href="https://orbitthemes.com/blog/" title="RSS" target="_blank">
                <i class="fa fa-rss"></i>
            </a>
        </div>
    </footer>
    
    
    )
  }
}
