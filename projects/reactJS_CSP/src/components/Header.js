import React, { Component } from 'react';
import classes from './Header.css';
import Logo from './Logo/Logo';
import Refresh from '../assets/Images/refreshing-image.png';
import Logout from '../assets/Images/logoutlogo2.png';
import DrawerToggleButton from '../components/SideDrawer/DrawerToggleButton';


export default class Header extends Component {

  render() {
    return (
      <div>
      <header className={classes.box}>
        <div className={classes.header }>
          <div className={classes.drawer}>
            <DrawerToggleButton/>
            </div>
          <Logo/>
          <h1 >CSP<small className={classes.small}>Customer service portal</small></h1>
          </div>
          <div className={classes.list}>
          <select className={classes.selectedValue}>
          <option value="Riya">Riya</option>
          <option value="Ramu">Ramu</option>
          <option selected value="Ashok">Ashok</option>
          </select>
          </div>
          </header>
      
        <nav className={classes.navbar_fixedtop}>
          {/* <div className={classes.navbar_collapse} id="navbarsexampleDefault"> */}
            <ul className={classes.navbar_items}></ul>
                
                  <div className={classes.nav_link1}>Static Tim<small className={classes.timing}>Call Time:15 Seconds</small></div>
                  <div className={classes.time}>051437869</div>
                  <div className={classes.Logo}>
                    <img src={Refresh} alt="RefreshingLogo"/>
                  </div>
         </nav>
         <nav className={classes.navbar_fixedtop2}>
                  <div className={classes.Logo1}>
                    <img src={Logout} alt="logoutLogo"/>
                  </div>
          </nav>
                  
              
                {/* <center> <div className={classes.calltime}>call Time:15 seconds</div></center> */}
                {/* <li >call Time:15 seconds</li> */}
          {/* </div> */}
       
         
 </div>

    );
  };
}

