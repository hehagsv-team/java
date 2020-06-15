import React, { Component } from 'react';
import './Filter.css'

export class Filter extends Component {
    render() {
        let radiovalue=this.props.name
        console.log(radiovalue)
            if(radiovalue==="List By Price")
            {
                return(
                    <div className="filter">
                        <input type="radio" name="rd-button" />{radiovalue}{" "}
                        
                        <span1><label>min:</label><input type="text" size="5" name="min-name"/></span1>
                        <span2><label>max:</label><input type="text" size="5" name="min-name"/></span2>
                    </div>
                )
            }
            else if(radiovalue==="List By Manufacturer")
            {
                return(

                    <div className="drop-down">
                         <input type="radio" name="rd-button" />{radiovalue}
                        <span>
                            <select>
                                <option value="react">React</option>
                                <option value="redux">Redux</option>
                                <option value="router">Router</option>
                            </select>
                        </span>

                    </div>




                )
            }
            else{
                return(
                    <div className="filter">
                    <input type="radio" name="rd-button" />{radiovalue}
                    </div>
                )
            }
    }
}

export default Filter
