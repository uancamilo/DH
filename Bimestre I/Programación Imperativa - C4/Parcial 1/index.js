function doble(num) {
    return num * 2
}

console.log(doble(2))

function multiplicacio(num1, num2){

    return num1 * num2

}

console.log(multiplicacio(3,4))

function verificarDistintos(num1, num2) {

   let operacion = ((num1 && num2 !=0 ) ? num1 / num2 : "Ingresar numeros distintos de cero")
   
   console.log(operacion)

}

console.log(verificarDistintos(6,2));

let resultado = []

const ciclista = [
	{
		nombre: "Juan",
		apellido: "Serna",
		edad: "37",
		tiene_bici: true,
	},
];

function ejercicio(array) {
	for (let i = 0; i < array.length; i++) {
		if (array[i].edad >= 18 && array[i].tiene_bici == true) {
			resultado.push("puede competir");
		} else if (array[i].edad < 18 && array[i].tiene_bici == true) {
			resultado.push("podrá competir pero con un adulto acompañante");
		} else if (array[i].tiene_bici == false) {
			resultado.push("No podrá competir");
		}
	}
}

ejercicio(ciclista);
console.log(resultado);


let competidores = [];

let competidor1 = {
	nombre: "Juan",
	edad: 42,
	kilometrosRecorridos: 80,
};
let competidor2 = {
	nombre: "Sofia",
	edad: 22,
	kilometrosRecorridos: 90,
};
let competidor3 = {
	nombre: "Maria",
	edad: 45,
	kilometrosRecorridos: 70,
};

competidores.push(competidor1, competidor2, competidor3);

console.log(competidores);

let nuevoRecorrido = [];

function competencia100km(array) {
	for (let i = 0; i < array.length; i++) {
		nuevoRecorrido.push(competidores[i].kilometrosRecorridos + 100);
	}
}

competencia100km(competidores);

console.log(nuevoRecorrido);

