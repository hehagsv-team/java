import * as actionTypes from './actions';

const intialState={
    cartDetails:[],
    

}

const cartReducer = (state=intialState,action) => {

    console.log('entered into CARTREDUCER....')
    console.log(action.userName)
    console.log(action.type)
    console.log(action.cartDetails)
    let dupCartDetails=[]
    if(typeof action.cartDetails!=='undefined' && action.cartDetails !== null){
        // dupCartDetails=Object.values(action.cartDetails)
        dupCartDetails=Object.keys(action.cartDetails).filter(key=>{
            console.log('inside dupCartDetails',action.cartDetails[key].userName,action.userName)
            return action.cartDetails[key].userName===action.userName &&
                    action.cartDetails[key].payment===0
        }).map(key=>{
            return {[key]:action.cartDetails[key]}
        })
        console.log('duplicateCartDetails are : ',dupCartDetails)
    }
   
    switch(action.type){
        case actionTypes.GET_CART_DETAILS:
            return{
                ...state,
                cartDetails:dupCartDetails

            }
        default:
            return state
    }
}

export default cartReducer;