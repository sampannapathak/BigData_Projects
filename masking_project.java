import java.util.Random;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
public class Maskemail extends UDF {
private static final String CHAR_LIST =
"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
private static final int RANDOM_STRING_LENGTH = 10;
public Text evaluate(Text ... input) {
if (input == null || input.length == 0) {
return null;
}
else if(input[0] == null || input[0].getLength() == 0){
return new Text(input[0]);
}
else if(input[0].toString().equalsIgnoreCase("null")  || 
input[0].toString().equalsIgnoreCase("UNKNOWN")){
return new Text(input[0]);
}
String email = input[0].toString();
String maskedEmail = null;
int length = 0;
maskedEmail =generateRandomString();
//maskedEmail = "abcd";
if(input.length >= 2){
length = (Integer.parseInt(input[1].toString()) < maskedEmail.length()) ?
Integer.parseInt(input[1].toString()) : maskedEmail.length();
maskedEmail = maskedEmail.substring(0, length).toUpperCase();
}
else{
length = (maskedEmail.length() >= 10) ? 10 : maskedEmail.length();
maskedEmail = maskedEmail.substring(0, length).toUpperCase();
}
return new Text(maskedEmail + "@null.dummy.com");}
private int getRandomNumber() {
int randomInt = 0;
Random randomGenerator = new Random();
randomInt = randomGenerator.nextInt(CHAR_LIST.length());
if (randomInt -1 == -1) {
return randomInt;
} else {
return randomInt -1;
}
}
public String generateRandomString(){
StringBuffer randStr = new StringBuffer();
for(int i=0; i<RANDOM_STRING_LENGTH; i++){
int number = getRandomNumber();
char ch = CHAR_LIST.charAt(number);
randStr.append(ch);
}
return randStr.toString();
}
private String masking_with_md5(String email) {
// TODO Auto-generated method stub
///not required
return null;
}
}

********************************************Udf_numbercode****************************************************************************************


import java.util.Random;
import javax.activation.UnsupportedDataTypeException;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
public class MaskNum extends UDF{
private static final String CHAR_LIST =
"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
private static final int RANDOM_STRING_LENGTH = 12;
public Text evaluate(Text ... input) {
if (input == null || input.length == 0) {
return null;
}
else if(input[0] == null || input[0].getLength() == 0){
return new Text(input[0]);
}
else if(input[0].toString().equalsIgnoreCase("null") ||
input[0].toString().equalsIgnoreCase("UNKNOWN")){
return new Text(input[0]);
}
String num = input[0].toString();
String maskedNum = null;
int length = 0;
maskedNum =generateRandomString();
//maskedEmail = "abcd";
if(input.length >= 2){
length = (Integer.parseInt(input[1].toString()) <maskedNum.length()) ?
Integer.parseInt(input[1].toString()) : maskedNum.length();
maskedNum = maskedNum.substring(0, length).toUpperCase();
}
else{
length = (maskedNum.length() >= 12) ? 12 : maskedNum.length();
maskedNum = maskedNum.substring(0, length).toUpperCase();
}
return new Text(maskedNum);
}
private int getRandomNumber() {
int randomInt = 0;
Random randomGenerator = new Random();
randomInt = randomGenerator.nextInt(CHAR_LIST.length());
if (randomInt - 1 == -1) {
return randomInt;
} else {
return randomInt - 1;
}
}
public String generateRandomString(){
StringBuffer randStr = new StringBuffer();
for(int i=0; i<RANDOM_STRING_LENGTH; i++){
int number = getRandomNumber();
char ch = CHAR_LIST.charAt(number);
randStr.append(ch);
}
return randStr.toString();
}
private String masking_with_md5(String email) {
// TODO Auto-generated method stub
///not required
return null;
}
}