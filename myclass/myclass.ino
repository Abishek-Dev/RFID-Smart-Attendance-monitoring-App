#include <ESP8266WiFi.h>
#include<time.h>
#include <FirebaseArduino.h>
#include <SPI.h>
#include <MFRC522.h>
 #include <WiFiUdp.h>
#include <NTPClient.h>
 
#define SS_PIN D2  //D2
#define RST_PIN D1 //D1
#define FIREBASE_HOST "myclass-f2ffe-default-rtdb.firebaseio.com" //https://wemos4firebase.firebaseio.com/
#define FIREBASE_AUTH "yLChI1uWWknUlcZzycCuBqxcMaCv2mAwcMf4FDoA"
#define WIFI_SSID "abishek airtel"
#define WIFI_PASSWORD "abishek2001"
 
int c=0,x=5;
MFRC522 mfrc522(SS_PIN, RST_PIN);   // Create MFRC522 instance/object.
int variable = 0;

const char *ssid     = "abishek airtel";
const char *password = "abishek2001";

float timeZone = 5 *3600;
int dst=0;
int n = 0;
const long utcOffsetInSeconds = 5200;

time_t now = time(nullptr);
  struct tm* p_tm = localtime(&now);
  int da=p_tm->tm_mday;

  int da2=da;

  String h,m,ti;

WiFiUDP ntpUDP;
NTPClient timeClient(ntpUDP, "asia.pool.ntp.org", utcOffsetInSeconds);

void setup() {

  Serial.begin(9600);
  pinMode(D3, OUTPUT);
  
SPI.begin();      
mfrc522.PCD_Init();   

  WiFi.begin(ssid, password);

  while ( WiFi.status() != WL_CONNECTED ) {
    delay ( 500 );
    Serial.print ( "." );
  }

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);

  timeClient.begin();

  configTime(timeZone, dst, "in.pool.ntp.org","time.nist.gov");
  Serial.println("\nWaiting for internet");

  while(!time(nullptr)){
    Serial.print("*");
    delay(1000);
  }
  Serial.println("");
  Serial.println("Show your card:");
  Serial.println("Time response OK");

  
  time_t now = time(nullptr);
  struct tm* p_tm = localtime(&now);
  int da=p_tm->tm_mday;
  Serial.print(p_tm->tm_mday);
  Serial.print("-");
  Serial.print(p_tm->tm_mon+1);
  Serial.print("-");
  Serial.print(p_tm->tm_year+1900);

  int da2=da;

  int miniute=p_tm->tm_min;
  int m=miniute;
  int hr=p_tm->tm_hour;
  int h = hr;
  if(h>=00 && h<=23){
  if(m>=00 and m<30){
    m+=30;
  }
  else{
    if(m==30){
      h=hr+1;
      m=00;
    }
    if(m==31){
      h=hr+1;
      m=01;
    }
    if(m==32){
      h=hr+1;
      m=02;
    }
    if(m==33){
      h=hr+1;
      m=03;
    }
    if(m==34){
      h=hr+1;
      m=04;
    }
    if(m==35){
      h=hr+1;
      m=05;
    }
    if(m==36){
      h=hr+1;
      m=06;
    }
    if(m==37){
      h=hr+1;
      m=07;
    }
    if(m==38){
      h=hr+1;
      m=8;
    }
    if(m==39){
      h=hr+1;
      m=9;
    }
    if(m==40){
      h=hr+1;
      m=10;
    }
    if(m==41){
      h=hr+1;
      m=11;
    }if(m==42){
      h=hr+1;
      m=12;
    }
    if(m==43){
      h=hr+1;
      m=13;
    }
    if(m==44){
      h=hr+1;
      m=14;
    }
    if(m==45){
      h=hr+1;
      m=15;
    }
    if(m==46){
      h=hr+1;
      m=16;
    }
    if(m==47){
      h=hr+1;
      m=17;
    }
    if(m==48){
      h=hr+1;
      m=18;
    }
    if(m==49){
      h=hr+1;
      m=19;
    }
    if(m==50){
      h=hr+1;
      m=20;
    }
    if(m==51){
      h=hr+1;
      m=21;
    }
    if(m==52){
      h=hr+1;
      m=22;
    }
    if(m==53){
      h=hr+1;
      m=23;
    }
    if(m==54){
      h=hr+1;
      m=24;
    }
    if(m==55){
      h=hr+1;
      m=25;
    }
    if(m==56){
      h=hr+1;
      m=26;
    }if(m==57){
      h=hr+1;
      m=27;
    }
    if(m==58){
      h=hr+1;
      m=28;
    }
    if(m==59){
      h=hr+1;
      m=29;
    }
  }
  }
  else{
    h=00;
  }
  

  Serial.print(" ");
  Serial.print(h);
  Serial.print(":");
  
  Serial.print(m);
  Serial.print(":");
  Serial.print(p_tm->tm_sec);
  String s=":"+p_tm->tm_sec;
  String ti=h+":"+m+s;
  delay(1000);

}

void loop() {
  time_t now = time(nullptr);
  struct tm* p_tm = localtime(&now);
  String date=String(String(p_tm->tm_mday)+'-'+String(int(p_tm->tm_mon+1))+'-'+String(int(p_tm->tm_year+1900)));
  int miniute=p_tm->tm_min;
  int m=miniute;
  int hr=p_tm->tm_hour;
  int h = hr;

  
  if(h>=00 && h<=23){
  if(m>=00 and m<30){
    m+=30;
  }
  else{
    if(m==30){
      h=hr+1;
      m=00;
    }
    if(m==31){
      h=hr+1;
      m=01;
    }
    if(m==32){
      h=hr+1;
      m=02;
    }
    if(m==33){
      h=hr+1;
      m=03;
    }
    if(m==34){
      h=hr+1;
      m=04;
    }
    if(m==35){
      h=hr+1;
      m=05;
    }
    if(m==36){
      h=hr+1;
      m=06;
    }
    if(m==37){
      h=hr+1;
      m=07;
    }
    if(m==38){
      h=hr+1;
      m=8;
    }
    if(m==39){
      h=hr+1;
      m=9;
    }
    if(m==40){
      h=hr+1;
      m=10;
    }
    if(m==41){
      h=hr+1;
      m=11;
    }if(m==42){
      h=hr+1;
      m=12;
    }
    if(m==43){
      h=hr+1;
      m=13;
    }
    if(m==44){
      h=hr+1;
      m=14;
    }
    if(m==45){
      h=hr+1;
      m=15;
    }
    if(m==46){
      h=hr+1;
      m=16;
    }
    if(m==47){
      h=hr+1;
      m=17;
    }
    if(m==48){
      h=hr+1;
      m=18;
    }
    if(m==49){
      h=hr+1;
      m=19;
    }
    if(m==50){
      h=hr+1;
      m=20;
    }
    if(m==51){
      h=hr+1;
      m=21;
    }
    if(m==52){
      h=hr+1;
      m=22;
    }
    if(m==53){
      h=hr+1;
      m=23;
    }
    if(m==54){
      h=hr+1;
      m=24;
    }
    if(m==55){
      h=hr+1;
      m=25;
    }
    if(m==56){
      h=hr+1;
      m=26;
    }if(m==57){
      h=hr+1;
      m=27;
    }
    if(m==58){
      h=hr+1;
      m=28;
    }
    if(m==59){
      h=hr+1;
      m=29;
    }
  }
  }
  else{
    h=00;
  }
  String ti=String(String(h)+':'+String(m)+':'+String(p_tm->tm_sec));

  
  
 if ( ! mfrc522.PICC_IsNewCardPresent()) 
{
return;
}
if ( ! mfrc522.PICC_ReadCardSerial()) 
{
return;
}
Serial.println();
String content= "";
byte letter;
for (byte s = 0; s < mfrc522.uid.size; s++) 
{
  content.concat(String(mfrc522.uid.uidByte[s] < 0x10 ? " 0" : " "));
     content.concat(String(mfrc522.uid.uidByte[s], HEX));
 
! mfrc522.PICC_HaltA();
  
}
Serial.print("Here");
 Serial.println(content);
 digitalWrite(D3, HIGH);
  delay(3000);
  digitalWrite(D3, LOW);
 int d1=Firebase.getInt("/Attendance Log/7a 28 06 1d/count");
 int d2=Firebase.getInt("/Attendance Log/8a 95 85 3b/count");
 if(da2!=da){
    d1=0;
    d2=0;
    da2=da;
 }
if(content==" 7a 28 06 1d"){
 Firebase.setString("/Attendance Log/7a 28 06 1d/Name","Karthikeyan M");
 Firebase.setString("/Attendance Log/7a 28 06 1d/RegisterNo","1518102054");
 Firebase.setString("/Attendance Log/7a 28 06 1d/classandSec","CSE-A"); 
 Firebase.setString("/Attendance Log/7a 28 06 1d/date",date);
 Firebase.setString("/Attendance Log/7a 28 06 1d/time",ti);
  Firebase.setInt("/Attendance Log/7a 28 06 1d/count",d1+1);

//  Firebase.setString("/Log/7a 28 06 1d/Name","Karthikeyan M");
// Firebase.setString("/Log/7a 28 06 1d/RegisterNo","1518102054");
// Firebase.setString("/Log/7a 28 06 1d/classandSec","CSE-A"); 
// Firebase.pushString("/Log/7a 28 06 1d/date/"+date+"/time",ti);
//  Firebase.pushInt("/Log/7a 28 06 1d/date/"+date+"/count",d1+1);
  
}

 if(content==" 8a 95 85 3b"){
  Firebase.setString("/Attendance Log/8a 95 85 3b/Name","Gowcickram");
 Firebase.setString("/Attendance Log/8a 95 85 3b/RegisterNo","1518102034");
 Firebase.setString("/Attendance Log/8a 95 85 3b/Class","CSE-A"); 
  Firebase.setString("/Attendance Log/8a 95 85 3b/date",date);
  Firebase.setString("/Attendance Log/7a 28 06 1d/time",ti);
  Firebase.setInt("/Attendance Log/8a 95 85 3b/count",d2+1);

//  Firebase.setString("/Log/8a 95 85 3b/Name","Karthikeyan M");
// Firebase.setString("/Log/8a 95 85 3b/RegisterNo","1518102054");
// Firebase.setString("/Log/8a 95 85 3b/classandSec","CSE-A"); 
// Firebase.pushString("/Log/8a 95 85 3b/date",date);
// Firebase.pushString("/Log/8a 95 85 3b/date/"+date+"/time",ti);
//  Firebase.pushInt("/Log/8a 95 85 3b/date/"+date+"/count",d1+1);
//  digitalWrite(D3, HIGH);
//  delay(3000);
//  digitalWrite(D3, LOW);
 }
 
}
