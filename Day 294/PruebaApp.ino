#include <FirebaseArduino.h>
#include <ESP8266WiFi.h>
#define FIREBASE_HOST "semanai-4ea99.firebaseio.com"
#define FIREBASE_AUTH "az4SQ6BPBqScFTFzeciectZz71Axmmc6XlDvEyHJ"
#define WIFI_SSID "Tec-IoT"
#define WIFI_PASSWORD "spotless.magnetic.bridge"
int Led = 0;
void setup() {
  //Declaración de Puertos
  pinMode(Led,OUTPUT);
  pinMode(A0,INPUT);
  Serial.begin(9600);
  WiFi.begin(WIFI_SSID,WIFI_PASSWORD);
  while(WiFi.status() != WL_CONNECTED){
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("Wifi Conectado!");
  Firebase.begin(FIREBASE_HOST,FIREBASE_AUTH);
}

void loop() {
  Serial.println("._.");
  Serial.println(Firebase.getInt("Led"));
 if(Firebase.getInt("Led") == 1){
  digitalWrite(Led,HIGH);
 }else{
  digitalWrite(Led,LOW);
 }
 int luz=analogRead(A0);
  luz=map(luz,650,10,100,0);
  //Serial.println(luz);
  Firebase.setInt("Luz",luz);
}
