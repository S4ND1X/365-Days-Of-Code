#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>
#define FIREBASE_HOST "reto-2-semana-i.firebaseio.com"
#define FIREBASE_AUTH "jlxVNTxKAmwMtP1lcQMGzXnkjJuZtpohEcezGxvm"
#define WIFI_SSID "Tec-IoT"
#define WIFI_PASSWORD "spotless.magnetic.bridge"



//Libreria de LCD
#include <LiquidCrystal_I2C.h>

//Libreria Humedad
#include "DHT.h"
#define DHTTYPE DHT11
#define dht_dpin 15
DHT dht(dht_dpin, DHTTYPE);

//Sensor del pir
int sensorPin = 13;
// Boton pin
int botonPin = 0;
//Declarar el contador
int cont = 0;

//Ultrasonico
int disparador = 2;
int entrada = 14;

//Se crea el objeto LCD direccion en la direccion de memoria y en columas y filas
LiquidCrystal_I2C lcd(0x3F, 20,4);

void setup() {
  //Ultrasonico Declaracion
  pinMode(disparador,OUTPUT);
  pinMode(entrada,INPUT);
  //Conectarse a internet y FireBase
  WiFi.begin(WIFI_SSID,WIFI_PASSWORD);
  while(WiFi.status() != WL_CONNECTED){
    delay(500);
    Serial.print(".");
  }
  Serial.print("");
  Serial.print("Wifi Connected");
  Firebase.begin(FIREBASE_HOST,FIREBASE_AUTH);
  //Definir el modo de el sensor pir
  pinMode(sensorPin, INPUT);
  
  //Inicializar el lcd
  lcd.begin();
  lcd.backlight();
  lcd.clear();
  lcd.home();
  
  //Inicializar el Humedad
  dht.begin();
  
  //Inicializar el boton
  pinMode(botonPin, INPUT_PULLUP);
  
  Serial.begin(9600);
}

void loop() {
  if(digitalRead(botonPin) == 0){
    cont = cont + 1;
    cont = cont%4;
  }
  if(cont == 0){
    //Leer el estado del Movimiento
    long statePir = digitalRead(sensorPin);
    Firebase.setInt("Movimiento",statePir);
    if(statePir == LOW){
      lcd.print("No me muevo");
      }else{
        lcd.print("Me Muevo"); 
      }
  }else if(cont == 1){
    //Leer la temperatura y humedad
    float humedad = dht.readHumidity();
    float temperatura = dht.readTemperature();
    //Imprimir la humedad y temperatura
    lcd.print("Humedad = ");
    lcd.print(humedad);
    Firebase.setFloat("Humedad",humedad);
    lcd.setCursor(0,2);
    lcd.print("Temperatura = ");
    lcd.print(temperatura);
    Firebase.setFloat("Temperatura",temperatura);
  }else if(cont == 2){
    int luz=analogRead(A0);
    luz=map(luz,650,10,100,0);
    Firebase.setInt("Luz",luz);
    if(luz > 100){
      lcd.print("Hay mucha luz");
    }else{
      lcd.print("No hay tanta luz");
    }
  }else if(cont == 3){
    long tiempo;
    float distancia;

    digitalWrite(disparador,HIGH);
    delayMicroseconds(10);
    digitalWrite(disparador,LOW);

    tiempo = (pulseIn(entrada,HIGH)/2);
    distancia = float(tiempo * 0.0343);
    lcd.print(distancia);
    Firebase.setFloat("Distancia",distancia);
    Serial.println(distancia);
  }
  delay(350);
  lcd.clear();
}
