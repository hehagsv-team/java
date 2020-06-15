import React, { Component } from 'react'
import {withRouter} from 'react-router-dom';


class Logout extends Component {
    render() {
        console.log('ENTERED INTO LOGOUT')
        localStorage.removeItem('username')
        console.log('props in Logout',this.props)
        this.props.history.push('/login')
        return (
            <div>
                
            </div>
        )
    }
} 

export default withRouter(Logout)
