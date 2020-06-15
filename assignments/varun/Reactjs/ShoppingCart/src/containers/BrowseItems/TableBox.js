import React, { Component } from 'react';
import {connect} from 'react-redux';
// import {connect} from 'react-redux';
import * as actionCreators from '../store/actions';
import Spinner from '../../UI//Spinner';
import './TableBox.css';


export class TableBox extends Component {
   state={
    checkedValue:false,
       paginationButtonClicked:false,
            selectedItemToCartPage:'',
            paymentButtonDisabled:true,
            loggedIn:true, 
            usernameFromStorage:'',
            disableAllButtons:false,
            firstButtonDisabled:false,
            previousButtonDisabled:true,
            nextButtonDisabled:false,
            lastButtonDisabled:false,
            tableStart:0,
            dupButtonClicked:[],
            // checkingWorkOrNot:'',
            tableSize:2,
            itemAlreadyThere:false
    
    
        }
        
    
  

    // componentDidUpdate(){
    //     console.log("[TableBox] component Updated")
    //     console.log(this.state.selectedItemToCartPage)
    //     console.log('[TableBox] componentDidUpdate')
    //     console.log('items are : ',this.props.items)
    //     const itemsAre=[...this.props.items]
    //     if(itemsAre.length<=2){
    //         console.log('DISABLED ALL PAGINATION BUTTONS.............!!')
    //     }
        // const buttonClickDup=[...this.props.rdButtonClicked]
        // console.log('buttonClicked is',buttonClickDup.join(''))
        // const afterJoin=buttonClickDup.join('')
        // // this.setState({dupButtonClicked:buttonClickDup})
        // // this.setState({dupButtonClicked:this.props.rdButtonClicked})
        // let a=this.state.dupButtonClicked.slice()
        // console.log('value of a is ',a)
        // a[0]=afterJoin
        // console.log('value of a[0] is 0',a)
        // this.setState({dupButtonClicked:a})
        // componentWillUpdate(){
        //     console.log('[TableBox] componentWillMount')
        //     console.log('currentUsername is : ',this.props.currentUserName)
        //     // this.props.getCartDetails(this.props.currentUserName)
        // }
        componentWillReceiveProps(newProps) {
            console.log('[TableBox] componentWillReceiveProps')
            console.log(this.props.itemsInTable)
            console.log(newProps.itemsInTable)
            if(this.props.itemsInTable !== newProps.itemsInTable){
                console.log('DROPDOWN NOT CHANGED.........')
                this.setState({tableStart:0,
                    firstButtonDisabled:false,
                    previousButtonDisabled:true,
                    nextButtonDisabled:false,
                    lastButtonDisabled:false})
            }
            const dup=newProps.itemsInTable.length
            console.log('dup value is : ',dup)
            if(dup<=this.state.tableSize){
                this.setState({firstButtonDisabled:true,
                    previousButtonDisabled:true,
                    nextButtonDisabled:true,
                    lastButtonDisabled:true})
            }
            

            // const prevManu=this.props.itemsInTable.map(itemsIn=>{
            //     Object.keys(itemsIn).filter(key=>key==='ManufacturerName')
            //                 .map(key=>itemsIn[key])
            // })
            // const currentManu=newProps.itemsInTable.map(itemsIn=>{
            //     Object.keys(itemsIn).filter(key=>key==='ManufacturerName')
            //                 .map(key=>itemsIn[key])
            // })
            // console.log('componentWillReceiveProps newProps and this.props are',prevManu,currentManu)
            // if( newProps.profileImage != this.props.profileImage ) {
            // //   /* do stuff */
            // }
          }
    // }
    // shouldComponentUpdate(nextProps, nextState){
    //     componentWillUpdate(){
    //     console.log('[TableBox] componentWillUpdate')
    //     const buttonClickDup=[...this.props.rdButtonClicked]
    //     console.log('buttonClicked is',buttonClickDup.join(''))
    //     console.log('items are : ',this.props.rdButtonClicked)
    //     const afterJoin=buttonClickDup.join('')
    //     let a=this.state.dupButtonClicked.slice()
    //     console.log('value of a is ',a)
    //     a[0]=afterJoin
    //     console.log('value of a[0] is 0',a)
    //     return true;
    // }
    
    paymentItemSelect = (event) => {
        
        this.setState({selectedItemToCartPage:event.target.value,paymentButtonDisabled:false,
                                    itemAlreadyThere:false,
                                paginationButtonClicked:false})
        // this.props.getCartDetails(this.props.currentUserName)

    }
    componentWillMount(){
        console.log('[TableBox] componentWillMount')
        const username=localStorage.getItem('username')
        this.setState({usernameFromStorage:username})
        
    }
    paginationFirstButtonClicked = (event,tableSize) => {
        console.log('insdie paginationFirstButtonClicked',tableSize)
        this.setState({paginationButton:event.target.value,
        tableStart:0,
        previousButtonDisabled:true,
        nextButtonDisabled:false,
        paginationButtonClicked:true})
      

    }
    paginationLastButtonClicked = (event,itemsLength,tableSize) => {
        this.setState({paginationButton:event.target.value,
        tableStart:itemsLength-tableSize,
        previousButtonDisabled:false,
        nextButtonDisabled:true,
        paginationButtonClicked:true    })
       

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
        paginationButtonClicked:true})
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
        paginationButtonClicked:true})
       
        console.log('table start and itemlength is : ',this.state.tableStart,tableSize,itemsLength)
        if(((itemsLength %2 ===0) && ((tableSize+tableSize)===itemsLength))
        || (this.state.tableStart+tableSize+1)===itemsLength){
            this.setState({nextButtonDisabled:true})
        }

        if(this.state.tableStart+tableSize+tableSize===itemsLength){
            this.setState({nextButtonDisabled:true})
        }
   

    }

   
    
    addToCartButtonClicked = (addToCartItems) => {
        const username = localStorage.getItem('username')
        console.log('[CART] page username is : ',username)
        this.setState({username:username})
        if(username !== '' && username!=null){
            console.log('[TableBox] addToCartButtonClicked',this.props.cartDetails)
            const detailsOfCart=[...this.props.cartDetails]
            const itemsNamesInCart=detailsOfCart.map(item=> Object.values(item).map(key=>
                Object.keys(key).filter(key=>key==='itemName').map(keyI=>key[keyI]))).join()
            console.log('itemsNamesInCart',itemsNamesInCart)
            console.log('addToCartItems',addToCartItems)
            const itemToBeAdded=Object.keys(addToCartItems).filter(key=>key==='itemName')
                                .map(item=>addToCartItems[item]).join()
            console.log('itemToBeAdded',itemToBeAdded)
            if(!itemsNamesInCart.includes(itemToBeAdded)){
                this.props.addToCart(addToCartItems)
            }
            else{
                this.setState({itemAlreadyThere:true})
                console.log('item already in cart page..........')
            }
            // this.props.addToCart(addToCartItems)
        }
        else{
            this.setState({loggedIn:false})
            console.log('PLEASE LOGIN FOR ADDING ITEMS TO CART')
        }
       
    }
    render() {
        console.log('[TableBox] render() disableAllPButtons: ',this.props.cartDetails)
        console.log(this.props)
        const tableSize=2
        // console.log('radioButtonBalue is ',this.props.rdButtonClicked)
        // console.log(this.props.items)
        var itemsAndPrice =this.state.selectedItemToCartPage;
        var convertItemsAndPriceToArray=itemsAndPrice.split(',')
        const [itemName,itemPrice]=convertItemsAndPriceToArray;
        console.log('after converting string to array then...',itemName,itemPrice)
        // console.log('selected item to cart page is ..',split)
        console.log('[TableBox] this.props are : ',this.props)
        const addToCartItems={
                userName:this.state.usernameFromStorage,
                orderedDate:this.props.currentDate,
                itemName:itemName,
                price:itemPrice,
                payment:0,
                quantity:0,
                shippingStatus:'AddToCart'
            }       
        console.log('items to be added in cart are : ',addToCartItems)
        console.log('radioButtonBalue is ',typeof this.props.items)
        console.log(this.props.items,this.props.rdButtonClicked,this.props.dropDown)
        // let this.props.itemsInTable=Object.keys(this.props.items)
        //     .map(key=>{
        //         return {[key]:this.props.items[key]}
        //     });
        // console.log('after converting',this.props.itemsInTable)
       
        // else{
        //     // const spinner= <Spinner/>
        //     // this.props.itemsInTable=[]
        //     this.props.itemsInTable=[...this.props.items]
        // }
        


        
       
        const itemsLength=this.props.itemsInTable.length;
        let itemsInTable=[...this.props.itemsInTable]
        if(this.state.paginationButton==='First'){
            console.log('[CART] ENTERED INTO FIRST')
            console.log("length of this.props.itemsInTable is : ",this.props.itemsInTable.length)
            const firstElement=this.props.itemsInTable.slice(this.state.tableStart,this.state.tableStart+2)
            console.log('First button firstElement value is : ',firstElement)
            itemsInTable=firstElement
            // this.updateTableStart(tableSize)
            console.log('[First] tableStart in',this.state.tableStart)
            
        }
        else if(this.state.paginationButton==='Last'){
            console.log('[CART] ENTERED INTO LAST')
            console.log("length of this.props.itemsInTable is : ",this.props.itemsInTable.length)
            const LastElement=this.props.itemsInTable.slice(this.props.itemsInTable.length-tableSize,this.props.itemsInTable.length)
            console.log('Last button LastElement value is : ',LastElement)
            itemsInTable=LastElement
            
        }
        else if(this.state.paginationButton==='Previous'){
            console.log('[CART] ENTERED INTO PREVIOUS')
            console.log("length of this.props.itemsInTable is : ",this.props.itemsInTable.length)
            let PreviousElement=[]
            if(this.state.tableStart<0){
                PreviousElement=this.props.itemsInTable.slice(0,
                    1)
            }
            else{
                PreviousElement=this.props.itemsInTable.slice(this.state.tableStart,
                    this.state.tableStart+tableSize)
            }
           
            console.log('Previous button firstElement value is : ',PreviousElement)
           itemsInTable=PreviousElement
            // this.updateTableStart(tableSize)
            console.log('[Previous] tableStart in',this.state.tableStart)
            
        }
        else if(this.state.paginationButton==='Next'){
            console.log('[CART] ENTERED INTO NEXT')
            console.log("length of this.props.itemsInTable is : ",this.props.itemsInTable.length)
            const nextElement=this.props.itemsInTable.slice(this.state.tableStart,
                                                    this.state.tableStart+tableSize)
            console.log('Previous button firstElement value is : ',nextElement)
           itemsInTable=nextElement
            // this.updateTableStart(tableSize)
            console.log('[Next] tableStart in',this.state.tableStart)
            
        }
        else{
           itemsInTable=this.props.itemsInTable.slice(this.state.tableStart,this.state.tableStart+tableSize)
        }

        const tableBody=(
            <table>
            <thead>
                        <tr>
                            <th>select</th>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        {itemsInTable.map((item,index)=>
                        <tr id={index}>
                            {/* {const value=[item.itemName,item.orice].join(' ')} */}
                            {this.state.paginationButtonClicked ? <td><input type="radio" checked={this.state.checkedValue} value={[item.itemName,item.price].join(',')} 
                                    name="rd-button-selection" 
                                    onChange={this.paymentItemSelect}
                                    /></td>              : 
                                     <td><input type="radio" value={[item.itemName,item.price].join(',')} 
                                    name="rd-button-selection" 
                                    onChange={this.paymentItemSelect}
                                    /></td>}
                            {/* <td><input type="radio" value={[item.itemName,item.price].join(',')} 
                                    name="rd-button-selection" 
                                    onChange={this.paymentItemSelect}
                                    /></td> */}
                            <td>{item.itemName}</td>
                            <td>{item.price}</td>
                            
                        </tr>
                            
                            )}
                        {/* <tr>
                            <td> <input type="radio" name="rd-button-selection" /></td>
                            <td>Red Mi Note 6</td>
                            <td>15,500</td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="rd-button-selection" /></td>
                            <td>Red Mi Note 4</td>
                            <td>9,500</td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="rd-button-selection" /></td>
                            <td>Red Mi Note 5</td>
                            <td>9,500</td>
                        </tr> */}
                    </tbody>
                </table>
        )
        return (
            <div>
            {/* {this.disableAllPaginationButtons(lengthOfItems,tableSize)} */}
            <div className="table-box">
                <div className="Payment-button">
                {/* {this.props.itemsInTable.length<=tableSize ?
                        this.disableAllPaginationButtons : null
                    } */}{this.state.itemAlreadyThere ? <div className="item-already">Item Already in cart</div> : null}
                    <button disabled={this.state.paymentButtonDisabled}
                    // onClick={()=>this.props.addToCart(addToCartItems)}>addToCart</button>
                    onClick={()=>this.addToCartButtonClicked(addToCartItems)}>Add To Cart</button>

                </div>
                {this.props.itemsInTable.length>0 ?  tableBody:<Spinner/>}
                {!this.state.loggedIn ?<h2 className='error'>Please Login</h2>:null}
                {/* {tableBody} */}
            
            </div>
             <div className='paginationBrowse'>
                <span> <button disabled={this.props.disableAllPButtons ? 
                                                true:this.state.firstButtonDisabled}
                         value="First" 
                         onClick={(event)=>this.paginationFirstButtonClicked(event,tableSize)}>First</button></span>
                <span> <button  disabled={this.props.disableAllPButtons ? 
                                                true:this.state.previousButtonDisabled}
                     value="Previous" 
                             onClick={(event)=>this.paginationPreviousButtonClicked(event,tableSize)}>Previous</button></span>
                <span> <button  disabled={this.props.disableAllPButtons ? 
                                                true:this.state.nextButtonDisabled}
                     value="Next" 
                             onClick={(event)=>this.paginationNextButtonClicked(event,itemsLength,tableSize)}>Next</button></span>
                <span> <button  disabled={this.props.disableAllPButtons ? 
                                                true:this.state.lastButtonDisabled}
                     value="Last" 
                             onClick={(event)=>this.paginationLastButtonClicked(event,itemsLength,tableSize)}>Last</button></span>
 
             </div>
             </div>
        )
    }
}

const mapPropsToState = (state) => {
    return {
        cartDetails:state.ReducerCart.cartDetails,
    }
}

const mapDispatchToProps = (dispatch) => {
    return{
        addToCart:(addToCartItems)=> (actionCreators.addToCart(addToCartItems)),
        getCartDetails:(username)=>dispatch(actionCreators.getCartDetails(username)),

    }
}

// export default connect(mapPropsToState)(TableBox);
export default connect(mapPropsToState,mapDispatchToProps)(TableBox);

