import React, {Component} from "react";
import classes from './Simpletextarea.module.css';
import InputTrigger from 'react-input-trigger';


class Simpletextarea extends Component {
    constructor(props) {
        super(props);
        this.state = { 
        searchBasedOn:'',
        firstEntered:false,
        spaceIndex:'',
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
        let textEnteredDup=textEntered
        let lengthOfText=textEnteredDup.length
        const lastLetter=textEnteredDup.slice(lengthOfText-1,lengthOfText)
        console.log('entered into onTextChange()',e.target.value,this.props.items)
        // const indexOfLastSpace=textEnteredDup.lastIndexOf(' ')
        // const indexOfLastDot=textEnteredDup.lastIndexOf('.')
        // let tableNameRealOne=textEnteredDup.slice(indexOfLastSpace,indexOfLastDot)

         //From index start and end
          // const indexOfFrom = textEnteredDup.indexOf('from')
          const indexOfFrom = textEnteredDup.lastIndexOf('from')
          console.log('LASTINDEX OF FROM IS : ',indexOfFrom)
          let textAfterFrom = textEnteredDup.slice(indexOfFrom+5,lengthOfText)
          console.log('tableAfterFrom',textAfterFrom)
          let indexOfFromLast;
          // let tableNameLatestAfterFrom;
          if(lastLetter===' '){
            indexOfFromLast = textAfterFrom.indexOf(' ')
          }
          // else if (lastLetter==='\n'){
          else{
            indexOfFromLast = textAfterFrom.lastIndexOf('\n')
          }
          console.log('indexOfFromLast',indexOfFromLast)
          let tableNameLatestAfterFrom = textEnteredDup.slice(indexOfFrom+4,indexOfFrom+5+indexOfFromLast)
          console.log('tableNameLatestAfterFrom is : ',tableNameLatestAfterFrom,tableNameLatestAfterFrom.length)


        let tableNameRealOne=''
        console.log('TTTTAAABBBLLEEE NNNAAAAAMMEEEE IS : ',tableNameRealOne)
        tableNameRealOne=tableNameLatestAfterFrom.trim()
        // const items = [...this.props.items];
        // const tableNames=Object.keys(this.props.items).map(key=>console.log('tableNames are : ',key))
        const tableNames=Object.keys(this.props.items).map(key=>key)
        console.log('tableNames are tableNames: ',tableNames)
        // tableNameTobeSearched="student"
        // let attributesOfTablenameWithValue=Object.keys(this.props.items)
        //           .filter(key=>key===tableNameTobeSearched)
        //               .map(item=>this.props.items[item])
        let attributesOfTablenameWithValue=Object.keys(this.props.items)
                      .filter(key=>key===tableNameRealOne)
                      // .map(item=>console.log('kekekekek',item))
                          .map(item=>this.props.items[item])
        console.log('attributes of a table are : ',attributesOfTablenameWithValue)
        let attributesOfTablenameWithValueObject=
                    attributesOfTablenameWithValue.map(key=>Object.keys(key).map(each=>each)).join()
        console.log('tttttttt',attributesOfTablenameWithValueObject)
        let finalAttributes=attributesOfTablenameWithValueObject.split(',')
        // const onlyAttributes = Object.keys(attributesOfTablenameWithValueObject)
        //               .map(key=>console.log('attributes are : ',key))
        console.log('finalAttributes : ',finalAttributes)
        console.log('tableNames: ',tableNames)
        // const againAttributesInsideArray=attributesOfTablenameWithValueObject.filter((key,index)=>index===0).map(each=>each)
        // console.log('attributes of selected tableName are ',attributesOfTablenameWithValueObject.filter(key=>key===0).map(each=>each))
        // console.log('againAttributes inside array',againAttributesInsideArray)
        this.setState(() => ({currentWordStart:this.state.currentWordStart+1}));
        this.setState({textEntered:textEntered})
        const fromCheck=textEnteredDup.slice(lengthOfText-4)
        const whereCheck=textEnteredDup.slice(lengthOfText-5)
        const checkOrderBy=textEnteredDup.slice(lengthOfText-8)
        console.log('checkFromOrNot',fromCheck)
        if(fromCheck==='from' || fromCheck==='FROM'){
          this.setState({searchBasedOn:fromCheck})
        }
        if(whereCheck==='where' || whereCheck==='WHERE'){
          this.setState({searchBasedOn:whereCheck})
        }
        if(checkOrderBy==='order by' || checkOrderBy==='ORDER BY'){
          this.setState({searchBasedOn:checkOrderBy})
        }
        if(lastLetter==='.'){
          const dot='dot'
          this.setState({searchBasedOn:dot})
        }
        let spaceEncounter=false
        let stringSearch=''
        console.log('value of fromValue in state',this.state.searchBasedOn)
        if(this.state.searchBasedOn==='from' || this.state.searchBasedOn==='where'
                || this.state.searchBasedOn==='dot'){
          const spaceCheck=textEnteredDup.slice(lengthOfText-1,lengthOfText)
          let spaceIndex=''
          if(spaceCheck===' ' || spaceCheck==='\n'){
            this.setState({firstEntered:!this.state.firstEntered})
            if(spaceCheck===' '){
              spaceIndex=textEnteredDup.lastIndexOf(' ')
            }
            else{
              spaceIndex=textEnteredDup.lastIndexOf('\n')
            }
            console.log('spaceIndex is :',spaceIndex)
            this.setState({spaceIndex:spaceIndex})
            spaceEncounter=true
            console.log('SPACE HAS BEEN ENCOUNTEREDDD')
          }
          else{
            console.log('SPACE HAS NOT ENCOUNTEREDDDDDDDDDDDDDD')
          }
          if(lastLetter==='.'){
            spaceIndex=textEnteredDup.lastIndexOf('.')
            console.log('spaceIndex is :',spaceIndex)
            this.setState({spaceIndex:spaceIndex})
          }
        
        stringSearch=textEnteredDup.slice(this.state.spaceIndex+1,lengthOfText)
        
        }
        console.log('space encounter is : ',spaceEncounter)
        console.log('firstEntered is : ',this.state.firstEntered)
        
        console.log('stringSearched: ',stringSearch)
        let lengthOfSearchString = stringSearch.length;

        // let dupText=textEntered;
        // let lengthElement=dupText.length
        // this.setState(() => ({lettersInTextArea:this.state.lettersInTextArea+1}));
        // let lastLetter = dupText.slice(lengthElement-1,lengthElement)
        // const index = dupText.lastIndexOf(lastLetter)
        // if(lastLetter === '\n'){
        //   this.setState(() => ({StartStringtake:index}));
        //   this.setState({lastLetterValue:false,arrValueLength:0,currentWordStart:0},()=>{
        //   })
        
        // }
        // if(lastLetter === ' '){
        //   this.setState(() => ({StartStringtake:index}));
        //   this.setState({lastLetterValue:true,arrValueLength:0,NoOfSpaces:1,currentWordStart:0},()=>{
        //   })
        // }
        // let searchString = dupText.slice(this.state.StartStringtake,
        //                this.state.StartStringtake+this.state.currentWordStart+2)
        this.setState({arrValueLength:lengthOfSearchString})
          let StringToBeSearhed=stringSearch
          let searchBasedOnWord=this.state.searchBasedOn
          console.log('stringToBeSearhced basedOn : ',searchBasedOnWord)



         




          // //From index start and end
          // const indexOfFrom = textEnteredDup.indexOf('from')
          // console.log('INDEX OF FROM IS :INDEX OF FROM IS : ',indexOfFrom)
          // let textAfterFrom = textEnteredDup.slice(indexOfFrom+5,lengthOfText)
          // console.log('tableAfterFrom',textAfterFrom)
          // const indexOfFromLast = textAfterFrom.indexOf(' ')
          // console.log('indexOfFromLast',indexOfFromLast)
          // let tableNameLatestAfterFrom = textEnteredDup.slice(indexOfFrom+4,indexOfFrom+5+indexOfFromLast)
          // console.log('tableNameLatestAfterFrom is : ',tableNameLatestAfterFrom,tableNameLatestAfterFrom.length)

          let textAfterFromSecod = textEnteredDup.slice(indexOfFrom,lengthOfText)
          console.log('textAfterFromSecod',textAfterFromSecod)
          let indexOfTableName = textEnteredDup.indexOf(tableNameLatestAfterFrom)
          console.log('indexOfTableName',indexOfTableName)
          let indexOfSpace = textAfterFromSecod.lastIndexOf(' ')
          console.log('indexOfSpace',indexOfSpace)
          const dupTableNameFrom=textEnteredDup.slice(indexOfTableName+1,indexOfTableName+1+indexOfSpace)
         

          const checkEnter = dupTableNameFrom.includes('\n')
          const checkOrderByBoolean=dupTableNameFrom.includes('order by')
          let countSpace = (textAfterFrom.match(/\ /g) || []).length;
          if(checkEnter && countSpace===1){
            countSpace=countSpace+1
            let enterIndex=tableNameLatestAfterFrom.indexOf('\n')
            tableNameLatestAfterFrom=tableNameLatestAfterFrom.slice(0,enterIndex)
          }
          if(checkEnter){
            let enterIndex=tableNameLatestAfterFrom.indexOf('\n')
            tableNameLatestAfterFrom=tableNameLatestAfterFrom.slice(0,enterIndex)
          }
          if(checkOrderBy){
            countSpace=countSpace+2
          }
          console.log('NO OF SPACES AREeeeeeeee : ',checkOrderByBoolean,dupTableNameFrom,checkEnter,countSpace+1)
          countSpace=countSpace+1


          const indexOfOrderBy = textEnteredDup.lastIndexOf('order by')
          console.log('INDEX OF ORDER BY IS ',indexOfOrderBy)
          let textAfterOrdreBySecod = textEnteredDup.slice(indexOfOrderBy,lengthOfText)
          console.log(textAfterOrdreBySecod)
          let countSpaceFromOrderBy = (textAfterOrdreBySecod.match(/\ /g) || []).length;
          console.log('NO OF SPACES AFTER ORDER BY  : ',countSpaceFromOrderBy)
          // countSpaceFromOrderBy=countSpaceFromOrderBy


          
          //where index start and end
          const indexOfWhere = textEnteredDup.lastIndexOf('where')
          console.log('INDEX OF WHERE IS : ',indexOfWhere)
          let textAfterWhere = textEnteredDup.slice(indexOfWhere+6,lengthOfText)
          console.log('tableAfterFrom',textAfterWhere)
          const indexOfFromWhere = textAfterWhere.indexOf('.')
          console.log('indexOfFromLast',indexOfFromWhere)
          let tableNameLatest = textEnteredDup.slice(indexOfWhere+5,indexOfWhere+6+indexOfFromWhere)
          console.log('tableName latest is : ',tableNameLatest)

        //   this.setState({arrValueLength:this.state.currentWordStart+2})
          let suggestions=[]
        // if(StringToBeSearhed!==' ' && StringToBeSearhed!=='' && lastLetter!=='\n' && lastLetter!==' '){
          // let spaceCheck = StringToBeSearhed.charAt(0)
          // if(spaceCheck === ' ' || spaceCheck === '\n'){
          //   StringToBeSearhed=StringToBeSearhed.slice(1,lengthElement)
          // }
          console.log('GGGGGGGGGGGGGGGGGGG',this.state.searchBasedOn,tableNameLatest)
          console.log('HHHHHHHHHHHHHHHHHh',countSpace,countSpaceFromOrderBy)
          if(countSpace !== 2 && countSpace !==4 && countSpaceFromOrderBy !==3){
            console.log('ENTERED 0')
            if(this.state.searchBasedOn==='from' || this.state.searchBasedOn==='where' 
            || lastLetter === '.' || this.state.searchBasedOn==='order by'){
              console.log('ENTERED 1')
              if(lastLetter==='.' || this.state.searchBasedOn === 'order by'){
                console.log('ENTERED 2')
                if(lastLetter=== '.'){
                  console.log('tableNameLatest inside herererer is : ',tableNameLatest)
                  tableNameLatest = tableNameLatest.slice(1,tableNameLatest.length)
                  const regex = new RegExp(`^${tableNameLatest}`,'i');
                  console.log('regex value is : ',regex)
                  attributesOfTablenameWithValue=Object.keys(this.props.items)
                      .filter(key=>key===tableNameLatest)
                      // .map(item=>console.log('kekekekek',item))
                          .map(item=>this.props.items[item])
          console.log('attributes of a table are : ',attributesOfTablenameWithValue)
              attributesOfTablenameWithValueObject=
                    attributesOfTablenameWithValue.map(key=>Object.keys(key).map(each=>each)).join()
            console.log('tttttttt',attributesOfTablenameWithValueObject)
          finalAttributes=attributesOfTablenameWithValueObject.split(',')
                  regex=regex.trim()
                  console.log('regex is : ',regex,finalAttributes)
                  suggestions= finalAttributes.filter(v=> regex.test(v));
                  const suggestionsLength=suggestions.length
                  // suggestions.length=3

                }
                else{
                  console.log('tableNameLatest inside herererer is : ',tableNameLatestAfterFrom)
                  // tableNameLatestAfterFrom = tableNameLatestAfterFrom.slice(1,tableNameLatestAfterFrom.length)
                  tableNameLatestAfterFrom=tableNameLatestAfterFrom.trim()
                  const regex = new RegExp(`^${tableNameLatestAfterFrom}`,'i');
                  attributesOfTablenameWithValue=Object.keys(this.props.items)
                  .filter(key=>key===tableNameLatestAfterFrom)
                  // .map(item=>console.log('kekekekek',item))
                      .map(item=>this.props.items[item])
      console.log('attributes of a table are : ',attributesOfTablenameWithValue)
          attributesOfTablenameWithValueObject=
                attributesOfTablenameWithValue.map(key=>Object.keys(key).map(each=>each)).join()
        console.log('tttttttt',attributesOfTablenameWithValueObject)
      finalAttributes=attributesOfTablenameWithValueObject.split(',')


                  console.log('regex is : ',regex,finalAttributes)
                  suggestions= finalAttributes.filter(v=> regex.test(v));
                  const suggestionsLength=suggestions.length
                  // suggestions.length=3

                }
               
    
              }
              else{
                console.log('ENTERED INTO ELSE OF FIRST',StringToBeSearhed)
                const regex = new RegExp(`^${StringToBeSearhed}`,'i');
                console.log('regex value is : ',regex)
              suggestions= tableNames.filter(v=> regex.test(v));
              const suggestionsLength=suggestions.length
              // suggestions.length=3
              }
              
            }
            else if(this.state.searchBasedOn==='dot' ){
              console.log('Stringggggggggggg',StringToBeSearhed,tableNameLatest,tableNameLatest.length)

              tableNameLatest=tableNameLatest.slice(1,tableNameLatest.length)
              attributesOfTablenameWithValue=Object.keys(this.props.items)
              .filter(key=>key===tableNameLatest)
              // .map(item=>console.log('BBBBBBBBBBBBBBBBBBBB',item))
                  .map(item=>this.props.items[item])
  console.log('AAAAAAAAAAAAAAAAAAAAAAAAA ',attributesOfTablenameWithValue)
      attributesOfTablenameWithValueObject=
            attributesOfTablenameWithValue.map(key=>Object.keys(key).map(each=>each)).join()
    console.log('tttttttt',attributesOfTablenameWithValueObject)
  finalAttributes=attributesOfTablenameWithValueObject.split(',')






              const regex = new RegExp(`^${StringToBeSearhed}`,'i');
              console.log('regex value is : ',regex)
              suggestions= finalAttributes.filter(v=> regex.test(v));
              const suggestionsLength=suggestions.length
              // suggestions.length=3
            }

          }

       if(countSpaceFromOrderBy === 3){
         console.log('zzzzzzzzzzzzzzzzzzzzzzzzz',this.state.arrValueLength)
         let finalSpace =textEnteredDup.lastIndexOf(' ')
         let findDesOrAsc=textEnteredDup.slice(finalSpace,lengthOfText)
         console.log('zzzzzzzzzzzzzzzz findDesOrAsc',findDesOrAsc,findDesOrAsc.length)
         this.setState({arrValueLength:findDesOrAsc.length-1})
         suggestions=["desc","asc"]
       }
      //  else if(countSpaceFromOrderBy > 3){
      //    console.log('control still entering here')
      //   suggestions=[]
      // }
      if(lastLetter==='\n' && this.state.searchBasedOn!=='from'
                           && this.state.searchBasedOn==='where'){
            suggestions=[]
                           }
        console.log('suggestion to be shown in suggestion box are : ',suggestions)
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
          textEntered:this.state.textEntered+value.substring(stringValue),
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

      componentDidMount(){
        console.log('componentDidMount[App]',this.props.items)
      }
    
    
      render() {
        console.log('render() method : [App]')
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