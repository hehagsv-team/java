// import * as actionTypes from './store/actions';
import axios from '../../axios-shct';
export const HANDLEUSERNAME="HANDLEUSERNAME";
export const HANDLEPASSWORD="HANDLEPASSWORD";
export const SET_ITEMS="SET_TEMS";
export const FETCHITEMSFAILED="FETCHITEMSFAILED";
export const FETCH_USER_DETAILS='FETCH_USER_DETAILS';
export const CURRENT_USERNAME="CURRENT_USERNAME";
export const ADD_TO_CART_SUCCESS="ADD_TO_CART_SUCCESS";
export const GET_CART_DETAILS="GET_CART_DETAILS";
export const ORDER_DETAILS="ORDER_DETAILS";
export const LOGIN_ERROR_MESSAGE="LOGIN_ERROR_MESSAGE";
export const PAGE_SELECTED="PAGE_SELECTED";
export const LOGIN_AS="LOGIN_AS"

export const handleuser = (event) => {
    return{
        type:HANDLEUSERNAME,
        event:event
    }
}

export const handleusername = (value) => {
   return dispatch => {
       setTimeout(() => {
           dispatch(handleuser(value))
       }, 2000);
   }
    
}

export const handlepassword=(event)=>{
    return{
        type:HANDLEPASSWORD,
        event:event
    }
}
export const handlePassword = (value) => {
    return dispatch => {
        setTimeout(() => {
            dispatch(handlepassword(value))
        }, 2000);
    }
}

export const setItems = (items) => {
    return{
        type:SET_ITEMS,
        items:items
        
    }
}


export const setItemsFailed = () => {
    return {
        type:FETCHITEMSFAILED
    };
};
export const initItems = () => {
    return dispatch => {
        axios.get('https://react-my-burger-6ce77.firebaseio.com/items.json')
        .then(response=>{
            dispatch(setItems(response.data));
        })
        // .catch(error=>{
        //     dispatch(setItemsFailed())
        // })
    }
}

export const fetchDetails = (users) => {
    return{
        type:FETCH_USER_DETAILS,
        users:users
    }
}


export const fetchuserdetails = () => {
    return dispatch => {
        axios.get('https://react-my-burger-6ce77.firebaseio.com/users.json')
        .then(response=>{
            dispatch(fetchDetails(response.data))
        })
    }
}

export const currentUserName = (username) => {

    return{
        type:CURRENT_USERNAME,
        userName:username

    }
}
export const AddToCartSuccess = (response) => {
    return{
        type:ADD_TO_CART_SUCCESS,
        response:response
        
    }

}

export const addToCart = (cartItems) => {
    console.log("entered into addToCart action page .................")
    console.log(cartItems)
    return (
    // dispatch=>{
        axios.post('/orders.json',cartItems)
            .then(response=>{
                console.log('response is :......',response.data)
                // dispatch(AddToCartSuccess(response.data))
            } )
            .catch(error =>{
                console.log('error while storing data is : ',error)
            })
    // }
    )}

    export const cartDetails = (details,username) => {
        return{
            type:GET_CART_DETAILS,
            cartDetails:details,
            userName:username
        }

    }

    export const getCartDetails = (username) => {
        console.log('entered into getCartDetails actions')
        return dispatch => {
            axios.get('https://react-my-burger-6ce77.firebaseio.com/orders.json')
            .then(response=>{
                console.log(response.data)
                dispatch(cartDetails(response.data,username))
            })
        }
    }



    export const orderDetails =(response,username) => {
        return{
            type:ORDER_DETAILS,
            orderDetails:response,
            userName:username
        }
    }
    export const getOrdersDetails = (username) => {
        console.log('entered into getOrdersDetails actions')
        return dispatch => {
            axios.get('https://react-my-burger-6ce77.firebaseio.com/orders.json')
            .then(response=>{
                console.log(response.data)
                dispatch(orderDetails(response.data,username))
            })
        }
    }

export const doPayment = (orderId) => {
    console.log('entered into doPayment action')
    console.log(orderId)
    return dispatch => {
        axios.put('https://react-my-burger-6ce77.firebaseio.com/orders/'+orderId+'/payment.json',1)
        .then(response=>{
            console.log('response insdie DOPAYMENT is : ',response.data)
        }).catch(error=>console.log('errro in updating payment is : ',error))
    }

    // quantityUpdate
}

export const quantityUpdate = (orderId,quantity) => {
    console.log('entered into quantityUpdate action')
    console.log(orderId,quantity)
    return dispatch => {
        axios.put('https://react-my-burger-6ce77.firebaseio.com/orders/'+orderId+'/quantity.json',quantity)
        .then(response=>{
            console.log('response insdie DOPAYMENT is : ',response.data)
        }).catch(error=>console.log('errro in quantityUpdate payment is : ',error))
    }

    // shippingUpdate
}

export const shippingUpdate = (orderId) => {
    console.log('entered into quantityUpdate action')
    console.log(orderId)
    let shipped="shipped"
    return dispatch => {
        axios.put('https://react-my-burger-6ce77.firebaseio.com/orders/'+orderId+'/shippingStatus.json',1)
        .then(response=>{
            console.log('response insdie shippingUpdate is : ',response.data)
        }).catch(error=>console.log('errro in shipppingUpdate payment is : ',error))
    }

    // shippingUpdate
}


export const loginErrorDisplay = (message) => {
    console.log('entered into loginErrorDisplay')
    return {
        type:LOGIN_ERROR_MESSAGE,
        errorMessage:message,
        // redirectMessage:redirect


    }

}

export const loginClicked = (click) => {
    console.log('entered into loginClicked')
    return {
        type:PAGE_SELECTED,
        pageSelected:click


    }

}

export const loginAs = (loginAs) =>{
    return{
        type:LOGIN_AS,
        loggedInAs:loginAs
    }

}

export const updationByOperator = (orderId,shippingUpdate) =>{
    console.log('entered into updationByOperator action')
    console.log(orderId,shippingUpdate)
    let status=1
    if(shippingUpdate==='S'){
        console.log('S: entered')
        status=1
    }
    else if(shippingUpdate==='T'){
        console.log('T: entered')
        status=2
    }
    
    else if(shippingUpdate==='D'){
        console.log('D: entered')
        status=3
    }
    else if(shippingUpdate==='R'){
        console.log('R: entered')
        status=4
    }
    return dispatch => {
        axios.put('https://react-my-burger-6ce77.firebaseio.com/orders/'+orderId+'/shippingStatus.json',status)
        .then(response=>{
            console.log('response insdie updationByOperator is : ',response.data)
        }).catch(error=>console.log('errro in updationByOperator  is : ',error))
    }
}

// export const operatorDetails = (response,operatorName) => {
//     return{
//         type:GET_OPERATOR_DETAILS,
//         response:response,
//         operatorName:operatorName
//     }
// }

// export const getOperatorDetails = (operatorName) => {
//     console.log('entered into getOperatorDetails actions')
//     return dispatch => {
//         axios.get('https://react-my-burger-6ce77.firebaseio.com/orders.json')
//         .then(response=>{
//             console.log(response.data)
//             dispatch(operatorDetails(response.data,operatorName))
//         })
//     }
// }



