export default function Lista(props) {
	return (
		<>
			Lista
			<ul>
				{props.usuarios.map((usuario) => {
					return <li key={usuario.id}>{usuario.name}</li>;
				})}
			</ul>
		</>
	);
}
