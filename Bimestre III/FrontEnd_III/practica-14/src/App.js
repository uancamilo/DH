import "./App.css";
import React, { useEffect } from "react";

function App() {
	const [data, setData] = React.useState();

	useEffect(() => {
		fetch("https://jsonplaceholder.typicode.com/todos")
			.then((data => data.json()))
			.then((result) => {
				setData(result);
			});
	}, []);

	console.log(data)

	return (
		<div className="App">
			<p>React</p>

			{data.map()}
		</div>
	);
}

export default App;
