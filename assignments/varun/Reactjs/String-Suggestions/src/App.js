import React from 'react';
import Simpletextarea from './Simpletextarea';
import Places from './Places'


function App() {
  return (
    <div>
     <Simpletextarea items={Places}/>
    </div>
  );
}

export default App;
