import React,{Component} from "react";
import "./App.css";
import {Route, Switch,Redirect } from "react-router-dom";
import Login from "./containers/Login";
import {withRouter} from 'react-router-dom';
import Header from "./components/Header";
import BrowseItems from './containers/BrowseItems/BrowseItems';
import Cart from './containers/Cart/Cart';
import {connect} from 'react-redux'
import Orders from './containers/Order/Orders'
import Operator from './containers/Operator/Operator'
import Logout from './containers/Logout';

class App extends Component {
  render(){
    console.log(this.props)
    const username = localStorage.getItem('username')
    
  return (  
    <div className="container">
      <div>
       {this.props.loginAs==='operator' && username!==null ? <div><Header/>
       <Switch>
        <Route path="/Operator" exact>
                <Operator/>
        </Route>
        <Route path="/logout" exact>
              <Logout />
        </Route>
      </Switch>
           </div>:
       <div>
       <Header />
        
        <Switch>
         {/* <Route path="/logout11" exact>
              {console.log('Clicked on Logout')}
              {localStorage.removeItem('username')}
                <Login/>
           </Route> */}
          <Route path="/login" exact>
          
            <Login />
          </Route>
          <Route path="/logout" exact>
            <Logout />
            {/* {this.props.history.push('/login')} */}
          </Route>
          <Route path="/BrowseItems" exact>
           <BrowseItems/>
          </Route>
          <Route path="/Cart" exact>
            <Cart/>
          </Route>
          <Route path="/Orders" exact>
            <Orders/>
          </Route>
          {/* <Route path="/Operator" exact>
           
          </Route> */}
          {/* <Route path="/logout" exact>
              {console.log('Clicked on Logout')}
              {localStorage.removeItem('username')}
                <Login/>
           </Route> */}
          <Redirect to='/login'></Redirect>
        </Switch>
       </div>
       
       }
        
      </div>
    </div>
  );
  }
}
const mapStateToProps = state => {
  return{
    loginAs:state.validation.loginAs
  }
  
}

export default connect(mapStateToProps)(withRouter(App));
