import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "./index.css";
import App from "./App";
import { createStore,applyMiddleware,compose, combineReducers } from "redux";
// import { createStore} from "redux";
import { Provider } from "react-redux";
import * as serviceWorker from "./serviceWorker";
import reducers from "./containers/store/reducers";
import reducerBrowseItems from './containers/store/reducerBrowseItems';
import reducerUsers from './containers/store/reducerUserValidation';
import thunk from 'redux-thunk'; 
import cartReducer from './containers/store/cartReducer';
import reducerOrders from './containers/store/orderReducer';

const logger = (store) => {
  return next => {
    return action =>{
      console.log('[Middleware] Dispatching',action);
      const result=next(action);
      console.log('[Middleware] next state ',store.getState());
      return result;
    }
  }
}

const componseEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const rootReducer= combineReducers({
  validation:reducers,
  itemsReducerName:reducerBrowseItems,
  userReducer:reducerUsers,
  ReducerCart:cartReducer,
  orderReducer:reducerOrders
})

const store = createStore(rootReducer,componseEnhancers(applyMiddleware(logger,thunk))) ;
// const store = createStore(reducers) ;


ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter>
      <App/>
    </BrowserRouter>
  </Provider>,
  document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();