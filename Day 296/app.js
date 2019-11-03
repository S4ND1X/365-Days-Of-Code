//?Inicialización de Firebase con los valores dependiendo tu base
var firebaseConfig = {
  apiKey: "AIzaSyA7Sqde65McpUOkmK9lyuoYivRuD8it1Y4",
  authDomain: "semanai-4ea99.firebaseapp.com",
  databaseURL: "https://semanai-4ea99.firebaseio.com",
  projectId: "semanai-4ea99",
  storageBucket: "semanai-4ea99.appspot.com",
  messagingSenderId: "227027138449",
  appId: "1:227027138449:web:d8a5840d8f95e29d09cc30",
  measurementId: "G-PRVKFTJHH6"
};
firebase.initializeApp(firebaseConfig);

//Getter de valores a través de los ID asignados
var rele1 = document.getElementById("toogle1");
var iluminacion = document.getElementById("iluminacion");
var movimiento = document.getElementById("movimiento");
var salir = document.getElementById("btnSalir");
var correo = document.getElementById("inputEmail");
var contraseña = document.getElementById("inputPassword");
var inicio = document.getElementById("btnInicio");
var divControles = document.getElementById("divControles");
var divInicio = document.getElementById("divInicio");
//Constante para simplificar el código
const auth = firebase.auth();

//ese código se estará cargando en todo momento, cada instante se estará verificando y corriendo sus funciones
$(document).ready(function() {
  //declaro que estare usando una db de firebase
  var database = firebase.database();
  //las variables que estaré usando
  var ledStatus; //el led que manejare con un boton
  var cerca; //si detecto a alguien con mi sensor
  var humedad; //la humedad del cuarto
  var temperatura; //la temperatura del cuarto
  var grados; //los grados que habrá en el cuarto

  database.ref().on("value", function(snap) {
    //empiezo a escuchar informacion de la base de datos
    //tomo los valores que hay en mi base de datos
    ledStatus = snap.val().ledStatus;
    cerca = snap.val().cerca;
    humedad = snap.val().humedad;
    temperatura = snap.val().Temperatura;
    grados = snap.val().temperatura;
    wea = sanp.val().luz
    if (ledStatus == 1) {
      //si en la base de datos tengo 1, significa que seteare el html de la luz a prendido
      $(".lightStatus").text("Luz prendida");
    } else {
      //aqui significa que está apagado
      $(".lightStatus").text("Luz apagada");
    }

    document.getElementById("temp").innerHTML = temperatura; //seteo el elemento de html a lo de mi base de datos
    document.getElementById("hum").innerHTML = humedad; //seteo el elemento de mi html a lo de mi base de datos

    if (cerca == 1) {
      //si detecto a alguien, escribo verdadero en mi html
      document.getElementById("cerca").innerHTML = "Verdadero";
    } else {
      //si no, escribo falso
      document.getElementById("cerca").innerHTML = "Falso";
    }

    if (ledStatus == 90) {
      //si en la base de datos tengo 1, significa que seteare el html de la luz a prendido
      $(".grados").text("90");
    } else {
      //aqui significa que está apagado
      $(".grados").text("0");
    }
  });

  $(".lightButton").click(function() {
    //cuando le doy click a mi boton del led
    //le digo que obtenga la informacion de firebase, porque quiero setear un dato a base de mi boton
    var firebaseRef = firebase
      .database()
      .ref()
      .child("ledStatus");

    //si oprimi el boton y tenia 1, significa que lo estoy apagando e igualo el valor a 0
    if (ledStatus == 1) {
      firebaseRef.set(0);
      ledStatus = 0;
    } else {
      //en otro caso significa que lo estoy prendiendo
      firebaseRef.set(1);
      ledStatus = 1;
    }
  });
  $(".botonGrados").click(function() {
    //cuando le doy click a mi boton de cambiar grados

    var firebaseRef2 = firebase
      .database()
      .ref()
      .child("grados");

    if (grados == 90) {
      firebaseRef2.set(0);
      grados = 0;
    } else {
      firebaseRef2.set(90);
      grados = 90;
    }
  });
});

//Listener para los valores de usuario y contraseña
inicio.addEventListener("click", function() {
  var contraseña_t = contraseña.value;
  var correo_t = correo.value;
  auth
    .signInWithEmailAndPassword(correo_t, contraseña_t)
    .catch(function(error) {
      // Handle Errors here.
      var errorCode = error.code;
      var errorMessage = error.message;
      console.log(errorMessage);
      // ...
    });
});

//?Para cambiar la pantalla
auth.onAuthStateChanged(function(user) {
  if (user) {
    $("#divInicio").addClass("collapse");
    $("#divControles").removeClass("collapse");

    //Escribimos en firebase los valores obtenidos con los listeners
    var fb_rele1 = firebase
      .database()
      .ref()
      .child("rele1");

    var fb_temperatura = firebase
      .database()
      .ref()
      .child("temperatura");
    var fb_movimiento = firebase
      .database()
      .ref()
      .child("movimiento");
    var fb_presencia = firebase
      .database()
      .ref()
      .child("presencia");
    var fb_iluminacion = firebase
      .database()
      .ref()
      .child("iluminacion");
    var fb_red = firebase
      .database()
      .ref()
      .child("red");
    var fb_green = firebase
      .database()
      .ref()
      .child("green");
    var fb_blue = firebase
      .database()
      .ref()
      .child("blue");

    //Variables para relevadores
    var t1 = 0;

    //Bloque de Botones - Reley's
    fb_rele1.on("value", function(snapshot) {
      /*Cambiará el aspecto del botón según el valor a través de las clases
            para dar un aspecto de activo */
      if (snapshot.val() == 1) {
        $("#toogle1")
          .removeClass("btn-default")
          .addClass("btn-success");
        t1 = 1;
      } else {
        $("#toogle1")
          .removeClass("btn-success")
          .addClass("btn-default");
        t1 = 0;
      }
    });
    rele1.addEventListener("click", function() {
      if (t1 == 1) fb_rele1.set(0);
      else fb_rele1.set(1);
    });

    //Bloque de Slider
    var slider1 = new Slider("#ex1", {
      formatter: function(value) {
        return "Current value: " + value;
      }
    });

    fb_red.on("value", function(snapshot) {
      slider1.setValue(snapshot.val());
    });

    slider1.on("slideStop", function() {
      fb_red.set(slider1.getValue());
    });

    //Bloque card - Sensores

    fb_iluminacion.on("value", function(snapshot) {
      iluminacion.innerHTML = snapshot.val() + " % de iluminacion";
    });

    fb_movimiento.on("value", function(snapshot) {
      if (snapshot.val() == 1) {
        movimiento.innerHTML = "Hay Movimiento";
        $("#cardM")
          .addClass("bg-info")
          .addClass("text-white");
      } else {
        movimiento.innerHTML = "No hay Movimiento";
        $("#cardM")
          .removeClass("bg-info")
          .removeClass("text-white");
      }
    });
  } else {
    // Cuando no se ha hecho login, solo muestra esta sección
    $("#divControles").addClass("collapse");
    $("#divInicio").removeClass("collapse");
  }
});

//botón de cerrar sesión
salir.addEventListener("click", function() {
  auth.signOut();
});
