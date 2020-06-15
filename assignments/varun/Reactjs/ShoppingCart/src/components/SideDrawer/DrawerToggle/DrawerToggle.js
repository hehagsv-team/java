import React from 'react';
import classes from './DrawerToggle.module.css';

const drawerToggle = (props) => (
    <div className={classes.DrawerToggle} onClick={props.clicked}>
          {/* <div onClick={props.clicked}>  */}
        <div className={classes.dividerToggle}></div>
        <div className={classes.dividerToggle}></div>
        <div className={classes.dividerToggle}></div>
       
    </div>
)

export default drawerToggle;