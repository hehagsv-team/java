import React, { Component } from 'react';
import {connect} from 'react-redux';
import {withRouter} from 'react-router-dom';
// import { register } from '../../serviceWorker';
import * as actionCreators from '../store/actions';
import Spinner from '../../UI/Spinner';
import './Orders.css';

class Orders extends Component {

    state={
        username:'',
        firstButtonDisabled:false,
        previousButtonDisabled:true,
        nextButtonDisabled:false,
        lastButtonDisabled:false,
        tableStart:0
    }
    componentWillMount(){
        const username = localStorage.getItem('username')
        console.log('[CART] page username is : ',username)
        this.setState({username:username})
        console.log('[Orders] componentDidMount')
        this.props.orderDetails(username)
        if(username==='' || username===null)
        {
            console.log('[Orders] PLEASE LOGIN')
            const ordersPageMessage='Please Login To Show Orders'
            this.props.loginError(ordersPageMessage)
            this.props.history.push('/login')
        }
        
        
    }
    componentDidUpdate(){
        console.log('[Orders] componentDidUpdate')
     
    }
    paginationFirstButtonClicked = (event,tableSize) => {
        console.log('insdie paginationFirstButtonClicked',tableSize)
        this.setState({paginationButton:event.target.value,
        tableStart:0,
        previousButtonDisabled:true,
        nextButtonDisabled:false})
      

    }
    paginationLastButtonClicked = (event,itemsLength,tableSize) => {
        this.setState({paginationButton:event.target.value,
        tableStart:itemsLength-tableSize,
        previousButtonDisabled:false,
        nextButtonDisabled:true    })
       

    }
    paginationPreviousButtonClicked = (event,tableSize) => {
        
        // if(this.state.tableStart===1)
        // {
        //     this.setState({paginationButton:event.target.value,
        //         tableStart:this.state.tableStart-1, nextButtonDisabled:false})

        // }
        // else{
        this.setState({paginationButton:event.target.value,
        tableStart:this.state.tableStart-tableSize,nextButtonDisabled:false})
        // }
    
        if((this.state.tableStart-tableSize)===0){
            console.log('entered itno tablestart===0')
            this.setState({previousButtonDisabled:true})
        }
        if((this.state.tableStart-tableSize)<=0){
            this.setState({previousButtonDisabled:true})
        }
    
    }
    paginationNextButtonClicked = (event,itemsLength,tableSize) => {
        this.setState({paginationButton:event.target.value,
        tableStart:this.state.tableStart+tableSize,
        previousButtonDisabled:false})
       
        console.log('table start and itemlength is : ',this.state.tableStart,tableSize,itemsLength)
        if(((itemsLength %2 ===0) && ((tableSize+tableSize)===itemsLength))
        || (this.state.tableStart+tableSize+1)===itemsLength){
            this.setState({nextButtonDisabled:true})
        }

        if(this.state.tableStart+tableSize+tableSize===itemsLength){
            this.setState({nextButtonDisabled:true})
        }
   

    }

    // showOrderDetails = () => {
        // this.props.orderDetails(this.state.username)
    // }

   

    render() {
        console.log('[Orders] render()')
        const tableSize=2
        console.log("order details are : ",this.props.orders)
        let itemsInTable=[...this.props.orders]
        // itemsInTable.map(key=>console.log('keys are :',key))    
        //     .Object.keys(key=>console.log('value of each and every key : ',key))
        const itemsLength=itemsInTable.length;
        let disableAllPButtons=false
        if(itemsLength<=tableSize){
            disableAllPButtons=true
        }
        if(this.state.paginationButton==='First'){
            console.log('[CART] ENTERED INTO FIRST')
            console.log("length of itemsInTable is : ",itemsInTable.length)
            const firstElement=itemsInTable.slice(this.state.tableStart,this.state.tableStart+2)
            console.log('First button firstElement value is : ',firstElement)
            itemsInTable=firstElement
            // this.updateTableStart(tableSize)
            console.log('[First] tableStart in',this.state.tableStart)
            
        }
        else if(this.state.paginationButton==='Last'){
            console.log('[CART] ENTERED INTO LAST')
            console.log("length of itemsInTable is : ",itemsInTable.length)
            const LastElement=itemsInTable.slice(itemsInTable.length-tableSize,itemsInTable.length)
            console.log('Last button LastElement value is : ',LastElement)
            itemsInTable=LastElement
            
        }
        else if(this.state.paginationButton==='Previous'){
            console.log('[CART] ENTERED INTO PREVIOUS')
            console.log("length of itemsInTable is : ",itemsInTable.length)
            let PreviousElement=[]
            if(this.state.tableStart<0){
                PreviousElement=itemsInTable.slice(0,
                    1)
            }
            else{
                PreviousElement=itemsInTable.slice(this.state.tableStart,
                    this.state.tableStart+tableSize)
            }
           
            console.log('Previous button firstElement value is : ',PreviousElement)
            itemsInTable=PreviousElement
            // this.updateTableStart(tableSize)
            console.log('[Previous] tableStart in',this.state.tableStart)
            
        }
        else if(this.state.paginationButton==='Next'){
            console.log('[CART] ENTERED INTO NEXT')
            console.log("length of itemsInTable is : ",itemsInTable.length)
            const nextElement=itemsInTable.slice(this.state.tableStart,
                                                    this.state.tableStart+tableSize)
            console.log('Previous button firstElement value is : ',nextElement)
            itemsInTable=nextElement
            // this.updateTableStart(tableSize)
            console.log('[Next] tableStart in',this.state.tableStart)
            
        }
        else{
            itemsInTable=itemsInTable.slice(this.state.tableStart,this.state.tableStart+tableSize)
        }
        const tableBody=(
            <table>
            <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Order Id</th>
                            <th>Ordered Date</th>
                            <th>Delivery Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {itemsInTable.map((item,index)=>
                        
                        <tr>{console.log('item name is :',Object.keys(item).map(key=>key).map(key=>
                        console.log("nested items are : ",key)))}
                            <td>{[Object.values(item).map(key=>key.itemName)].join('')}</td>
                            <td>{[Object.values(item).map(key=>key.price)].join('')}</td>
                            <td>{[Object.values(item).map(key=>key.quantity)].join('')}</td>
                            <td>{Object.keys(item).map(key=>key).map(key=>key)}</td>
                            <td>{[Object.values(item).map(key=>key.orderedDate)].join('')}</td>
                            <td>Shipped</td>

                        </tr>

                        )}
                            
                        
                        
                    </tbody>
                </table>
        )
        return (
            <div>
            <div className='table-name'>Orders</div>
            <div className='ordersTable'>
        {/* {this.showOrderDetails()} */}
       {itemsInTable.length>0 ? tableBody:<Spinner/>}
            </div>
            <div className='pagination'>
               <span> <button disabled={disableAllPButtons ? true : this.state.firstButtonDisabled}
                        value="First" 
                        onClick={(event)=>this.paginationFirstButtonClicked(event,tableSize)}>First</button></span>
               <span> <button  disabled={disableAllPButtons ? true :this.state.previousButtonDisabled}
                    value="Previous" 
                            onClick={(event)=>this.paginationPreviousButtonClicked(event,tableSize)}>Previous</button></span>
               <span> <button  disabled={disableAllPButtons ? true :this.state.nextButtonDisabled}
                    value="Next" 
                            onClick={(event)=>this.paginationNextButtonClicked(event,itemsLength,tableSize)}>Next</button></span>
               <span> <button  disabled={disableAllPButtons ? true :this.state.lastButtonDisabled}
                    value="Last" 
                            onClick={(event)=>this.paginationLastButtonClicked(event,itemsLength,tableSize)}>Last</button></span>

            </div>
            </div>
        )
    }
}
const mapPropsToState = state => {
    return{
        orders:state.orderReducer.orderDetails,
        // username:state.validation.userNameCurrent
    }

}
const mapDispatchToProps = dispatch => {
    return{
        orderDetails:(username)=>dispatch(actionCreators.getOrdersDetails(username)),
        // clickOnPayment:(username,itemName)=>dispatch(actionCreators.doPayment(username,itemName))
        loginError:(message)=>dispatch(actionCreators.loginErrorDisplay(message))

    }
}
export default connect(mapPropsToState,mapDispatchToProps)(withRouter(Orders));
