import * as actionTypes from './actions';

const initialState={
    users:{
        username:"rajiv",
        password:"sanket"
    },
    loginButton:true,
    userNameCurrent:'',
    loginMessageError:'',
    // redirect:false,
    pageSelected:'',
    loginAs:''
};

const reducers = (state=initialState,action) => {
    console.log(action.type)
    console.log("users are")
    console.log(state)
    switch(action.type){
        
        case actionTypes.HANDLEUSERNAME:
            // const eventh=action.event;
            return{
               
               ...state,
               users:{
                   ...state.users,
                   username:action.event,
               },
               loginButton:false,
               
            
              
            }

        case actionTypes.HANDLEPASSWORD:
                // const eventh=action.event;
                return{
                   
                   ...state,
                   users:{
                       ...state.users,
                       password:action.event
                    
                   },
                   loginButton:false
                  
                }

            case actionTypes.CURRENT_USERNAME:
                return{
                    ...state,
                    userNameCurrent:action.userName
                }

            case actionTypes.ADD_TO_CART_SUCCESS:
                return{
                    ...state
                }
            case actionTypes.LOGIN_ERROR_MESSAGE:
                return{
                    ...state,
                    loginMessageError:action.errorMessage,
                    // redirect:action.redirectMessage
                }

            case actionTypes.PAGE_SELECTED:
                return{
                    ...state,
                    pageSelected:action.pageSelected
                }
            case actionTypes.LOGIN_AS:
                return{
                    ...state,
                    loginAs:action.loggedInAs
                }
        default:
            return state
    }


}

export default reducers;