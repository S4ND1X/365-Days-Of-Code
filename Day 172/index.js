//*Se puede usar global
var number = 69;
//*Solo en el scope de declaracion
let name = "jorgito";
//*No se puede cambiar su valor
const pi = 3.14;




function recursiveFib(n){
    if(n == 1) return n;
    else return recursiveFib(n) * recursiveFib(n - 1); 
}

console.log(recursiveFib(6));

