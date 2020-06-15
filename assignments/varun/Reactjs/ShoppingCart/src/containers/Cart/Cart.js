import React, { Component } from 'react';
import {connect} from 'react-redux';
import {withRouter} from 'react-router-dom';
// import { register } from '../../serviceWorker';
import * as actionCreators from '../store/actions';
import Spinner from '../../UI/Spinner';

import './Cart.css';

class Cart extends Component {

    state={
        username:'',
        checkedValue:false,
        paginationButtonCliked:false,
        paymentButtonDisabled:true,
        itemSelectedForPayment:"",
        firstButtonDisabled:false,
        previousButtonDisabled:true,
        nextButtonDisabled:false,
        lastButtonDisabled:false,
        quantityValue:'',
        paginationButton:'',
        tableStart:0,
        componentRender:false,
        tableSize:0,
        // QuantityFieldDisabled:true,
        rdButtonValue:{
            values:{
                value:"",
                id:""
            
            }
        }
    }
    componentDidMount(){
      
        console.log('[Cart] componentDidMount')
        this.props.getCartDetails(this.state.username)
        console.log('cartdetails values are : ',this.props.cartDetails)
        if(this.props.cartDetails.length===0){
            this.setState({componentRender:true})
        }
        // console.log('componentDidMount props are',this.props.cartDetails)
        
    }
    // componentWillUpdate(){
    //     console.log('componentWillUpdate props are',this.props.cartDetails)
    // }
    // componentWillReceiveProps(newProps){
    //     console.log('componentWillReceiveProps props are',this.props.cartDetails)
    // }
    // shouldComponentUpdate(){
    //     console.log('shouldComponentUpdate props are',this.props.cartDetails)
    //     const length=this.props.cartDetails.length;
    //     if(length<=this.state.tableSize){
    //         this.setState({
    //             firstButtonDisabled:true,
    //             previousButtonDisabled:true,
    //             nextButtonDisabled:true,
    //             lastButtonDisabled:true})
    //     }
    //     return false

    // }
    componentWillMount(){
        console.log('[CART] componentWillMount')
          const username = localStorage.getItem('username')
        console.log('[CART] page username is : ',username)
        this.setState({username:username})
        // console.log('[CART] page username is : ', username)
        if(username==="" || username === null)
        {
            console.log('[CART] PLEASE LOGIN')
            const cartPageMessage='Please Login For Cart Page'
            // const redirected=true
            this.props.loginError(cartPageMessage)
            this.props.history.push('/login')
        }
        // console.log('[CART] componentWillMount',this.props.cartDetails)
        // const length=this.props.cartDetails.length
        // console.log('[CART] componentWillMount length is ',length)
    }
    componentDidUpdate(){
        console.log('[Cart] componentDidUpdate')
        console.log("QuantityValue is",this.state.quantityValue)
        console.log('itemSelectedForPayment',this.state.itemSelectedForPayment)
        console.log('paginationButton from state is : ',this.state.paginationButton)
        console.log('tabelStart updated is : ',this.state.tableStart)
    }
    cartRdButtonHandler = (event) => {
        this.setState({paymentButtonDisabled:false,QuantityFieldDisabled:false,
            paginationButtonCliked:false,
            itemSelectedForPayment:event.target.value})
        
    }

    rdButtonValues = (idValue) => {
        console.log("ENTERED INTO rdButtonValues")
        console.log(idValue)

        // this.setState(prevState => ({
        //     rdButtonValue:{
        //         ...prevState.rdButtonValue,
        //         value:idValue,
        //         id:false
        //     }
        // }))
        
    }
    paginationFirstButtonClicked = (event,tableSize) => {
        console.log('insdie paginationFirstButtonClicked',tableSize)
        this.setState({paginationButton:event.target.value,
        tableStart:0,
        previousButtonDisabled:true,
        nextButtonDisabled:false,
        paginationButtonCliked:true})
    }
    paginationLastButtonClicked = (event,itemsLength,tableSize) => {
        this.setState({paginationButton:event.target.value,
        tableStart:itemsLength-tableSize,
        previousButtonDisabled:false,
        nextButtonDisabled:true,
        paginationButtonCliked:true    })
       

    }
    paginationPreviousButtonClicked = (event,tableSize) => {
        
        // if(this.state.tableStart===1)
        // {
        //     this.setState({paginationButton:event.target.value,
        //         tableStart:this.state.tableStart-1, nextButtonDisabled:false})

        // }
        // else{
        this.setState({paginationButton:event.target.value,
        tableStart:this.state.tableStart-tableSize,nextButtonDisabled:false,
        paginationButtonCliked:true})
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
        previousButtonDisabled:false,
        paginationButtonCliked:true})
        console.log('table start and itemlength is : ',this.state.tableStart,tableSize,itemsLength)
        if(((itemsLength %2 ===0) && ((tableSize+tableSize)===itemsLength))
        || (this.state.tableStart+tableSize+1)===itemsLength){
            this.setState({nextButtonDisabled:true})
        }

        if(this.state.tableStart+tableSize+tableSize===itemsLength){
            this.setState({nextButtonDisabled:true})
        }
   

    }
    
    
    quantityHandler = (event) => {
        this.setState({quantityValue:event.target.value})
        console.log("QUANTITY VALUE IS : ",this.state.quantityValue)
    }

    disableAllButtons = () => {
        console.log('control enter into disableAllButtons')
        this.setState({firstButtonDisabled:true,
                        previousButtonDisabled:true,
                            nextButtonDisabled:true,
                            lastButtonDisabled:true})
    }

    paymentButtoonClicked = (itemName) => {
        console.log("control enter into paymentButtoonClicked ",itemName)
        console.log(this.props.cartDetails)
        const orderId=this.props.cartDetails.map(key=>
                    Object.keys(key).filter(orders=>(key[orders].itemName===itemName)))
        const orderIdCorrect=orderId.join().replace(/,/g,'')
        console.log(orderIdCorrect)
        this.props.clickOnPayment(orderIdCorrect)
        this.props.quantityInsertion(orderIdCorrect,this.state.quantityValue)
        this.props.itemShipped(orderIdCorrect)
    }
    //orders is the key means order Id

    render() {
        console.log('[Cart] render()')
        const tableSize=2
        let disableAllPButtons=false
        console.log(this.props.cartDetails)
        const stringToArray=this.state.itemSelectedForPayment.split(',')
        console.log('stringToArray',stringToArray)
        const [itemName]=stringToArray
        console.log('itemName',itemName)
        console.log('this.props.rdButtonValue',this.props.rdButtonValue)
        console.log('username in cart page is ',this.state.username)
        let itemsInTable=[...this.props.cartDetails]
        
        const itemsLength=itemsInTable.length;
        if(itemsLength<=tableSize){
            disableAllPButtons=true
        }
        if(this.state.paginationButton==='First'){
            console.log('[CART] ENTERED INTO FIRST')
            console.log("length of itemsInTable is : ",itemsInTable.length)
            const firstElement=itemsInTable.slice(this.state.tableStart,
                                    this.state.tableStart+tableSize)
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
        const tableBody=( <table>
            <thead>
                        <tr>
                            <th>select</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/* {itemsInTable.map((item,index)=>
                        <tr id={index}>
                            {/* {const value=[item.itemName,item.orice].join(' ')} */}
                            {/* <td><input type="radio" value={[item.itemName,item.price].join(',')} 
                                    name="rd-button-selection" 
                                    onChange={this.paymentItemSelect}
                                    /></td>
                            <td>{item.itemName}</td>
                            <td>{item.price}</td> */} 
                      
                            {/* {itemsInTable.map(item=>{
                                <td><input type="radio"
                                name="rd-button-selection" />
                               </td>
                                <td>{item.itemName}</td>
                                <td>{item.price}</td>
                                <td></td>
                            })} */}
                            {itemsInTable.map(item=>
                        //     <tr onClick={this.rdButtonValues([Object.values(item).map(key=>key.itemName).join(''),
                        //     Object.values(item).map(key=>key.price).join('')
                        // ].join(','))}>  
                        <tr>   {console.log("came inside the loop........",this.state.checkedValue,
                                                                    this.state.paginationButtonCliked)}
                                {/* {console.log('items in cartTableare: ',item)} */}
                                {/* {console.log('items are object :...',Object.values(item).map(key=>key.userName).join(''))} */}
                                {this.state.paginationButtonCliked ? <td><input 
                                checked={this.state.checkedValue} type="radio" 
                                    name="rd-button-selection-cart"
                    value={[Object.values(item).map(key=>key.itemName).join(''),
                    Object.values(item).map(key=>key.price).join('')
                                     ].join(',')}
                                    onClick={this.cartRdButtonHandler}/>  </td>     : 
                                    <td><input type="radio" 
                                    name="rd-button-selection-cart"
                    value={[Object.values(item).map(key=>key.itemName).join(''),
                    Object.values(item).map(key=>key.price).join('')
                                     ].join(',')}
                                    onClick={this.cartRdButtonHandler}/></td>}
                                {/* <td><input type="radio" value='' 
                                    name="rd-button-selection-cart"
                    value={[Object.values(item).map(key=>key.itemName).join(''),
                    Object.values(item).map(key=>key.price).join('')
                                     ].join(',')}
                                    onClick={this.cartRdButtonHandler}/></td> */}
                                <td>{Object.values(item).map(key=>key.itemName).join('')}</td>
                                <td>{Object.values(item).map(key=>key.price).join('')}</td>
                                <td><input disabled={this.state.QuantityFieldDisabled}
                                 type='numbers' size='3' onChange={this.quantityHandler}/></td>
                        </tr>
                            )}
                        
                        
                            
                        
                        
                    </tbody>
                </table> )
        return (
            <div>
             {/* {itemsInTable.length<=tableSize ? this.disableAllButtons : null}
                         {console.log('itemsinTAble are length is ',itemsInTable.length,tableSize)} */}

            <div className='tableName'>Cart</div>
            <div className='cartTable'>
                  <div className='PaymentButton'>
                    
                    <button disabled={this.state.paymentButtonDisabled}
                    onClick={()=>this.paymentButtoonClicked(itemName)}>Payment</button>

                     {/* onClick={()=>this.props.clickOnPayment(this.state.username,itemName)}>Payment</button> */}

                </div>
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
        cartDetails:state.ReducerCart.cartDetails,
        // username:state.validation.userNameCurrent
    }

}
const mapDispatchToProps = dispatch => {
    return{
        getCartDetails:(username)=>dispatch(actionCreators.getCartDetails(username)),
        clickOnPayment:(orderIdCorrect)=>dispatch(actionCreators.doPayment(orderIdCorrect)),
        loginError:(message)=>dispatch(actionCreators.loginErrorDisplay(message)),
        quantityInsertion:(orderId,quantity)=>dispatch(actionCreators.quantityUpdate(orderId,quantity)),
        itemShipped:(orderId)=>dispatch(actionCreators.shippingUpdate(orderId))
    }
}
export default connect(mapPropsToState,mapDispatchToProps)(withRouter(Cart));
