import * as actionTypes from './actions';

const intialState={
    orderDetails:[],
    

}

const orderReducer = (state=intialState,action) => {

    console.log('entered into ORDERREDUCER....')
    console.log(action.userName)
    console.log(action.type)
    console.log(action.orderDetails)
    let dupOrderDetails=[]
    if(typeof action.orderDetails!=='undefined'){
        dupOrderDetails = Object.keys(action.orderDetails)
            .filter(key=>{
               return action.orderDetails[key].userName===action.userName && 
                        action.orderDetails[key].payment===1
            }).map(key=>{
                return {[key]:action.orderDetails[key]}
            })
        console.log('duplicateCartDetails are : ',dupOrderDetails)
    }

    //     // dupCartDetails=Object.values(action.cartDetails)
    //     dupCartDetails=Object.keys(action.cartDetails).filter(key=>{
    //         console.log('inside dupCartDetails',action.cartDetails[key].userName,action.userName)
    //         return action.cartDetails[key].userName===action.userName
    //     }).map(key=>{
    //         return {[key]:action.cartDetails[key]}
    //     })
    //     console.log('duplicateCartDetails are : ',dupCartDetails)
    // }
   
    switch(action.type){
        case actionTypes.ORDER_DETAILS:
            return{
                ...state,
                orderDetails:dupOrderDetails

            }
        default:
            return state
    }
}

export default orderReducer;