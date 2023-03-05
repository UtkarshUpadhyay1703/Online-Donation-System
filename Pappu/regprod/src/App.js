import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router,Route,Switch} from "react-router-dom";
import Display from './Component/Display';
function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/Product" component={Display}></Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
