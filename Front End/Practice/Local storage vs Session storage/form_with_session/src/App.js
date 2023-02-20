import './App.css';
import video from "./Background/video.mp4"
import { BrowserRouter as Route, } from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <video autoPlay muted loop>
        <source src={video} type="video/mp4"/>
      </video>
<div className='abc'>
  dfgyhjikolkjhgfghjkl
</div>
    </div>
  );
}
export default App;