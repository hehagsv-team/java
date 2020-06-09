import React from 'react';
import mainlogo from '../../assets/Images/mainlogo.png';
import classes from './Logo.css';

const logo = (props) => (
    <div className={classes.Logo}>
        <img src={mainlogo} alt="Mylogo"/>
    </div>
);

export default logo;