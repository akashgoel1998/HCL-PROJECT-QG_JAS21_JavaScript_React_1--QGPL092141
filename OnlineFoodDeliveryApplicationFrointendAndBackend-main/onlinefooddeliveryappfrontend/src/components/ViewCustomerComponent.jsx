import React, { Component } from 'react'
import CustomerService from '../services/CustomerService'

class ViewCustomerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            customer: []
        }
    }

    componentDidMount(){
        CustomerService.getCustomerById(this.state.id).then( res => {
            this.setState({customer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Customer Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Customer First Name: <b>{ this.state.customer.firstName }</b></label>
                        </div>
                        <div className = "row">
                            <label> Customer Last Name: <b>{ this.state.customer.lastName } </b></label>                            
                        </div>
                        <div className = "row">
                            <label> Customer Age: <b>{ this.state.customer.age }</b></label>
                        </div>
                        <div className = "row">
                            <label> Customer Gender: <b>{ this.state.customer.gender }</b></label>                           
                        </div>
                        <div className = "row">
                            <label> Customer Mobile Number: <b>{ this.state.customer.mobileNumber }</b></label>                           
                        </div>
                        <div className = "row">
                            <label> Customer Email: <b>{ this.state.customer.email }</b></label>                          
                        </div>
                        <br></br>
                        <div align="center" >
                            <button className="btn btn-primary" > Select Restaurant to add Food</button>
                        </div>

                    </div>

                </div>
            </div>
        )
    }
}

export default ViewCustomerComponent
