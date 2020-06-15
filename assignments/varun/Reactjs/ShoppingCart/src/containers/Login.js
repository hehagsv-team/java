import React, { Component } from 'react';
import Input from '../UI/Input';
// import classes from './Login.module.css';
import {withRouter} from 'react-router-dom';
import Button from '../UI/Button';
import {connect} from 'react-redux';
// import * as actionTypes from './store/actions';
import * as actionCreators from './store/actions';
import login from '../Assets/loginImage.jpg'
import './Login.css'

class Login extends Component {
    state={
        username:"",
        password:"",
        isUser:false,
        LoginButtonDisable:true,
        showError:false

    }
    // componentDidMount(){
    //     console.log("cmp did mount")
    //     console.log(this.props)
    // }
    // buttonClicked = () =>{
    //     console.log("entered into button functionality")
    //     if(this.props.users === 'varun'){
    //         this.setState({isUser:true})
    //     }
    //     else{
    //         console.log(false);

    //     }
     
    // }
    submitHandler = (event,username,password) => {
        event.preventDefault();
        console.log('inside submitHandler........')
        console.log('submitHandler : ',event)
        console.log('submitHandler : username is',username);
        console.log('submitHandler : password is',password);
        console.log('submitHandler : users FB are : ',this.props.users)
        const userExist=Object.keys(this.props.users)
            .filter(key=>{
                console.log('inside userExist : ',this.props.users[key].operatorName)
                return (this.props.users[key].username===username ||
                        this.props.users[key].operatorName===username) &&
                        this.props.users[key].password===password
            })
        console.log("submitHandler : userExist ",userExist)
        const loginAsArray=userExist.join()
        const loginPersonLength=loginAsArray.length
        console.log('LoginPersonLength : ',loginPersonLength)
        let loginPerson
        if(loginPersonLength>5){
            loginPerson=loginAsArray.slice(0,8)
        }
        else{
            loginPerson=loginAsArray.slice(0,4)
        }
        
        console.log('LoginAs : ',loginPerson)
        
        if(userExist.length>0){
            this.props.currentUserName(username)
            console.log('HERE SETTING USERNAME AS LOCAL STORAGE')
            console.log('username before setting in local storage : ',username)
            localStorage.setItem('username',username)
            if(loginPerson==='user'){
                if(this.props.pageSelected==='Cart'){
                    this.props.history.push('/Cart');
                }
                else if(this.props.pageSelected==='Orders'){
                    this.props.history.push('/Orders');
                }
                else{
                    this.props.history.push('/BrowseItems');
                }
            }
            else if(loginPerson==='operator'){
                this.props.history.push('/Operator');
            }
        }
        else{
            this.setState({showError:true})
        }
        // if(this.props.user === 'varun'){
        // if(this.state.isUser)
        //     this.props.history.push('/BrowseItems');
        // }
        // else{
        //     this.setState({showError:true})
        // }
        this.props.setLoginAs(loginPerson)
    }

    inputChangeHandler = (event) => {
  
        console.log("entered into inputChangeHnadler");
        this.setState({username:event.target.value,LoginButtonDisable:false})
    }
    componentDidUpdate(){
        console.log('[Login] componentDidUpdate')
        console.log(this.state.username)
    }
    onChangePassHandler = (event) => {
  
        console.log("entered into onChangePassHandler");
        this.setState({password:event.target.value,LoginButtonDisable:false})
    }


     componentWillMount(){
         console.log('[Login] componenetDidMount')
         const username=localStorage.getItem('username')
         console.log('pageSelected is : ',this.props.pageSelected)
         if(username !== null){
             this.props.history.push('/BrowseItems')
         }
         if(this.props.pageSelected==='Login'){
            const cartPageMessage=''
            // const redirected=true
            this.props.loginError(cartPageMessage)
         }
         
         this.props.userDetailsFetch();
     }


    //  componentDidMount(){
    //      console.log("component did mount......")
    //      var arr=Object.keys(this.props.user).map((key)=>{
    //         return {[key]:this.props.user[key]}
    //     })
    //     console.log("this arr has values ",arr)
    //  }
      
    // }
    render() {
        console.log('value of lgc : ')
        // console.log(this.props.user)
        // console.log(this.props.items)
        console.log(this.props.users)
        const userSplits=Object.keys(this.props.users)
        .map(key=>{
            return {[key]:this.props.users[key]}
        })
        console.log('[Login].. userSplit : ',userSplits)
        // var arr=[];
        var username=this.state.username;
        var password=this.state.password;
        console.log('username and password in state are : ',username,password)
        // if( typeof this.props.user !== 'undefined')
        // {
        //     arr=Object.keys(this.props.user).map((key)=>{
        //         return {[key]:this.props.user[key]}
        //     })
        //     console.log("this arr has values ",arr)
        //     username=arr.map(user=>user.username).filter( key=> typeof key !== 'undefined').join();
        //     password=arr.map(user=>user.password).filter( key=> typeof key !== 'undefined').join();
        //     console.log('username is',username);
        //     console.log('password is',password)
            
        // }
       
        // cosnt 
        return (
            <React.Fragment><div className='loginErrorMessage'>{this.props.loginErrorMessage}</div>
            <div className='Login'>  
               <img src={login}/>
                {/* <h3 style={{textAlign:'center'}}>Login</h3> */}
                <form onSubmit={(event)=>this.submitHandler(event,username,password)}>
                <Input label="Username" type="text" changed={this.inputChangeHandler}/>
                <Input label="Password" type="password" changed={this.onChangePassHandler}/>
                {/* <Input label="username" type="text" changed={(event) => this.props.onChangeHandler(event.target.value)}/>
                <Input label="password" type="password" changed={(event) => this.props.onChangePassHandler(event.target.value)}/> */}
                <h2>{console.log(this.state.buttonClicked)}</h2>
                {/* <Button disabled={this.props.loginButtonControl} btnType="Success" clicked={this.buttonClicked}>Login</Button> */}
                <div style={{textAlign:'center'}}><Button disabled={this.state.LoginButtonDisable} btnType="Success"
                                clicked={this.buttonClicked}>Login</Button></div>
                {this.state.showError ? <h3 className='Error'>username not exist</h3> : null}
                {/* {this.state.LoginButtonDisable&&this.state.isUser ? <h3>login successfull</h3> : null} */}
            </form>
            </div>
            </React.Fragment>
        )
    }
}

const mapStateToProps = state =>{
    return{
        user:state.validation.users,
        loginButtonControl:state.validation.loginButton,
        items:state.itemsReducerName.items,
        users:state.userReducer.users,
        loginErrorMessage:state.validation.loginMessageError,
        // errorMessageShow:state.validation.redirect,
        pageSelected:state.validation.pageSelected
    }
}

const mapDispatchToProps = dispatch =>{
    return{

        // onChangeHandler: (event) => dispatch(actionCreators.handleusername(event)),
        // onChangePassHandler:(event)=>dispatch(actionCreators.handlePassword(event)),
        userDetailsFetch:()=> dispatch(actionCreators.fetchuserdetails()),
        currentUserName:(username) => dispatch(actionCreators.currentUserName(username)),
        loginError:(message)=>dispatch(actionCreators.loginErrorDisplay(message)),
        setLoginAs:(loginPerson)=>dispatch(actionCreators.loginAs(loginPerson))

    }
}

export default connect(mapStateToProps,mapDispatchToProps)(withRouter(Login));