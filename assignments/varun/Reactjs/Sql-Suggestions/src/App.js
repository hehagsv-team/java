import React from 'react';
import Simpletextarea from './Simpletextarea';
import * as tableDetails from  './Places';



function App() {
  return (
    <div>
     <Simpletextarea items={tableDetails.tables}/>
    </div>
  );
}

export default App;
