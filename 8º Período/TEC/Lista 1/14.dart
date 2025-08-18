import 'dart:io';

bool isLeapYear(int year) {
  return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
}

void main() {
  stdout.write("Insira um ano: ");
  int year = int.parse(stdin.readLineSync()!);

  if (isLeapYear(year)) {
    print("$year é bissexto");
  } else {
    print("$year não é bissexto");
  }
}
