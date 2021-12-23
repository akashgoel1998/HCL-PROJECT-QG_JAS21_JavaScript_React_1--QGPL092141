import React, { Component } from 'react';
import ItemService from '../../services/ItemService';

class UpdateItemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            name: '',
            quantity: '',
            cost: ''
        }
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changequantityHandler = this.changequantityHandler.bind(this);
        this.updateItem = this.updateItem.bind(this);
    }

    componentDidMount(){
        ItemService.getItemById(this.state.id).then( (res) =>{
            let item = res.data;
            this.setState({name: item.name,
                quantity: item.quantity,
                cost : item.cost
            });
        });
    }

    updateItem = (e) => {
        e.preventDefault();
        let item = {name: this.state.name, quantity: this.state.quantity, cost: this.state.cost};
        console.log('item => ' + JSON.stringify(item));
        console.log('id => ' + JSON.stringify(this.state.id));
        ItemService.updateItem(item, this.state.id).then( res => {
            this.props.history.push('/items');
        });
    }
    
    changenameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changequantityHandler= (event) => {
        this.setState({quantity: event.target.value});
    }

    changecostHandler= (event) => {
        this.setState({cost: event.target.value});
    }

    cancel(){
        this.props.history.push('/items');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Item</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Item Name: </label>
                                            <input placeholder="Name" name="name" className="form-control" 
                                                value={this.state.name} onChange={this.changenameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Quantity: </label>
                                            <input placeholder="Quantity" name="quantity" className="form-control" 
                                                value={this.state.quantity} onChange={this.changequantityHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> cost: </label>
                                            <input placeholder="Cost" name="cost" className="form-control" 
                                                value={this.state.cost} onChange={this.changecostHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateItem}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateItemComponent;
