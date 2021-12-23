import { Component } from "react";

import Card from "react-bootstrap/Card";

class Frontpage extends Component{
    constructor(){
        super()
        this.customers=this.customers.bind(this)
    }
    customers(){
        this.props.history.push('/customers');
    }
    render(){
        return(
            <div className="addIcon">
                 <br></br>
                <h1 className="text-center bold">Online Food Delivery App</h1>
                <br></br>
                <div className = "row ">
                 <table className = " table-striped table-bordered table1" align="center">

                            <thead>
                                <tr>
                                    <th> <h4 className="text-center">Customer Information</h4></th>
                                </tr>
                            </thead>
                            <tbody>
                               
                                        <tr>
                                             <td  className="text-center"><button onClick={this.customers} className=" hbutton ">Customer </button>  </td>   
                                            
                                             
                                        </tr>
                                    
                                
                            </tbody>
                        </table>
                 </div>
            
            </div>
        
        
    );
    }
}
export default Frontpage



// <Card style={{ width: '18rem' }}>
//                 <Card.Img variant="top" src="holder.js/100px180" />
//                 <Card.Body>
//                      <Card.Title>Card Title</Card.Title>
//                     <Card.Text>
//                  Some quick example text to build on the card title and make up the bulk of
//                 the card's content.
//             </Card.Text>
//             <button className="btn btn-success" onClick={this.customers}>Save</button>
//         </Card.Body>
//             </Card>