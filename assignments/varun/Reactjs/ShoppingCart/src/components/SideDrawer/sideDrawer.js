import React,{Component} from 'react';
// import Logo from '../../Logo/Logo';
// import NavigationItems from '../NavigationItems/NavigationItems';
import classes from './SideDrawer.module.css';
import wrap from '../../UI/wrap/wrap';
import {NavLink } from "react-router-dom";
import {connect} from 'react-redux';
import * as actionCreators from '../../containers/store/actions';
import Backdrop from '../../UI/Backdrop/Backdrop';

class sideDrawer extends Component {

    state={
        clickedOn:''
      }

      onclickChange=(event,clickedOnName)=>{
        console.log('[Navbar] entered into onClickChange',clickedOnName)
        if(clickedOnName==='logout'){
          console.log('entered inside')
          localStorage.removeItem('username')
        }
        this.setState({clickedOn:clickedOnName})
        // this.props.clickOnLogin(clickedOnName)
    
      }
      

    render(){
    // show={props.open} clicked={props.closed}
    let attachedClasses = [classes.SideDrawer, classes.Close];
    const username = localStorage.getItem('username')
    if(this.props.open){
        attachedClasses = [classes.SideDrawer,classes.Open];
    }
    const login='Login'
    const cart='Cart'
    const orders='Orders'
    const logout='logout'

    return(
        <wrap>
            <Backdrop show={this.props.open} clicked={this.props.closed}/>
            <div className={attachedClasses.join(' ')}>
            {/* <div className={classes.Logo}>
                    <Logo/>
                </div>
                
                <nav>
                    <NavigationItems/>
                </nav> */}
                 <div className={classes.navLinksSidebar}>
        <div className={classes.mainName}>Shopping cart</div>
        {console.log('checking is : ',login,cart)}
      {username === null ? null :
      <div className={classes.Listing}>

      <div>
          {username !== '' || username!==null ? <span className={classes.userName}>{username} 
        </span>
          : 
               null}
            
        </div >
       
        {this.props.loginAs==='operator' ? null: <React.Fragment>
        <div className={classes.navLinks}>
            <NavLink  style={{ textDecoration: 'none',fontWeight:'bold'  }} activeClassName={classes.acitveRoute} to="/BrowseItems" exact>BrowseItems</NavLink>
        </div>
        <div className={classes.navLinks}>
            <NavLink style={{ textDecoration: 'none',fontWeight:'bold'  }} activeClassName={classes.acitveRoute} to="/Cart" 
                    onClick={(event)=>this.onclickChange(event,cart)} exact>Cart</NavLink>
        </div >
        <div className={classes.navLinks}>
            <NavLink style={{ textDecoration: 'none',fontWeight:'bold' }} activeClassName={classes.acitveRoute} to="/Orders" 
                                    onClick={(event)=>this.onclickChange(event,orders)} 
                                    exact>Orders</NavLink>
        </div >
          </React.Fragment>}
        <div>
          {username !== '' || username!==null ?  
          <div className={classes.navLinks}>{console.log('entered into logout modification')}
               <NavLink style={{ textDecoration: 'none' ,fontWeight:'bold' }} to="/logout" onClick={(event)=>this.onclickChange(event,logout)} exact>Logout</NavLink>
          </div>
          : 
                <NavLink  className={classes.navLinks} style={{ textDecoration: 'none',fontWeight:'bold'  }} to="/login" onClick={(event)=>this.onclickChange(event,login)} exact>Login</NavLink>}
            
        </div>
  
      </div>}
      </div>


            </div>
        </wrap>
    );}

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


export default connect(mapPropsToState,mapDispatchToProps)(sideDrawer);