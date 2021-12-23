import React, { Component } from 'react'

class HeaderComponent extends Component{
    
    constructor(props){
        
        super(props)
        this.state = {}
    }

    render(){

        return(
            <div>
                <header className = "header">        
                      <span className="text-muted">Online Food Delivery App</span>
                </header>
            </div>
        )
    }
}
export default HeaderComponent