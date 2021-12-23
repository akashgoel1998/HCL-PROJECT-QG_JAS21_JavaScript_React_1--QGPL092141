import React, { Component } from 'react';
import ItemService from '../../services/ItemService';

class CreateItemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            name: '',
            quantity: '',
            cost: ''
        }
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changequantityHandler = this.changequantityHandler.bind(this);
        this.saveOrUpdateItem = this.saveOrUpdateItem.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ItemService.getItemById(this.state.id).then( (res) =>{
                let item = res.data;
                this.setState({name: item.name,
                    quantity: item.quantity,
                    cost : item.cost
                });
            });
        }        
    }
    saveOrUpdateItem = (e) => {
        e.preventDefault();
        let item = {name: this.state.name, quantity: this.state.quantity, cost: this.state.cost};
        console.log('item => ' + JSON.stringify(item));

        // step 5
        if(this.state.id === '_add'){
            ItemService.createItem(item).then(res =>{
                this.props.history.push('/items');
            });
        }else{
            ItemService.updateItem(item, this.state.id).then( res => {
                this.props.history.push('/items');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Item</h3>
        }else{
            return <h3 className="text-center">Update Item</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Name: </label>
                                            <input placeholder="Name" name="name" className="form-control" 
                                                value={this.state.name} onChange={this.changenameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Quantity: </label>
                                            <input placeholder="Quantity" name="quantity" className="form-control" 
                                                value={this.state.quantity} onChange={this.changequantityHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Cost: </label>
                                            <input placeholder="Cost" name="cost" className="form-control" 
                                                value={this.state.cost} onChange={this.changecostHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCustomer}>Save</button>
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

export default CreateItemComponent;
