import React from 'react';
import classes from './input.module.css';

const input = (props) => (
    <div>
        <label className={classes.Label} >{props.label}</label><br/>
        <input className={classes.InputElement} onChange={props.changed} type={props.type} name={props.type}/>
        
    </div>
);

export default input;