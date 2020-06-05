import React from 'react';
import {Line} from 'react-chartjs-2';

const state = {
  labels: ['January', 'February', 'March',
           'April', 'May'],
  datasets: [
    {
      label: 'Rainfall',
      fill: false,
      lineTension: 0,
      backgroundColor: 'rgba(75,192,192,1)',
      borderColor: 'rgba(0,0,0,1)',
      borderWidth: 2,
      data: [65, 59, 80, 81, 75]
    }
  ],
}

export default class App extends React.Component {
  componentDidMount() {
    setInterval(this.refreshpage, 30000);
  }
refreshpage=()=> {
  window.location.reload(true); 
}
  render() {
    return (
      <div>
        <Line
          data={state}
          options={{
            title:{
              display:true,
              text:'Average Rainfall per month',
              fontSize:15
            },
            legend:{
              display:true,
              position:'right'
            }
          }}
        />
      </div>
      
    );
  }
}