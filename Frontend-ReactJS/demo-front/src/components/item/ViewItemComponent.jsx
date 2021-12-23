import React, { Component } from 'react';
import ItemService from '../../services/ItemService';

class ViewItemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            item: {}
        }
    }

    componentDidMount(){
        ItemService.getItemById(this.state.id).then( res => {
            this.setState({item: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Item Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Item Name: </label>
                            <div> { this.state.item.name }</div>
                        </div>
                        <div className = "row">
                            <label> Quantity: </label>
                            <div> { this.state.item.quantity }</div>
                        </div>
                        <div className = "row">
                            <label> Cost: </label>
                            <div> { this.state.item.cost }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewItemComponent;
