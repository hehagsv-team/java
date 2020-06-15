import * as actionTypes from './actions';
const initialState={
    users:[]
        
}

const reducerUserValidation = (state=initialState,action) => {
    console.log('entered int reducerUserValidation');
    console.log(action.type)
    console.log(action.users)
    switch(action.type){
        case actionTypes.FETCH_USER_DETAILS:
            return{
                ...state,
                users:action.users
            }
        default:
            return state;
    }

}

export default reducerUserValidation;