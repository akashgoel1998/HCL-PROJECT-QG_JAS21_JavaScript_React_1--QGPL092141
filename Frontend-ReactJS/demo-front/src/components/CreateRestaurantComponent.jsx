import React, { Component } from 'react'


export default class CreateRestaurantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            reastaurantId: this.props.match.params.restaurantId,
            restaurantName:'',
            managerName:'',
            contactNumber:'',
         
        }
        this.changeRestaurantName = this.changeRestaurantName.bind(this);
        this.changeManagerName=this.changeManagerName.bind(this);
        this.changeContactNumber=this.changeContactNumber.bind(this);

    }
    componentDidMount(){

        // step 4
        if(this.state.restaurantId === '_add'){
            return
        }else{
            CustomerService.getRestaurantById(this.state.restaurantId).then( (res) =>{
                let restaurant = res.data;
                this.setState({restaurantName: restaurant.restaurantName,
                    managerName:restaurant.managerName,
                    contactNumber:restaurant.contactNumber

                
                });
            });
        }        
    }
    saveOrUpdateRestaurant = (e) => {
        e.preventDefault();
        let restaurant = {restaurantName: this.state.restaurantName, managerName:this.state.managerName,
                           contactNumber:this.state.contactNumber}
        console.log('restaurant => ' + JSON.stringify(restaurant));

        // step 5
        if(this.state.restaurantId === '_add'){
            RestaurantService.createRestaurant(Restaurant).then(res =>{
                this.props.history.push('/restaurants');
            });
        }else{
            RestaurantService.updateRestaurant(restaurant, this.state.restaurantId).then( res => {
                this.props.history.push('/restaurants');
            });
        }
    }
    
    changeRestaurantNameHandler= (event) => {
        this.setState({restaurantName: event.target.value});
    }

   changeManagerNameHandler=(event)=>{
       this.setState({managerName:event.target.value});
   }
   changeContactNumberHandler=(event)=>{
       this.setState({managerName:event.target.value});
   }

    cancel(){
        this.props.history.push('/restaurants');
    }

    getTitle(){
        if(this.state.restaurantId === '_add'){
            return <h3 className="text-center">Add Restaurant </h3>
        }else{
            return <h3 className="text-center">Update Restaurant</h3>
        }
    }

   
    render() {
        return (
            <div>
                
            </div>
        )
    }
}
