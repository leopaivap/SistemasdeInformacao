import 'dart:io';

void main() {
  stdout.write("Insira um número inteiro: ");
  int intNumber = int.parse(stdin.readLineSync()!);

  stdout.write("Insira um número real: ");
  double realNumber = double.parse(stdin.readLineSync()!);

  print("Número inteiro: $intNumber");
  print("Número real: $realNumber");
}
