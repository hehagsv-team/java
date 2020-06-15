import React, { Component } from 'react';
import {NavLink } from "react-router-dom";
import {connect} from 'react-redux';
import "./Navbar.css";
import * as actionCreators from '../containers/store/actions';
import DrawerToggle from'./../components/SideDrawer/DrawerToggle/DrawerToggle'



class Navbar extends Component {
  state={
    clickedOn:''
  }
  // clickOn = () => {
  //   const click='Login'
  //   this.props.clickOnLogin(click)
  // }

  onclickChange=(event,clickedOnName)=>{
    console.log('[Navbar] entered into onClickChange',clickedOnName)
    if(clickedOnName==='logout'){
      console.log('entered inside')
      localStorage.removeItem('username')
    }
    this.setState({clickedOn:clickedOnName})
    this.props.clickOnLogin(clickedOnName)

  }
  
  render() {
    console.log("entered into NAVBAR")
    const username = localStorage.getItem('username')
    console.log('[Navbar] page username is : ',username)
    // this.setState({username:username})
    console.log('[Navbar] render()....')
    console.log('username in navbar is : ',username)
    const login='Login'
    const cart='Cart'
    const orders='Orders'
    const logout='logout'
    
    
    return (
      <div>
      <DrawerToggle clicked={this.props.drawerToogleClicked}/>
      <div className="nav-links">
        <div class='main-name'>Shopping cart</div>
        {console.log('checking is : ',login,cart)}
      {username === null ? null :
      <div><ul>

      <li>
          {username !== '' || username!==null ? <span class="username">{username} 
        </span>
          : 
               null}
            
        </li >
       
        {this.props.loginAs==='operator' ? null: <React.Fragment>
        <li>
            <NavLink activeClassName="acitveRoute" to="/BrowseItems" exact>BrowseItems</NavLink>
        </li >
        <li>
            <NavLink activeClassName="acitveRoute" to="/Cart" 
                    onClick={(event)=>this.onclickChange(event,cart)} exact>Cart</NavLink>
        </li >
        <li>
            <NavLink activeClassName="acitveRoute" to="/Orders" 
                                    onClick={(event)=>this.onclickChange(event,orders)} 
                                    exact>Orders</NavLink>
        </li >
          </React.Fragment>}
        <li>
          {username !== '' || username!==null ?  
          <li>{console.log('entered into logout modification')}
               <NavLink to="/logout" onClick={(event)=>this.onclickChange(event,logout)} exact>Logout</NavLink>
          </li >
          : 
                <NavLink to="/login" onClick={(event)=>this.onclickChange(event,login)} exact>Login</NavLink>}
            
        </li >
  
      </ul></div>}
      </div>
      </div>
    );
  }
}


const mapPropsToState = state => {
  return{
      // username:state.validation.userNameCurrent,
      loginAs:state.validation.loginAs

  }

}

const mapDispatchToProps = dispatch => {
  return{
    clickOnLogin:(click)=>dispatch(actionCreators.loginClicked(click))
  }
}
export default connect(mapPropsToState,mapDispatchToProps)(Navbar);
    