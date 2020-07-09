import React, {Component} from "react";
import classes from './Simpletextarea.module.css';
import InputTrigger from 'react-input-trigger';


class Simpletextarea extends Component {
    constructor(props) {
        super(props);
        this.state = { 
         suggestions: [],
         text:'',
         count:0,
         arrValueLength:0,
         renderCount:0,
         currentWordStart:0,
         lastLetter:'',
         valDup:'',
         StartStringtake:0,
         top: null,
         left: null,
         textEntered:'',
         lettersInTextArea:0,
         showSuggestor: false,
         startPosition: null,
         clickedEnter:0,
         lastLetterValue:false,
         NoOfSpaces:0
        };
        this.onTextChange = this.onTextChange.bind(this);
        this.toggleSuggestor = this.toggleSuggestor.bind(this);
      }

      onTextChange(e) {
        let textEntered=e.target.value
        const items = [...this.props.items];
        this.setState(() => ({currentWordStart:this.state.currentWordStart+1}));
        this.setState({textEntered:textEntered})
        let dupText=textEntered;
        let lengthElement=dupText.length
        this.setState(() => ({lettersInTextArea:this.state.lettersInTextArea+1}));
        let lastLetter = dupText.slice(lengthElement-1,lengthElement)
        const index = dupText.lastIndexOf(lastLetter)
        if(lastLetter === '\n'){
          this.setState(() => ({StartStringtake:index}));
          this.setState({lastLetterValue:false,arrValueLength:0,currentWordStart:0},()=>{
          })
        
        }
        if(lastLetter === ' '){
          this.setState(() => ({StartStringtake:index}));
          this.setState({lastLetterValue:true,arrValueLength:0,NoOfSpaces:1,currentWordStart:0},()=>{
          })
        }
        let searchString = dupText.slice(this.state.StartStringtake,
                       this.state.StartStringtake+this.state.currentWordStart+2)
       
          let StringToBeSearhed=searchString
          this.setState({arrValueLength:this.state.currentWordStart+2})
          let suggestions=[]
        if(StringToBeSearhed!==' ' && StringToBeSearhed!=='' && lastLetter!=='\n' && lastLetter!==' '){
          let spaceCheck = StringToBeSearhed.charAt(0)
          if(spaceCheck === ' ' || spaceCheck === '\n'){
            StringToBeSearhed=StringToBeSearhed.slice(1,lengthElement)
          }
          const regex = new RegExp(`^${StringToBeSearhed}`,'i');
          suggestions= items.filter(v=> regex.test(v));
          const suggestionsLength=suggestions.length
          suggestions.length=3
        }
    
        this.setState(() => ({suggestions}));
      }
      keyPressed= (event) => {     
        if(event.keyCode === 8){
          if(this.state.arrValueLength<0){
            this.setState(() => ({arrValueLength:this.state.arrValueLength-1}));
          }
        }
        const valueDup=this.state.valDup
        const lengthDup=valueDup.length
        const selectSpace=valueDup.slice(lengthDup-2,lengthDup-1)
      
        if((event.keyCode === 8 && selectSpace === ' ')){
         
            this.setState(() => ({count:this.state.count-1}));
          

       
        }
        if(event.keyCode === 8){
          this.setState(() => ({lettersInTextArea:this.state.lettersInTextArea-1}));
        }

      }

      suggestionSelected (value) {
        
        const stringValue = this.state.arrValueLength
       
        this.setState(() => ({
          textEntered:this.state.textEntered+value.substring(stringValue-1),
          suggestions: [],

        }))
      }
      renderSuggestions= () => {
        const { suggestions } =this.state;
        if(suggestions[0]===undefined){
          return null
        }
        if(suggestions.length === 0) {
          return null;
        }
       return (
      <ul className={classes.textareaul}>
        {suggestions.map((item) => <li  className={classes.textareali} 
        onClick= {() =>this.suggestionSelected(item)}>{item}</li>)}
      </ul>
       )
      
      }

      toggleSuggestor(metaInformation) {
        const { hookType, cursor } = metaInformation;
        if (hookType === 'start' || hookType === 'typing') {
          this.setState({
            showSuggestor: true,
            left: cursor.left-10,
            top: cursor.top+cursor.height-16, 
          });
        
        }
      }
    
    
      render() {
        const {text} = this.state.textEntered;
        return (
          // <div className={classes.firstDiv}>
          <div
           style={{
            position: 'relative'        
          }}   >
             <InputTrigger
          trigger={{
            keyCode: 32
          }}
         
          onStart={(metaData) => { this.toggleSuggestor(metaData); }}
          onType={(metaData) => { this.toggleSuggestor(metaData); }}>
             <textarea className={classes.textarea}  value={this.state.textEntered} onChange={this.onTextChange} onKeyDown={this.keyPressed} />
           </InputTrigger>
           <div
          style={{
            position: "relative",
            marginLeft:"150px",
            width: "300px",
            //  height:"500px",
            background: "white",   
            top: this.state.top,
            left: this.state.left,
          }}>
             {/* <textarea className={classes.textarea}  value={text} onChange={this.onTextChange} onKeyDown={this.keyPressed} /> */}
             {this.renderSuggestions()}
             {/* {this.changeHandler} */}</div>
         </div>
        );
      }
}

export default Simpletextarea;