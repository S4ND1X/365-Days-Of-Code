// const myArray = [1, 2, 3, 4];

// console.log(myArray.map(x => x * x));

//Promise es lit una promesa de que tendra unos valores
const myPromise = new Promise((resolve, reject) => {
    //Si la "conexion" es exitosa se usa el resolve si no, el reject
    if (true) {
        //Ejecuta una funcion despues de cierto tiempo
        setTimeout(() => {
        resolve("I have succeeded");
        }, 1000);
    } else {
        reject("I have failed");
    }
});
//De ser exitoso pasa algo en el .then si no se hace catch al error
myPromise
.then(value => console.log(value))
.catch(rejectValue => console.log(rejectValue));






