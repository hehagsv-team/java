import * as actionTypes from './actions';

const initialState={
  items:[]
      
  }


  const reducerBrowseItems = (state=initialState,action) => {
    console.log('entered into reducerBrowserItems......')
    console.log(action.type)
    console.log(typeof action.items)
    let dupArray=[];
    if(typeof action.items !=='undefined'){
        dupArray=Object.values(action.items)
        console.log('dupArray')
        console.log(dupArray)
        console.log(typeof dupArray)
    }
   
    switch(action.type){
        case actionTypes.SET_ITEMS:
            return {
                ...state,
                items:dupArray
                
            }

        case actionTypes.FETCHITEMSFAILED:
            return state
        default:
            return state
        
    }

    
    // axios.get('https://react-my-burger-6ce77.firebaseio.com/items.json')
    //     .then(response=>{
    //         dispatch(setItems(response.data));
    //     })
    //     .catch(error=>{
    //         dispatch(setItemsFailed())
    //     })
    // return {
    //     ...state
    // }

  }

  export default reducerBrowseItems;