import React,{Component} from 'react';
import classes from './App.module.css';

class App extends Component {
  state={
    draggables:[],
    containers:[]
  }
  clickHandler = ()=>{
    console.log('clickHandler.....')
    this.state.draggables.forEach(draggable => {
      draggable.addEventListener('dragstart', () => {
        console.log('draggable',draggable)
        draggable.classList.add('draggedElement')
      })
    
      draggable.addEventListener('dragend', () => {
        draggable.classList.remove('draggedElement')
      })
    })
    console.log('state contaimers are : ',this.state.containers)
    this.state.containers.forEach(container => {
      console.log('entered into container',container)
      container.addEventListener('dragover', e => {
        console.log('entered into addEventListener')
        e.preventDefault()
        // console.log('event : jjjjjjj',e)
        const nextElement = getDragAfterElement(container, e.clientX)
        console.log('afterElement is : ',nextElement)
        const draggedElement = document.querySelector('[class*=draggedElement]')
        console.log('draggable is last one [CSP]: ',draggedElement)
        if (nextElement === null) {
          container.appendChild(draggedElement)
        } else if(nextElement!==null && draggedElement !==null){
          container.insertBefore(draggedElement, nextElement)
        }else{
          console.log('entered into here')
        }
      })
    })
     
    const getDragAfterElement = (container, x) => {
      console.log('entered into getDragAfterElement',container)
      // const draggableElements = [...container.querySelectorAll('.draggable:not(.dragging)')]
      const draggableElements = [...container.querySelectorAll('[class*=draggable]:not(.dragging)')]
    console.log('elementsDraggable',draggableElements)
      return draggableElements.reduce((nearest, boxIndexes) => {
        const itemBox = boxIndexes.getBoundingClientRect()
        console.log('box',itemBox)
        console.log('y',x)
        console.log('box top is : ',itemBox.top)
        console.log('box height is : ',itemBox.height)


        const itemToBePlaced = x - itemBox.left - itemBox.width / 2
        console.log('offset',itemToBePlaced)
        if (itemToBePlaced < 0 && itemToBePlaced > nearest.itemToBePlaced) {
          return { itemToBePlaced: itemToBePlaced, element: boxIndexes }
        } else {
          return nearest
        }
      }, { itemToBePlaced: Number.NEGATIVE_INFINITY }).element
    }

  }
  componentDidMount(){
    console.log('[App] componentDidMount')
    const draggables = document.querySelectorAll("[class*=draggable]")
    console.log('draggables : ',draggables)
    this.setState({draggables:draggables},()=>{
      console.log('draggables in state',this.state.draggables)
    })
    const containers = document.querySelectorAll('[class*=container]')
    this.setState({containers:containers},()=>{
      console.log('containers in state',this.state.containers)
    })
        console.log('containers : ',containers)


  }
  render(){
    console.log('render() [App]')
  return (
    <div className={classes.DragDrop}>
       <div className={classes.container}>
    <p className={classes.draggable} draggable="true" onDragStart={this.clickHandler}>Item-1</p>
    <p className={classes.draggable} draggable="true" onDragStart={this.clickHandler}>Item-2</p>
    <p className={classes.draggable} draggable="true" onDragStart={this.clickHandler}>Item-5</p>
    {/* <p className={classes.draggable} draggable="true" onDragStart={this.clickHandler}>Item-6</p>
    <p className={classes.draggable} draggable="true" onDragStart={this.clickHandler}>Item-7</p> */}
  </div>
  <div className={classes.container}>
    <p className={classes.draggable} draggable="true" onDragStart={this.clickHandler}>Item-3</p>
    <p className={classes.draggable} draggable="true" onDragStart={this.clickHandler}>Item-4</p>
  </div>
  </div>

  )}
}

export default App;
