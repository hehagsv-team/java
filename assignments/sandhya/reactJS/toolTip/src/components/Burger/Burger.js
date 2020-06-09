import React from 'react';
import ReactTooltip from 'react-tooltip';

import classes from './Burger.css';
import BurgerIngredient from './BurgerIngredient/BurgerIngredient';

const burger = ( props ) => {
    console.log(props);
    let transformedIngredients = Object.keys( props.ingredients )
        .map( igKey => {
            return [...Array( props.ingredients[igKey] )].map( ( _, i ) => {
                return <BurgerIngredient key={igKey + i} type={igKey} />;
            } );
        } )
        .reduce((arr, el) => {
            return arr.concat(el)
        }, []);
    if (transformedIngredients.length === 0) {
        transformedIngredients = <p>Please start adding ingredients!</p>;
    }
    return (
        <div className={classes.Burger}
         data-tip="" data-for="test">
            <BurgerIngredient type="bread-top" />
            {transformedIngredients}
            <BurgerIngredient type="bread-bottom" />
            <ReactTooltip  className={classes.Tooltip} id="test" >
                <div>{Object.keys(props.ingredients)[0]}:{Object.values(props.ingredients)[0]}</div>
                <div>{Object.keys(props.ingredients)[1]}:{Object.values(props.ingredients)[1]}</div>
                <div>{Object.keys(props.ingredients)[2]}:{Object.values(props.ingredients)[2]}</div>
                <div>{Object.keys(props.ingredients)[3]}:{Object.values(props.ingredients)[3]}</div>
            </ReactTooltip>

        </div>
    );
};

export default burger;