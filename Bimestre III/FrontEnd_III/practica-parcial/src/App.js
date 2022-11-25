
import "./App.css";
import Lista from "./componentes/lista";

import data from "./data.json"

function App() {



	return (
		<>
			<p>App</p>
			<Lista usuarios={data}/>
		</>
	);
}

export default App;
