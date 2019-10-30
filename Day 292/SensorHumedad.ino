#include "DHT.h"
#define DHTTYPE DHT11
#define dht_dpin 15
DHT dht(dht_dpin, DHTTYPE);
#include <FirebaseArduino.h>
#include <ESP8266WiFi.h>
#include <ArduinoJson.h>
#define FIREBASE_HOST "semana-i-2837e.firebaseio.com"
#define FIREBASE_AUTH "D1AT0pD1lcxw29oUcfH9ATQg3NkfOoAE89O3K5UX"
#define WIFI_SSID "Tec-IoT"
#define WIFI_PASSWORD "spotless.magnetic.bridge"
void setup() {
  dht.begin();
  Serial.begin(9600);
  Serial.println("HUMEDAD Y TEMPERATURA\n\n");
  delay(700);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  while(WiFi.status()!=WL_CONNECTED){
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi Conectado!");
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}

void loop() {
  // put your main code here, to run repeatedly:
  float h= dht.readHumidity();
  float t= dht.readTemperature();
  Firebase.setInt("Humedad",h);
  Firebase.setInt("Temperatura",t);
  delay(800);
}
