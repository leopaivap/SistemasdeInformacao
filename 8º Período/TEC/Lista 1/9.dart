import 'dart:io';

void main() {
  stdout.write("Insira um número inteiro: ");
  int number = int.parse(stdin.readLineSync()!);

  int factorial = 1;
  for (int i = 1; i <= number; i++) {
    factorial *= i;
  }

  print("Fatorial de $number é $factorial");
}
