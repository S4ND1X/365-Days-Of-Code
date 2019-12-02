#include <NewPing.h>

#include <Servo.h>

Servo servo;
Servo servis;

int pirPin = 12;

//Foquito peaton
int ledPeaton = 13;


NewPing sonar (4, 4, 15); //pin 4en ambos, 15 cm de distancia maxima
int btnPea = 3,
    prox = 4,
    ledRed = 7,
    ledBlue = 5,
    ledYellow = 6;
void setup() {
  Serial.begin(9600);

  //Codigo del pir
  pinMode(pirPin, INPUT);
  //Foquito peaton
  pinMode(ledPeaton, OUTPUT);
  servo.attach(9);
  servis.attach(10);

  // put your setup code here, to run once:
  pinMode(btnPea, INPUT_PULLUP);
  pinMode(prox, INPUT);
  pinMode(ledBlue, OUTPUT);
  pinMode(ledRed, OUTPUT);
  pinMode(ledYellow, OUTPUT);

}

void loop() {

  servo.write(analogRead(A0) / 10);
  servis.write(102 - analogRead(A0) / 10);
  if (digitalRead(btnPea) == LOW) {
    digitalWrite(ledYellow, HIGH);
    delay(1000);
    digitalWrite(ledRed, LOW);
    digitalWrite(ledYellow, LOW);
    digitalWrite(ledBlue, HIGH);
    delay(5000);
    digitalWrite(ledRed, LOW);
    digitalWrite(ledYellow, HIGH);
    digitalWrite(ledBlue, LOW);
    delay(3000);
    digitalWrite(ledRed, HIGH);
    digitalWrite(ledYellow, LOW);
    digitalWrite(ledBlue, LOW);
  } else if (sonar.ping_cm() <= 15 && sonar.ping_cm() != 0) {
    delay(1000);
    while (sonar.ping_cm() <= 15 && sonar.ping_cm() != 0) {
      digitalWrite(ledRed, LOW);
      digitalWrite(ledYellow, LOW);
      digitalWrite(ledBlue, HIGH);
      delay(300);
    }
    digitalWrite(ledRed, LOW);
    digitalWrite(ledYellow, HIGH);
    digitalWrite(ledBlue, LOW);
    delay(1000);
    digitalWrite(ledRed, HIGH);
    digitalWrite(ledYellow, LOW);
    digitalWrite(ledBlue, LOW);

  } else {
    digitalWrite(ledRed, HIGH);
    digitalWrite(ledYellow, LOW);
    digitalWrite(ledBlue, LOW);
  }

  int pirValue = digitalRead(pirPin);
  if (pirValue == HIGH) {
    digitalWrite(ledPeaton, HIGH);
  }
  // put your main code here, to run repeatedly:

}
