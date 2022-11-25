let misMascotas = [
	{
		nombre: "Lola",
		raza: "Yorky",
		edad: 10,
		sonido: "guau ",
        hacerSonido: function () {
            return this.sonido + this.sonido
        }
	},
	{
		nombre: "Canela",
		raza: "Snauser",
		edad: 5,
		sonido: "",
	},
	{
		nombre: "Enrique",
		raza: "French",
		edad: 8,
		sonido: "",
	},
];

function agregarId(array) {
	for(let i = 0 ; i < array.length; i++){
		array[i].id = i + 1
	}
	
}

agregarId(misMascotas)

console.log(misMascotas)

console.log(misMascotas[0].hacerSonido());


function aumetarEdad(array) {

	for(let i = 0 ; i < array.length; i++){
		if(array[i].edad > 9 ){

		}
	}
	
}

// let nuevoArray = [];

// const edades = [11, 12, 15, 18, 25, 22, 10, 33, 18, 5];

// for (let i = 0; i < edades.length; i++) {
// 	if (edades[i] < 18) {
// 		nuevoArray.push(edades[i]);
// 	}
// }

// console.log(nuevoArray)