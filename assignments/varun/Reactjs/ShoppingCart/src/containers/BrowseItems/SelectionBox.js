import React, { Component } from 'react';
import './selectionBox.css';
import TableBox from './TableBox';
import {connect} from 'react-redux';
import * as actions from '../store/actions';
// import { Filter } from './Filter';

export class SelectionBox extends Component {
    state = {
             
        currentDate:'',
        radioButton:"",
        dropDownValue:"",
        minValue:'',
        maxValue:'',
        disableDropDownMenu:true,
        disableMinTextBox:true,
        disableMaxTextBox:true,
        checkedAll:true,
        checkedLBM:false,
        checkedLBP:false,
        tableStart:0
        
    }

    componentWillMount(){
        console.log("[SelectionBox] componentWilldMount")
        console.log("throwing constrol to dispatch props...")
       this.props.itemsShow();
       this.props.getCartDetails(this.props.username)
       var today=new Date()
       var date=today.getDate() + '-' + (today.getMonth() +1) +'-'+today.getFullYear();
       console.log('current date is : ',date);
       this.setState({currentDate:date})
    //    console.log("props.items are")
    //    console.log(this.props.items)

    }

   componentDidUpdate(){

       console.log("[SelectionBox] component did mount")
          console.log(this.props.items)
          console.log('username from redux is : ', this.props.username)
    //    console.log(this.state.radioButton)
    //    console.log(this.state.dropDownValue)
    //    console.log(this.state.minValue)
    //    console.log(this.state.maxValue)
       

   }
   dropDownHandler= (event,tableSize) =>{
       console.log('entered into dropDownHandler')
    //    this.setState({dropDownValue:event.target.value})
       this.setState({dropDownValue:event.target.value,disableAll:false})
        console.log('[dropDownHandler]items are ',this.props.items)
       let itemsIn=[...this.props.items]
       const dropDownDup=event.target.value
       console.log("[itemsRestricted] DROPDOWNVALUE",dropDownDup)
       const itemsRestricted=itemsIn.filter(item=>
           item.ManufacturerName===dropDownDup)
       console.log("[dropDownHandler] itemsRestricted is : ",itemsRestricted)
       itemsIn=itemsRestricted
       const filterLength=itemsIn.length
       console.log('[dropDownHandler] filterLength in dropDownHandler!!!!1: ',filterLength)
       if(filterLength<tableSize){
        this.setState({disableAll:true})
    }
    else{
        this.setState({disableAll:false})

    }
   }

    radioButtonHandlerAll = (event) => {
        console.log("entered into radioButton...")
        this.setState({
            disableDropDownMenu:true,
            disableMaxTextBox:true,
            disableMinTextBox:true,
            checkedLBP:false,
            checkedAll:true,
            checkedLBM:false,
            radioButton:event.currentTarget.value,
            tableStart:0
        })
    }    

    radioButtonHandlerLBM = (event) => {
        console.log("entered into radioButton...")
        this.setState({
            disableDropDownMenu:false,
            disableMaxTextBox:true,
            disableMinTextBox:true,
            checkedLBP:false,
            checkedAll:false,
            checkedLBM:true,
            radioButton:event.currentTarget.value,
            tableStart:0
        })
    }

    radioButtonHandlerLBP = (event) => {
        console.log("entered into radioButton...")
        this.setState({
            disableDropDownMenu:true,
            disableMaxTextBox:false,
            disableMinTextBox:false,
            checkedLBP:true,
            checkedAll:false,
            checkedLBM:false,
            radioButton:event.currentTarget.value,
            tableStart:0
        })
    }

    minchangeHandler = (event) => {
        
        this.setState({minValue:event.target.value})

    }

    maxchangeHandler = (event) => {
        this.setState({maxValue:event.target.value})

    }
    
    render() {
        console.log('[SelectionBox] render()')
        const tableSize=2
        const dupArray=[...this.props.items]
        console.log('[SelectionBox] dupArray render()',dupArray.length)
        const length=dupArray.length


        let itemsInTable=[...this.props.items]
        const lengthOfItems=itemsInTable.length
        console.log('itemsInTable are : ',itemsInTable)
        // const dropDownSelectedValue=this.props.dropDown;
        // const min=this.props.min
        // let error=''
        // const max=this.props.max
        // console.log('MIN and MAX value are : ',min,max)
        // console.log('dropDownValue is ',dropDownSelectedValue)
        if(this.state.radioButton==='All'){
            itemsInTable=[...this.props.items]
            // console.log('[TableBox] if all itemsInTableare : ',itemsInTable)
        }
        else if(this.state.radioButton==='List By Manufacturer' && 
                // (this.props.dropDown !== null && this.props.dropDown !==' ')){
                    (this.state.dropDownValue !== null && this.state.dropDownValue !==' ')){

                    console.log("entered into LIST BY MANUFACTURER........")
                    itemsInTable=[...this.props.items]
                    console.log("[ELSE IF] DROPDOWNVALUE",this.state.dropDownValue)
                    const itemsRestricted=itemsInTable.filter(item=>
                        item.ManufacturerName===this.state.dropDownValue)
                    console.log("itemsRestricted is : ",itemsRestricted)
                    itemsInTable=itemsRestricted
        }
     else if(this.state.radioButton==='List By Price'){
            console.log("ENTERED INTO LIST BY PRICE..........")
            itemsInTable=[...this.props.items]
            const itemsByPrice=itemsInTable.filter(item=>
                item.price >= this.state.minValue && item.price<=this.state.maxValue)
            console.log('itemsbyprice are : ',itemsByPrice)
            itemsInTable=itemsByPrice
        }



        return (
            // <form  onSubmit={this.submitHandler}>
                <div className="select-box">
                    <div className="first-partSelection">
                    <div className="All">
                    <input type="radio" name="rd-button" checked={this.state.checkedAll} 
                    value="All" onChange={this.radioButtonHandlerAll}/>All
                    </div>
                    <div className='LBM'>
                    <input type="radio" name="rd-button" checked={this.state.checkedLBM} 
                    value="List By Manufacturer" onChange={this.radioButtonHandlerLBM}/>List By Manufacturer
                        <span>
                            <select class='dropdown-menu' disabled={this.state.disableDropDownMenu} 
                                            onChange={(event)=>this.dropDownHandler(event,tableSize)}>
                                <option value="Select manufacturer">Select manufacturer</option>
                                <option value="Motrola">Motrola</option>
                                <option value="RedMi">RedMi</option>
                                <option value="Samsung">Samsung</option>
                                <option value="Vivo">Vivo</option>
                                
                            </select></span>
                            </div>

                        <div className='LBP'>
                      
                        <input type="radio" name="rd-button" checked={this.state.checkedLBP} value="List By Price" onChange={this.radioButtonHandlerLBP}/>List By Price
                       
                        <span><label><strong>min:</strong></label><input type="numbers" size="5" 
                                                                        name="min-name" 
                                                                        disabled={this.state.disableMinTextBox}
                                                        onChange={this.minchangeHandler}/></span>
                      <span><label><strong>max:</strong></label><input type="numbers" size="5" 
                                            name="min-name"
                                            onChange={this.maxchangeHandler}
                                            disabled={this.state.disableMinTextBox}/></span>
                        {/* <div className="submit-button">
                            <button type="submit">Submit</button>
                        </div> */}
                 </div>
                    </div>
                    <TableBox items={this.props.items} 
                    disableAllPButtons={this.state.disableAll}
                    currentDate={this.state.currentDate}
                    currentUserName={this.props.username}
                    tableStart={this.state.tableStart}
                    lengthOfItems={length}
                    itemsInTable={itemsInTable}
                    cartDetails={this.props.cartDetails}
                    />
  
                </div> 
                // </form>
            
        )
    }
}

const mapPropsToState = (state) => {
    return {
        items:state.itemsReducerName.items,
        username:state.validation.userNameCurrent,
        cartDetails:state.ReducerCart.cartDetails,

        // rdButtonClicked:ownProps.rdButtonClicked
    }
}
const mapDispatchToProps = (dispatch) => {
    return{
        itemsShow: () => dispatch(actions.initItems()),
        getCartDetails:(username)=>dispatch(actions.getCartDetails(username)),

    }
}

export default connect(mapPropsToState,mapDispatchToProps)(SelectionBox);
